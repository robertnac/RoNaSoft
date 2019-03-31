package de.ronasoft.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.ronasoft.springboot.jpa.domain.Customer;
import de.ronasoft.springboot.jpa.domain.CustomerRepository;

@SpringBootApplication
public class SpringbootJpaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			LOGGER.info("Customers gefunden mit findAll():");
			LOGGER.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				LOGGER.info(customer.toString());
			}
			LOGGER.info("");

			// fetch an individual customer by ID
			repository.findById(1L).ifPresent(customer -> {
				LOGGER.info("Customer gefunden mit findById(1L):");
				LOGGER.info("--------------------------------");
				LOGGER.info(customer.toString());
				LOGGER.info("");
			});

			// fetch customers by last name
			LOGGER.info("Customer gefunden mit findByLastName('Bauer'):");
			LOGGER.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				LOGGER.info(bauer.toString());
			});
			LOGGER.info("");
		};
	}
}
