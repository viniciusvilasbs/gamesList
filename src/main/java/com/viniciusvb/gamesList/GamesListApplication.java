package com.viniciusvb.gamesList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamesListApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesListApplication.class, args);
		System.out.println("Hello games!");
	}

}
