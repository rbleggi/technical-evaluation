package br.com.rogerbleggi.calcard.service.mapper;

import br.com.rogerbleggi.calcard.model.EnumAnalise;
import br.com.rogerbleggi.calcard.model.Proposta;
import br.com.rogerbleggi.calcard.service.dto.PropostaDTO;

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
