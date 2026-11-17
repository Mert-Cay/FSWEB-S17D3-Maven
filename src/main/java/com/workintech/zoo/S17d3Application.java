package com.workintech.zoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S17d3Application {

	public static void main(String[] args) {
		SpringApplication.run(S17d3Application.class, args);
	}

	// Testlerin aradığı ObjectMapper'ı manuel olarak hafızaya yüklüyoruz
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}