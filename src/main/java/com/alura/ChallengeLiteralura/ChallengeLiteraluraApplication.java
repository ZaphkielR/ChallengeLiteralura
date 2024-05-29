package com.alura.ChallengeLiteralura;

import com.alura.ChallengeLiteralura.principal.Principal;
import com.alura.ChallengeLiteralura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraApplication implements CommandLineRunner {
	//@Autowired
	//private LibroRepository repository;

    public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
