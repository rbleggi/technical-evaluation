package br.com.rogerbleggi.k2.avaliacao.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerbleggi.k2.avaliacao.service.ClienteService;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

@RestController
@CrossOrigin
@RequestMapping("api/v1/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(ClienteDTO clienteDTO) {
		return ResponseEntity.ok(clienteService.filter(clienteDTO));
	}

	@PostMapping
	public @ResponseBody ClienteDTO create(@RequestBody @Valid ClienteDTO clienteDTO) {
		return clienteService.save(clienteDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> getUserById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(clienteService.findOne(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.ok(clienteService.update(id, clienteDTO));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
		try {
			clienteService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

}