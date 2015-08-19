package com.gdes.amiduf.repo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.domain.Competition;
import com.gdes.amiduf.domain.Saison;
import com.gdes.amiduf.domain.TypeCompetitionEnum;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
public class CompetitionRepositoryTest {

	@Autowired
	protected SaisonRepository saisonRepository;
	
	@Autowired
	protected CompetitionRepository competitionRepository;
	
	@Before
	public void init() {
		competitionRepository.deleteAll();
		saisonRepository.deleteAll();
	}
	
	@Test
	public void test() {

		Saison saison20142015 = saisonRepository.save(new Saison("2014-2015"));
		Saison saison20152016 = saisonRepository.save(new Saison("2015-2016"));
		
		Competition competition1 = competitionRepository.save(new Competition("amicaux", TypeCompetitionEnum.AMICAL, saison20142015));
		assertNotNull(competition1.getId());
		
		Competition competition2 = competitionRepository.save(new Competition("amicaux", TypeCompetitionEnum.AMICAL, saison20152016));
		assertNotNull(competition2.getId());

		Competition competition3 = competitionRepository.save(new Competition("championnat groupe A", TypeCompetitionEnum.CHAMPIONNAT, saison20152016));
		assertNotNull(competition3.getId());
		
		assertEquals(3, competitionRepository.count());
		
		assertEquals(competition2, competitionRepository.findByLibelleAndSaison("amicaux", saison20152016));
		
		assertEquals(2, competitionRepository.findBySaison(saison20152016).size());
		
		List<Competition> competitions_20142015 = competitionRepository.findBySaison(saison20142015);
		assertEquals(1, competitions_20142015.size());
		assertEquals(competition1,competitions_20142015.get(0));
	}
	
}
