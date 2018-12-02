package br.com.rogerbleggi.calcard.service.impl;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.rogerbleggi.calcard.model.Cliente;
import br.com.rogerbleggi.calcard.model.EnumEstadoCivil;
import br.com.rogerbleggi.calcard.repository.PropostaRepository;
import br.com.rogerbleggi.calcard.service.AnaliseCreditoService;
import br.com.rogerbleggi.calcard.service.dto.PropostaDTO;
import br.com.rogerbleggi.calcard.service.mapper.ClienteMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class AnaliseCredidoServiceIntegration {

	private static final String REPROVADO_PELA_POLITICA_DE_CREDITO = "reprovado pela política de crédito";
	private static final String RENDA_BAIXA = "renda baixa";

	@Autowired
	private AnaliseCreditoService analiseCreditoService;

	@Autowired
	private PropostaRepository propostaRepository;

	@PersistenceContext
	private EntityManager em;

	@Before
	public void before() {
		em.createNativeQuery("delete from cliente");
	}

	@Test
	public void testeAriel() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.VIUVA);
		cliente.setRenda(10000);
		cliente.setDependentes(0);
		cliente.setNome("Ariel");
		cliente.setCpf("123");
		em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("superior 2000", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeDinae() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setRenda(10000);
		cliente.setDependentes(1);
		cliente.setNome("Dinae");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("superior 2000", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeJose() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setRenda(8000);
		cliente.setDependentes(2);
		cliente.setNome("Jose");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("superior 2000", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testePedro() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setRenda(8000);
		cliente.setDependentes(3);
		cliente.setNome("Pedro");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 1500 - 2000", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeBruno() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setRenda(8000);
		cliente.setDependentes(5);
		cliente.setNome("Bruno");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 1000 - 1500", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testePaula() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setRenda(5000);
		cliente.setDependentes(3);
		cliente.setNome("Paula");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 1000 - 1500", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeLucas() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.SOLTEIRO);
		cliente.setRenda(2500);
		cliente.setDependentes(0);
		cliente.setNome("Lucas");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 500 - 1000", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeLuci() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.SOLTEIRO);
		cliente.setRenda(2500);
		cliente.setDependentes(2);
		cliente.setNome("Luci");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 100 - 500", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeMaria() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.DIVORCIADO);
		cliente.setRenda(2000);
		cliente.setDependentes(1);
		cliente.setNome("Maria");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals(REPROVADO_PELA_POLITICA_DE_CREDITO,
				propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeJoao() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.DIVORCIADO);
		cliente.setRenda(2000);
		cliente.setDependentes(2);
		cliente.setNome("Joao");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals(REPROVADO_PELA_POLITICA_DE_CREDITO,
				propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeSuzan() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.VIUVA);
		cliente.setRenda(1500);
		cliente.setDependentes(3);
		cliente.setNome("Suzan");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals(REPROVADO_PELA_POLITICA_DE_CREDITO,
				propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeAna() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.SOLTEIRO);
		cliente.setRenda(1000);
		cliente.setDependentes(0);
		cliente.setNome("Ana");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals("entre 100 - 500", propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeRoberto() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.SOLTEIRO);
		cliente.setRenda(500);
		cliente.setDependentes(0);
		cliente.setNome("Roberto");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals(RENDA_BAIXA, propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

	@Test
	public void testeMarcos() {
		Cliente cliente = new Cliente();
		cliente.setEstadoCivil(EnumEstadoCivil.SOLTEIRO);
		cliente.setRenda(400);
		cliente.setDependentes(1);
		cliente.setNome("Marcos");
		cliente.setCpf("123");em.persist(cliente);
		PropostaDTO propostaDto = analiseCreditoService.analiseCredito(ClienteMapper.convertToClienteDTO(cliente));
		assertEquals(RENDA_BAIXA, propostaRepository.findById(propostaDto.getId()).get().getLimite());
	}

}
