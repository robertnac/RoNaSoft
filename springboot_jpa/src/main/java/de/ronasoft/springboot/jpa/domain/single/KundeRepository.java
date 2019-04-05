package de.ronasoft.springboot.jpa.domain.single;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KundeRepository extends CrudRepository<Kunde, Long> {

    List<Kunde> findByNachname(String nachname);
}

