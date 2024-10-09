package com.yandemelo.TREnergia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TR Energia", version = "1.0", description = "API desenvolvida para o gerenciamento de Usuários."))
public class TrEnergiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrEnergiaApplication.class, args);
	}

}
