package br.com.rogerbleggi.calcard.service;

import br.com.rogerbleggi.calcard.service.dto.ClienteDTO;
import br.com.rogerbleggi.calcard.service.dto.PropostaDTO;

public interface AnaliseCreditoService {

	public PropostaDTO analiseCredito(ClienteDTO clienteDTO);
	
}
