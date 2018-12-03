package br.com.rogerbleggi.calcard.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rogerbleggi.calcard.exception.ResourceNotFoundException;
import br.com.rogerbleggi.calcard.model.Cliente;
import br.com.rogerbleggi.calcard.repository.ClienteRepository;
import br.com.rogerbleggi.calcard.service.ClienteService;
import br.com.rogerbleggi.calcard.service.dto.ClienteDTO;
import br.com.rogerbleggi.calcard.service.mapper.ClienteMapper;

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
			ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
			return clienteRepository.findAll(Example.of(ClienteMapper.convertToCliente(clienteDTO), matcher)).stream()
					.map(cliente -> ClienteMapper.convertToClienteDTO(cliente)).collect(Collectors.toList());
		} else
			return clienteRepository.findAll().stream().map(cliente -> ClienteMapper.convertToClienteDTO(cliente))
					.collect(Collectors.toList());
	}

	@Override
	public ClienteDTO save(ClienteDTO clienteDTO) {
		try {
			Cliente clienteBase = entityManager.createQuery("select c from Cliente c where c.cpf = :cpf", Cliente.class)
					.setParameter("cpf", clienteDTO.getCpf()).getSingleResult();
			return update(clienteDTO, clienteBase);
		} catch (NoResultException e) {
			return ClienteMapper
					.convertToClienteDTO(clienteRepository.saveAndFlush(ClienteMapper.convertToCliente(clienteDTO)));
		}
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
		return update(clienteDTO, clienteExistente);
	}

	private ClienteDTO update(ClienteDTO clienteDTO, Cliente clienteExistente) {
		Cliente clienteAtualizar = ClienteMapper.convertToCliente(clienteDTO);
		BeanUtils.copyProperties(clienteAtualizar, clienteExistente,"id");
		return ClienteMapper.convertToClienteDTO(clienteExistente);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
