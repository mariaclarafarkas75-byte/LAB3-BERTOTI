package com.thehecklers.sburrestdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

	/**
	 * Popula o banco com alguns dados de exemplo ao iniciar a aplicação.
	 * Se as tabelas já tiverem dados (ex: reiniciando a aplicação com o
	 * mesmo banco), não duplica os registros.
	 */
	@Bean
	CommandLineRunner initData(FlorRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.save(new Flor("Rosa", "Vermelha", new BigDecimal("8.50"), 120));
				repository.save(new Flor("Girassol", "Amarela", new BigDecimal("6.00"), 80));
				repository.save(new Flor("Orquídea", "Branca", new BigDecimal("25.00"), 30));
				repository.save(new Flor("Tulipa", "Rosa", new BigDecimal("7.50"), 60));
				repository.save(new Flor("Lírio", "Branca", new BigDecimal("9.90"), 45));
			}
		};
	}
}
