package br.com.rogerbleggi.k2.avaliacao.service.mapper;

import br.com.rogerbleggi.k2.avaliacao.model.EnumAnalise;
import br.com.rogerbleggi.k2.avaliacao.model.Proposta;
import br.com.rogerbleggi.k2.avaliacao.service.dto.PropostaDTO;

public class PropostaMapper {

	public static Proposta convertToProposta(PropostaDTO propostaDTO) {
		Proposta proposta = new Proposta();
		proposta.setAnalise(EnumAnalise.valueOf(propostaDTO.getAnalise()));
		proposta.setCliente(ClienteMapper.convertToCliente(propostaDTO.getCliente()));
		proposta.setLimite(propostaDTO.getLimite());
		proposta.setId(propostaDTO.getId());
		return proposta;
	}

	public static PropostaDTO convertToPropostaDTO(Proposta proposta) {
		PropostaDTO propostaDTO = new PropostaDTO();
		propostaDTO.setAnalise(proposta.getAnalise().toString());
		propostaDTO.setCliente(ClienteMapper.convertToClienteDTO(proposta.getCliente()));
		propostaDTO.setLimite(proposta.getLimite());
		propostaDTO.setId(proposta.getId());
		return propostaDTO;
	}

}
