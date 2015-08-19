package com.gdes.amiduf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String libelle;
    
    private TypeCompetitionEnum type;
    
    @ManyToOne
    private Saison saison;
    
    
    protected Competition() {};
    
 	public Competition(String libelle, TypeCompetitionEnum type, Saison saison) {
		super();
		this.libelle = libelle;
		this.type = type;
		this.saison = saison;
	}
 	

	public Long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public TypeCompetitionEnum getType() {
		return type;
	}

	public Saison getSaison() {
		return saison;
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", libelle=" + libelle + ", type=" + type + ", saison=" + saison + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((saison == null) ? 0 : saison.hashCode());
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
		Competition other = (Competition) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (saison == null) {
			if (other.saison != null)
				return false;
		} else if (!saison.equals(other.saison))
			return false;
		return true;
	}

	
	
}
