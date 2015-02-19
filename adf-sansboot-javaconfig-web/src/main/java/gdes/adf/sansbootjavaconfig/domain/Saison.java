package gdes.adf.sansbootjavaconfig.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saison {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;

	protected String nom;
	
	public Saison() {
		super();
	}

	public Saison(String nom) {
		super();
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
