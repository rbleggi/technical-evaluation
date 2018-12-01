package br.com.rogerbleggi.k2.avaliacao.service.impl;

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

import br.com.rogerbleggi.k2.avaliacao.model.Cliente;
import br.com.rogerbleggi.k2.avaliacao.model.EnumEstadoCivil;
import br.com.rogerbleggi.k2.avaliacao.model.EnumSexo;
import br.com.rogerbleggi.k2.avaliacao.service.ClienteService;
import br.com.rogerbleggi.k2.avaliacao.service.dto.ClienteDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteServiceIntegrationTest {

	@Autowired
	private ClienteService clienteService;

	@PersistenceContext
	private EntityManager em;

	@Before
	public void Before() {
		em.createNativeQuery("delete from cliente");
	}
	
	@Test
	public void deveCadastrarCliente() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCpf("123");
		clienteDTO.setDependentes(1);
		clienteDTO.setEstado("SC");
		clienteDTO.setEstadoCivil(EnumEstadoCivil.CASADO.toString());
		clienteDTO.setIdade(30);
		clienteDTO.setNome("Teste");
		clienteDTO.setRenda(5000);
		clienteDTO.setSexo(EnumSexo.M.toString());

		ClienteDTO create = clienteService.save(clienteDTO);

		em.clear();
		Cliente find = em.find(Cliente.class, create.getId());

		assertEquals(clienteDTO.getCpf(), find.getCpf());
		assertEquals(clienteDTO.getDependentes(), find.getDependentes());
		assertEquals(clienteDTO.getEstado(), find.getEstado());
		assertEquals(clienteDTO.getEstadoCivil(), find.getEstadoCivil().toString());
		assertEquals(clienteDTO.getIdade(), find.getIdade());
		assertEquals(clienteDTO.getNome(), find.getNome());
		assertEquals(clienteDTO.getRenda(), find.getRenda());
		assertEquals(clienteDTO.getSexo(), find.getSexo().toString());
	}

	@Test
	@Transactional
	public void deveBuscarTodosCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setDependentes(1);
		cliente.setEstado("SC");
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setIdade(30);
		cliente.setNome("Teste");
		cliente.setRenda(5000);
		cliente.setSexo(EnumSexo.M);

		Cliente cliente2 = new Cliente();
		cliente2.setCpf("123");
		cliente2.setDependentes(1);
		cliente2.setEstado("SC");
		cliente2.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente2.setIdade(30);
		cliente2.setNome("Teste");
		cliente2.setRenda(5000);
		cliente2.setSexo(EnumSexo.M);
		em.persist(cliente);
		em.persist(cliente2);

		assertEquals(2, clienteService.filter(null).size());
	}

	@Test
	@Transactional
	public void deveRemoverCliente() {
		Cliente cliente = new Cliente();
		String cpf = "123";
		cliente.setCpf(cpf);
		cliente.setDependentes(1);
		cliente.setEstado("SC");
		cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
		cliente.setIdade(30);
		cliente.setNome("Teste");
		cliente.setRenda(5000);
		cliente.setSexo(EnumSexo.M);
		em.persist(cliente);
		Cliente singleResult = em.createQuery("select c from Cliente c where c.cpf = :cpf", Cliente.class)
				.setParameter("cpf", cpf).getSingleResult();
		clienteService.delete(singleResult.getId());

//		assertNull(em.find(Cliente.class, delete.getId()));
	}

	@Test
	public void deveAtualizarCliente() {

	}
}
