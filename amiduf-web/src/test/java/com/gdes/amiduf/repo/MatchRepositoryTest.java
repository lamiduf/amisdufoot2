package com.gdes.amiduf.repo;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.domain.CommentaireMatch;
import com.gdes.amiduf.domain.Competition;
import com.gdes.amiduf.domain.Equipe;
import com.gdes.amiduf.domain.Joueur;
import com.gdes.amiduf.domain.Match;
import com.gdes.amiduf.domain.Saison;
import com.gdes.amiduf.domain.StatsJoueurParMatch;
import com.gdes.amiduf.domain.TypeCommentaireMatchEnum;
import com.gdes.amiduf.domain.TypeCompetitionEnum;
import com.gdes.amiduf.domain.TypeTerrain;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
public class MatchRepositoryTest {

	@Autowired
	protected SaisonRepository saisonRepository;
	
	@Autowired
	protected CompetitionRepository competitionRepository;

	@Autowired
	protected EquipeRepository equipeRepository;

	@Autowired
	protected JoueurRepository joueurRepository;

	@Autowired
	protected StatsJoueurParMatchRepository statsJoueurParMatchRepository;

	@Autowired
	protected CommentaireMatchRepository commentaireMatchRepository;

	@Autowired
	protected MatchRepository matchRepository;

	@Before
	public void init() {
		competitionRepository.deleteAll();
		saisonRepository.deleteAll();
	}
	
	@Test
	public void test() {

		Saison saison20142015 = saisonRepository.save(new Saison("2014-2015"));
		Competition competition1 = competitionRepository.save(new Competition("amicaux", TypeCompetitionEnum.AMICAL, saison20142015));
		Equipe amisDuFoot = equipeRepository.save(new Equipe("Amis du Foot"));
		Equipe cockers = equipeRepository.save(new Equipe("Cockers"));
		Joueur amilenko = joueurRepository.save(new Joueur("Thibaut", "Pierre", "AMilenko"));
		
		Match match1 = new Match(new Date(), competition1, "Bousbecque", TypeTerrain.SYNTHE, amisDuFoot, cockers,5,0);

		CommentaireMatch comm1 = commentaireMatchRepository.save(new CommentaireMatch(TypeCommentaireMatchEnum.AIME_BEAUCOUP, "la frappe de bati"));
		match1.ajouteCommentaire(comm1);
		
		StatsJoueurParMatch stat1 = statsJoueurParMatchRepository.save(new StatsJoueurParMatch(amilenko, 5));
		match1.ajouteStatJoueur(stat1);
		
		match1 = matchRepository.save(match1);
		
		System.out.println(match1);
		
	}
	
}
