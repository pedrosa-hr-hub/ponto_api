package com.example.pontoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PontoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoapiApplication.class, args);

		System.err.println("Está rodando!");
	}

}
