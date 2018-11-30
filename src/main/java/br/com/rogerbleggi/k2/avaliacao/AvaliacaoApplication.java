package br.com.rogerbleggi.k2.avaliacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AvaliacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoApplication.class, args);
	}

}
