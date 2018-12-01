package br.com.rogerbleggi.k2.avaliacao.service;

import java.util.List;

import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

public interface ClienteService {

	public List<ClienteDTO> filter(ClienteDTO clienteDTO);

	public ClienteDTO save(ClienteDTO clienteDTO);

	public ClienteDTO findOne(Long id);
	
	public ClienteDTO update(Long id, ClienteDTO clienteDTO);

	public void delete(Long id);
	
}
