package br.com.rogerbleggi.k2.avaliacao.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rogerbleggi.k2.avaliacao.exception.ResourceNotFoundException;
import br.com.rogerbleggi.k2.avaliacao.model.Cliente;
import br.com.rogerbleggi.k2.avaliacao.repository.ClienteRepository;
import br.com.rogerbleggi.k2.avaliacao.service.ClienteService;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;
import br.com.rogerbleggi.k2.avaliacao.service.mapper.ClienteMapper;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public List<ClienteDTO> filter(ClienteDTO clienteDTO) {
		if (clienteDTO != null) {
			ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnorePaths("id", "nome",
					"idade", "sexo", "estado_civil", "estado", "qtd_Dependentes", "renda");
			return clienteRepository.findAll(Example.of(ClienteMapper.convertToCliente(clienteDTO), matcher)).stream()
					.map(cliente -> ClienteMapper.convertToClienteDTO(cliente)).collect(Collectors.toList());
		} else
			return clienteRepository.findAll().stream().map(cliente -> ClienteMapper.convertToClienteDTO(cliente))
					.collect(Collectors.toList());

	}

	@Override
	public ClienteDTO save(ClienteDTO clienteDTO) {
		return ClienteMapper.convertToClienteDTO(clienteRepository.saveAndFlush(ClienteMapper.convertToCliente(clienteDTO)));
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteDTO findOne(Long id) {
		return ClienteMapper.convertToClienteDTO(
				clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id)));
	}

	@Override
	public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
		Cliente clienteExistente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));
		Cliente clienteAtualizar = ClienteMapper.convertToCliente(clienteDTO);
		BeanUtils.copyProperties(clienteAtualizar, clienteExistente);
		return ClienteMapper.convertToClienteDTO(clienteExistente);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
