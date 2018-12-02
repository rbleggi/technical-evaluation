package br.com.rogerbleggi.calcard.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rogerbleggi.calcard.model.EnumAnalise;
import br.com.rogerbleggi.calcard.model.EnumEstadoCivil;
import br.com.rogerbleggi.calcard.model.Proposta;
import br.com.rogerbleggi.calcard.repository.PropostaRepository;
import br.com.rogerbleggi.calcard.service.AnaliseCreditoService;
import br.com.rogerbleggi.calcard.service.dto.ClienteDTO;
import br.com.rogerbleggi.calcard.service.dto.PropostaDTO;
import br.com.rogerbleggi.calcard.service.mapper.PropostaMapper;

@Service
@Transactional
public class PropostaServiceImpl implements AnaliseCreditoService {

	private static final String REPROVADO_PELA_POLITICA_DE_CREDITO = "reprovado pela política de crédito";
	private static final String RENDA_BAIXA = "renda baixa";

	@Autowired
	private PropostaRepository propostaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PropostaDTO analiseCredito(ClienteDTO clienteDTO) {
		return PropostaMapper.convertToPropostaDTO(propostaRepository.save(PropostaMapper.convertToProposta(analise(clienteDTO))));
	}

	@Transactional(readOnly = true)
	private PropostaDTO findByClienteId(Long clienteId) {
		TypedQuery<Proposta> query = entityManager
				.createQuery("select p from Proposta p where p.cliente.id = :clienteId", Proposta.class);
		query.setParameter("clienteId", clienteId);
		return PropostaMapper.convertToPropostaDTO(query.getSingleResult());
	}

	/**
	 * rendaMinima = 500 fatorRiscoCasado = 1 fatorRiscoSolteiro = 2 fatorRiscoViuva
	 * = 3 Cálculo do Limite fatorLimite = (renda - rendaMinima) / fatorEstadoCivil
	 * / (dependentes + cliente)
	 * 
	 * @param ClienteDTO
	 * @return PropostaDTO
	 */

	private PropostaDTO analise(ClienteDTO clienteDTO) {
		PropostaDTO propostaDTO = null;

		try {
			propostaDTO = findByClienteId(clienteDTO.getId());
		} catch (NoResultException e) {
			if (propostaDTO == null)
				propostaDTO = new PropostaDTO();
		}

		propostaDTO.setCliente(clienteDTO);

		Integer rendaMinima = 500;
		Integer fatorRiscoCasado = 1;
		Integer fatorRiscoSolteiro = 2;
		Integer fatorRiscoViuva = 3;

		Integer renda = clienteDTO.getRenda();
		Integer dependentes = clienteDTO.getDependentes();
		String estadoCivil = clienteDTO.getEstadoCivil();

		if (renda <= rendaMinima) {
			propostaDTO.setLimite(RENDA_BAIXA);
			propostaDTO.setAnalise(EnumAnalise.NEGADO.toString());
			return propostaDTO;
		}

		boolean isViuvaComDependentes = EnumEstadoCivil.VIUVA.toString().equals(estadoCivil) && dependentes > 0;
		boolean isDivorciado = EnumEstadoCivil.DIVORCIADO.toString().equals(estadoCivil);
		if (isViuvaComDependentes || isDivorciado) {
			propostaDTO.setLimite(REPROVADO_PELA_POLITICA_DE_CREDITO);
			propostaDTO.setAnalise(EnumAnalise.NEGADO.toString());
			return propostaDTO;
		}

		if (EnumEstadoCivil.CASADO.toString().equals(estadoCivil))
			propostaDTO
					.setLimite(getValorLimite(calcularFatorLimite(rendaMinima, fatorRiscoCasado, renda, dependentes)));
		if (EnumEstadoCivil.SOLTEIRO.toString().equals(estadoCivil))
			propostaDTO.setLimite(
					getValorLimite(calcularFatorLimite(rendaMinima, fatorRiscoSolteiro, renda, dependentes)));
		if (EnumEstadoCivil.VIUVA.toString().equals(estadoCivil))
			propostaDTO
					.setLimite(getValorLimite(calcularFatorLimite(rendaMinima, fatorRiscoViuva, renda, dependentes)));

		propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		return propostaDTO;
	}

	private String getValorLimite(Integer resultado) {
		if (resultado > 2000)
			return "superior 2000";
		if (resultado > 1500 && resultado <= 2000)
			return "entre 1500 - 2000";
		if (resultado > 1000 && resultado <= 1500)
			return "entre 1000 - 1500";
		if (resultado > 500 && resultado <= 1000)
			return "entre 500 - 1000";
		if (resultado > 100 && resultado <= 500)
			return "entre 100 - 500";
		return "";
	}

	private int calcularFatorLimite(Integer rendaMinima, Integer fatorEstadoCivil, Integer renda, Integer dependentes) {
		Integer cliente = 1;
		return (renda - rendaMinima) / fatorEstadoCivil / (dependentes + cliente);
	}

	private PropostaDTO analiseApenasPelosFilho(ClienteDTO clienteDTO, Integer renda, Integer dependentes) {
		PropostaDTO propostaDTO = null;
		try {
			propostaDTO = findByClienteId(clienteDTO.getId());
		} catch (NoResultException e) {
			if (propostaDTO == null)
				propostaDTO = new PropostaDTO();
		}

		propostaDTO.setCliente(clienteDTO);

		Integer valorFilho = 250;

		if (renda > 2500)
			valorFilho = 500;

		Integer rendaDiff = renda - valorFilho * dependentes;

		if (rendaDiff >= 7000) {
			propostaDTO.setLimite("superior 2000");
			propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		}

		if (rendaDiff >= 6000 && rendaDiff < 7000) {
			propostaDTO.setLimite("entre 1500 - 2000");
			propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		}

		if (rendaDiff >= 3500 && rendaDiff < 6000) {
			propostaDTO.setLimite("entre 1000 - 1500");
			propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		}

		if (rendaDiff > 2000 && rendaDiff < 3500) {
			propostaDTO.setLimite("entre 500 - 1000");
			propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		}

		if (rendaDiff == 2000) {
			propostaDTO.setLimite("entre 100 - 500");
			propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
		}

		if (rendaDiff > 500 && rendaDiff < 2000)
			if (dependentes > 0) {
				propostaDTO.setLimite(REPROVADO_PELA_POLITICA_DE_CREDITO);
				propostaDTO.setAnalise(EnumAnalise.NEGADO.toString());
			} else {
				propostaDTO.setLimite("entre 100 - 500");
				propostaDTO.setAnalise(EnumAnalise.APROVADO.toString());
			}
		if (rendaDiff <= 500) {
			propostaDTO.setLimite(RENDA_BAIXA);
			propostaDTO.setAnalise(EnumAnalise.NEGADO.toString());
		}

		return propostaDTO;
	}
}
