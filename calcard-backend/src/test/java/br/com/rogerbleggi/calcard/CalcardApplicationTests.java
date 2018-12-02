package br.com.rogerbleggi.calcard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogerbleggi.calcard.controller.ClienteResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalcardApplicationTests {

	@Autowired
	private ClienteResource clienteResource;

	@Test
	public void contextLoads() {
		assertThat(clienteResource).isNotNull();
	}

}
