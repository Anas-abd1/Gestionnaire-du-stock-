  package com.anas.gestionnairestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.boot.CommandLineRunner;
import com.anas.gestionnairestock.entities.gestionanirestock;

@SpringBootApplication
public class GestionnairestockApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	

	public static void main(String[] args) {
		
		SpringApplication.run(GestionnairestockApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(gestionanirestock.class);
	}
}
