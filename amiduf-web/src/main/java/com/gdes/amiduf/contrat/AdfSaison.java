package com.gdes.amiduf.contrat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AdfSaison {

	@NotNull
	@NotEmpty
	private String libelle;

    protected AdfSaison() {};
    
    
	public AdfSaison(String libelle) {
		super();
		this.libelle = libelle;
	}


	public String getLibelle() {
		return libelle;
	}


	@Override
	public String toString() {
		return "AdfSaison [libelle=" + libelle + "]";
	}

	
	
}
