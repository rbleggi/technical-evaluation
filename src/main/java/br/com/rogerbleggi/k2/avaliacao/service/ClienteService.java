package br.com.rogerbleggi.k2.avaliacao.service;

import java.util.List;

import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

public interface ClienteService {

	public List<ClienteDTO> findAll();

	public ClienteDTO create(ClienteDTO clienteDTO);

	public ClienteDTO findById(Long id);

	public ClienteDTO update(Long id, ClienteDTO clienteDTO);

	public void delete(Long id);
	
}
