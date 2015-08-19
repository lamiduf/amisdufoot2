package com.gdes.amiduf.repo;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.domain.Saison;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
public class SaisonRepositoryTest {

	@Autowired
	protected SaisonRepository repository;
	
	
	@Test
	public void testFindByLibelle() {
		repository.save(new Saison("2014-2015"));
		repository.save(new Saison("2015-2016"));
		assertNotNull(repository.findByLibelle("2014-2015").getId());
		assertEquals(2, repository.count());
	}
	
}
