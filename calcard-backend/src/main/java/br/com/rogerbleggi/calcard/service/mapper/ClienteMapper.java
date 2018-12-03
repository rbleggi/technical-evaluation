package br.com.rogerbleggi.calcard.service.mapper;

import br.com.rogerbleggi.calcard.model.Cliente;
import br.com.rogerbleggi.calcard.model.EnumEstadoCivil;
import br.com.rogerbleggi.calcard.model.EnumSexo;
import br.com.rogerbleggi.calcard.service.dto.ClienteDTO;

public class ClienteMapper {

	public static Cliente convertToCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDependentes(clienteDTO.getDependentes());
		cliente.setEstado(clienteDTO.getEstado());
		if (clienteDTO.getEstadoCivil() != null)
			cliente.setEstadoCivil(EnumEstadoCivil.valueOf(clienteDTO.getEstadoCivil()));
		cliente.setId(clienteDTO.getId());
		cliente.setIdade(clienteDTO.getIdade());
		cliente.setNome(clienteDTO.getNome());
		cliente.setRenda(clienteDTO.getRenda());
		if (clienteDTO.getSexo() != null)
			cliente.setSexo(EnumSexo.valueOf(clienteDTO.getSexo()));
		return cliente;
	}

	public static ClienteDTO convertToClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDependentes(cliente.getDependentes());
		clienteDTO.setEstado(cliente.getEstado());
		if (cliente.getEstadoCivil() != null)
			clienteDTO.setEstadoCivil(cliente.getEstadoCivil().toString());
		clienteDTO.setId(cliente.getId());
		clienteDTO.setIdade(cliente.getIdade());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setRenda(cliente.getRenda());
		if (cliente.getSexo() != null)
			clienteDTO.setSexo(cliente.getSexo().toString());
		return clienteDTO;
	}

}
