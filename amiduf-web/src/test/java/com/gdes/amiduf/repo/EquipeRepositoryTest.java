package com.gdes.amiduf.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.domain.Equipe;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
public class EquipeRepositoryTest {

	@Autowired
	protected EquipeRepository repository;
	
	
	@Test
	public void testFindByLibelle() {
		repository.save(new Equipe("AMIS DU FOOT"));
		repository.save(new Equipe("COCKER C"));
		assertNotNull(repository.findByLibelle("AMIS DU FOOT").getId());
		assertEquals(2, repository.count());
	}
	
}
