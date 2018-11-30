package br.com.rogerbleggi.k2.avaliacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rogerbleggi.k2.avaliacao.repository.ClienteRepository;
import br.com.rogerbleggi.k2.avaliacao.service.ClienteService;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;
import br.com.rogerbleggi.k2.avaliacao.service.mapper.ClienteMapper;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<ClienteDTO> findAll() {
		return StreamSupport.stream(clienteRepository.findAll().spliterator(), false).map(cliente -> ClienteMapper.convertToClienteDTO(cliente)).collect(Collectors.toList());
	}

	@Override
	public ClienteDTO create(ClienteDTO clienteDTO) {
		return ClienteMapper.convertToClienteDTO(clienteRepository.save(ClienteMapper.convertToCliente(clienteDTO)));
	}

	@Override
	public ClienteDTO findById(Long id) {
		return ClienteMapper.convertToClienteDTO(clienteRepository.findById(id).get());
	}

	@Override
	public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
		return ClienteMapper.convertToClienteDTO(clienteRepository.save(ClienteMapper.convertToCliente(clienteDTO)));
	}

	@Override
	public void delete(Long id) {
		clienteRepository.delete(clienteRepository.findById(id).get());
	}

}
