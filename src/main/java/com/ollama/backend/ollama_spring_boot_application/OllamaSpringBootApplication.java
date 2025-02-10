package com.ollama.backend.ollama_spring_boot_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OllamaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OllamaSpringBootApplication.class, args);
		System.out.println("Application is live");
	}

}
