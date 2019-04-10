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
	
	public Kunde(Long id, String vorname, String nachname) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kunde other = (Kunde) obj;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
	
}
