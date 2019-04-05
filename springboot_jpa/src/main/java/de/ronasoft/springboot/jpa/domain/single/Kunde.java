package de.ronasoft.springboot.jpa.domain.single;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kunde {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vorname;
	private String nachname;

	protected Kunde() {
	}

	public Kunde(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return String.format("Kunde[id=%d, Vorname='%s', Nachname='%s']", id, vorname, nachname);
	}

	public Long getId() {
		return id;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	
}
