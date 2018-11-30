package br.com.rogerbleggi.k2.avaliacao.service.mapper;

import br.com.rogerbleggi.k2.avaliacao.domain.Cliente;
import br.com.rogerbleggi.k2.avaliacao.domain.EnumEstadoCivil;
import br.com.rogerbleggi.k2.avaliacao.domain.EnumSexo;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

public class ClienteMapper {

	public static Cliente convertToCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDependentes(clienteDTO.getDependentes());
		cliente.setEstado(clienteDTO.getEstado());
		cliente.setEstadoCivil(EnumEstadoCivil.valueOf(clienteDTO.getEstadoCivil()));
		cliente.setId(clienteDTO.getId());
		cliente.setIdade(clienteDTO.getIdade());
		cliente.setNome(clienteDTO.getNome());
		cliente.setRenda(clienteDTO.getRenda());
		cliente.setSexo(EnumSexo.valueOf(clienteDTO.getSexo()));
		return cliente;
	}

	public static ClienteDTO convertToClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDependentes(cliente.getDependentes());
		clienteDTO.setEstado(cliente.getEstado());
		clienteDTO.setEstadoCivil(cliente.getEstadoCivil().toString());
		clienteDTO.setId(cliente.getId());
		clienteDTO.setIdade(cliente.getIdade());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setRenda(cliente.getRenda());
		clienteDTO.setSexo(cliente.getSexo().toString());
		return clienteDTO;
	}

}
