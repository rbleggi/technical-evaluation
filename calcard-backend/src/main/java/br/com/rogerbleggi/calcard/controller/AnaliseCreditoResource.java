package br.com.rogerbleggi.calcard.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerbleggi.calcard.service.AnaliseCreditoService;
import br.com.rogerbleggi.calcard.service.dto.ClienteDTO;
import br.com.rogerbleggi.calcard.service.dto.PropostaDTO;

@RestController
@CrossOrigin
@RequestMapping("api/v1/analisecredito")
public class AnaliseCreditoResource {

	@Autowired
	private AnaliseCreditoService analiseCreditoService;

	@PostMapping
	public @ResponseBody ResponseEntity<PropostaDTO> create(ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.ok(analiseCreditoService.analiseCredito(clienteDTO));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

}