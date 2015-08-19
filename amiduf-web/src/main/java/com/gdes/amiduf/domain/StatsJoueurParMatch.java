package com.gdes.amiduf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatsJoueurParMatch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Joueur joueur;

	private int buts;

	public StatsJoueurParMatch(Joueur joueur, int buts) {
		super();
		this.joueur = joueur;
		this.buts = buts;
	}

	@Override
	public String toString() {
		return "StatsJoueurParMatch [id=" + id + ", joueur=" + joueur + ", buts=" + buts + "]";
	}
	
	
}
