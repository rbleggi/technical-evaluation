package br.com.rogerbleggi.calcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CalcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcardApplication.class, args);
	}

}
