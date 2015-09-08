package com.gdes.amiduf.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdes.amiduf.AmidufWebApplication;
import com.gdes.amiduf.contrat.AdfSaison;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
@Sql({ "/initSaisons.sql" })
public class SaisonsMockMvcTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	// mapper jackson
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
	}

	@Test
	public void test_lister_saisons() throws Exception {
		
		// liste des saisons
		// une saison au départ
		List<AdfSaison> expecteSaisons = new ArrayList<AdfSaison>();
		AdfSaison saison0 = new AdfSaison("2010-2011");
		expecteSaisons.add(saison0);
		listeSaisons(expecteSaisons);
		
	}

	@Test
	public void test_add_saison() throws Exception {
		
		// liste des saisons
		AdfSaison saison1 = new AdfSaison("2012-2013");
		
		ajouteSaison(saison1);
		
		List<AdfSaison> expecteSaisons = new ArrayList<AdfSaison>();
		AdfSaison saison0 = new AdfSaison("2010-2011");
		expecteSaisons.add(saison0);
		expecteSaisons.add(saison1);
		listeSaisons(expecteSaisons);
	}
	
	
	@Test
	public void test_add_saison_existante() throws Exception {
		
		AdfSaison saison1 = new AdfSaison("2010-2011");
		ajouteSaisonExistante(saison1);
		
	}
	

	@Test
	public void should_ErreurBeanValidation_when_addSaison() throws JsonProcessingException, Exception {
		
		AdfSaison saison = new AdfSaison("");
		mockMvc.perform(post("/saison").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string("{\"libelle\":\"arguments invalides : adfSaison.libelle\"}"));
		
	}

	
	private void ajouteSaison(AdfSaison saison) throws JsonProcessingException, Exception {
		mockMvc.perform(post("/saison").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}

	private void ajouteSaisonExistante(AdfSaison saison) throws JsonProcessingException, Exception {
		mockMvc.perform(post("/saison").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string("{\"libelle\":\"La saison[2010-2011] existe déjà\"}"));
		
	}

	private MvcResult listeSaisons(List<AdfSaison> expectedSaisons) throws JsonProcessingException, Exception {
		return mockMvc.perform(get("/saison").accept(MediaType.parseMediaType("application/json")))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().string(mapper.writeValueAsString(expectedSaisons))).andReturn();
	}
	

}
