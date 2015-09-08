package com.gdes.amiduf.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.contrat.AdfSaison;
import com.gdes.amiduf.domain.Saison;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
@WebIntegrationTest(randomPort = true)
@Sql({ "/initSaisons.sql" })
public class SaisonsIntegrationTest {

	@Value("${local.server.port}")
	private int port;

	private String url;
	
	@Before
	public void init() {
		url = "http://localhost:" + port + "/saison";
	}	

	@Test
	public void test_get_all_saisons() {

		Saison[] saisons = new RestTemplate().getForObject(url, Saison[].class);
		assertEquals(1, saisons.length);
		assertEquals("2010-2011", saisons[0].getLibelle());

	}

	@Test
	public void test_add_saison() {

		AdfSaison saison2 = new AdfSaison("2012-2013");
		new RestTemplate().postForObject(url, saison2, AdfSaison.class);

		Saison[] saisons = new RestTemplate().getForObject(url, Saison[].class);
		assertEquals(2, saisons.length);
	}
	

}
