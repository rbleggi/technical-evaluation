package br.com.rogerbleggi.k2.avaliacao.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerbleggi.k2.avaliacao.service.ClienteService;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

@RestController
@CrossOrigin
@RequestMapping("api/v1/")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "clientes")
	public List<ClienteDTO> findAll() {
		return clienteService.findAll();
	}

	@PostMapping(value = "cliente")
	public ClienteDTO create(@RequestBody @Valid ClienteDTO clienteDTO) {
		return clienteService.create(clienteDTO);
	}

	@GetMapping(value = "cliente/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PutMapping(value = "cliente/{id}")
	public ClienteDTO update(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
		return clienteService.update(id, clienteDTO);
	}

	@DeleteMapping(value = "cliente/{id}")
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}

}