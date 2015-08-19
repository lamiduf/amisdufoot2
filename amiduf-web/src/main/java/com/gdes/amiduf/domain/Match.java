package com.gdes.amiduf.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date date;
    
    @ManyToOne
    private Competition competition;
    
    private String lieu;
    
    private TypeTerrain typeTerrain;
    
    @ManyToOne
    private Equipe equipe1;
    
    @ManyToOne
    private Equipe equipe2;
    
    private int butsEquipe1;
    private int butsEquipe2;
    
    @OneToMany
    private Set<CommentaireMatch> commentaires = new HashSet<CommentaireMatch>();
    
    @OneToMany
    private Set<StatsJoueurParMatch> statsJoueurs = new HashSet<StatsJoueurParMatch>();

	public Match(Date date, Competition competition, String lieu, TypeTerrain typeTerrain, Equipe equipe1,
			Equipe equipe2, int butsEquipe1, int butsEquipe2) {
		super();
		this.date = date;
		this.competition = competition;
		this.lieu = lieu;
		this.typeTerrain = typeTerrain;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.butsEquipe1 = butsEquipe1;
		this.butsEquipe2 = butsEquipe2;
	}

	public void ajouteCommentaire(CommentaireMatch commentaire) {
		commentaires.add(commentaire);
	}
    
	public void ajouteStatJoueur(StatsJoueurParMatch stat) {
		statsJoueurs.add(stat);
	}


	@Override
	public String toString() {
		return "Match [id=" + id + ", date=" + date + ", competition=" + competition + ", lieu=" + lieu
				+ ", typeTerrain=" + typeTerrain + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + ", butsEquipe1="
				+ butsEquipe1 + ", butsEquipe2=" + butsEquipe2 + ", commentaires=" + commentaires + ", statsJoueurs="
				+ statsJoueurs + "]";
	}
    
    
}
