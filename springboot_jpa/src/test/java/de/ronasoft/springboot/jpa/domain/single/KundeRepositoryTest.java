package de.ronasoft.springboot.jpa.domain.single;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KundeRepositoryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KundeRepositoryTest.class);

	@Autowired
	KundeRepository kundeRepository;
	
	@Test
	public void testSaveAndFindById() {
		Kunde kunde1 = new Kunde(1L, "Olaf", "Thon");
		Kunde kunde2 = new Kunde(2L, "Guido", "Burgstaller");
		
		// speichern
		kundeRepository.saveAll(Arrays.asList(kunde1, kunde2));
		
		// lesen
		Optional<Kunde> optional = kundeRepository.findById(2L);
		assertThat(optional).isNotEmpty(); // Kunde mit der Id 2 sollte gefunden werden.
		
		Kunde kunde = optional.get();
		LOGGER.info("Gefunden [{}].", kunde);
		assertThat(kunde.getVorname()).isEqualToIgnoringCase("Guido");
		assertThat(kunde.getNachname()).isEqualToIgnoringCase("Burgstaller");
	}
	
	@Test
	public void testSaveAndFindByNachname() {
		Kunde kunde1 = new Kunde(1L, "Olaf", "Thon");
		Kunde kunde2 = new Kunde(2L, "Guido", "Burgstaller");
		
		// speichern
		kundeRepository.saveAll(Arrays.asList(kunde1, kunde2));
		
		// lesen
		List<Kunde> kunden = kundeRepository.findByNachname("Thon");
		assertThat(kunden).contains(kunde1); // Kunde mit dem Nachnamen 'Thon' sollte gefunden werden
		
		Kunde kunde = kunden.get(0);
		LOGGER.info("Gefunden [{}].", kunde);
		assertThat(kunde.getVorname()).isEqualToIgnoringCase("Olaf");
	}

}
