package com.alura.challenge_libros;

import com.alura.challenge_libros.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}
}
