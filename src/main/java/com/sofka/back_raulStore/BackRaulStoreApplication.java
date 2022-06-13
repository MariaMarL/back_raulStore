package com.sofka.back_raulStore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Rauuuul Store", version = "1.0", description = "Documentation API Raul Store"))
public class BackRaulStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackRaulStoreApplication.class, args);
	}

}
