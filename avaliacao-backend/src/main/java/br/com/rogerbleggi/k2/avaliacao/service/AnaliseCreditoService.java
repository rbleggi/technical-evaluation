package br.com.rogerbleggi.k2.avaliacao.service;

import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;
import br.com.rogerbleggi.k2.avaliacao.service.dto.PropostaDTO;

public interface AnaliseCreditoService {

	public PropostaDTO analiseCredito(ClienteDTO clienteDTO);
	
}
