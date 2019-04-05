package de.ronasoft.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.ronasoft.springboot.jpa.domain.single.Kunde;
import de.ronasoft.springboot.jpa.domain.single.KundeRepository;

@SpringBootApplication
public class SpringbootJpaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(KundeRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Kunde("Jack", "Bauer"));
			repository.save(new Kunde("Chloe", "O'Brian"));
			repository.save(new Kunde("Kim", "Bauer"));
			repository.save(new Kunde("David", "Palmer"));
			repository.save(new Kunde("Michelle", "Dessler"));

			// fetch all customers
			LOGGER.info("Kunde gefunden mit findAll():");
			LOGGER.info("-------------------------------");
			for (Kunde customer : repository.findAll()) {
				LOGGER.info(customer.toString());
			}
			LOGGER.info("");

			// fetch an individual customer by ID
			repository.findById(1L).ifPresent(customer -> {
				LOGGER.info("Kunde gefunden mit findById(1L):");
				LOGGER.info("--------------------------------");
				LOGGER.info(customer.toString());
				LOGGER.info("");
			});

			// fetch customers by last name
			LOGGER.info("Kunde gefunden mit findByLastName('Bauer'):");
			LOGGER.info("--------------------------------------------");
			repository.findByNachname("Bauer").forEach(bauer -> {
				LOGGER.info(bauer.toString());
			});
			LOGGER.info("");
		};
	}
}
