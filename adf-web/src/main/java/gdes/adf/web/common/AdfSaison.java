package gdes.adf.web.common;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



public class AdfSaison {
	
	@NotEmpty
	@NotNull
	public String nom;
	
	
	public AdfSaison() {
		super();
	}
	public AdfSaison(String nom) {
		super();
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "AdfSaison [nom=" + nom + "]";
	}

	
	
}
