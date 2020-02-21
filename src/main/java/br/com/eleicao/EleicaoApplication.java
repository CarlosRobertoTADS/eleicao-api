package br.com.eleicao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EleicaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EleicaoApplication.class, args);
	}

}
