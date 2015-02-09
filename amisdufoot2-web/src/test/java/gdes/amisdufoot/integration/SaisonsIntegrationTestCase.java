package gdes.amisdufoot.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import gdes.amisdufoot.AdfSaison;
import gdes.amisdufoot.ApplicationConfig;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class SaisonsIntegrationTestCase {

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
	public void test() throws Exception {
		
		
		// liste des saisons
		// aucune saison au départ
		List<AdfSaison> expecteSaisons = new ArrayList<AdfSaison>();
		listeSaisons(expecteSaisons);
		
		// ajout de saisons
		AdfSaison saison1 = new AdfSaison("saison1");
		ajouteSaison(saison1);
		expecteSaisons.add(saison1);
		listeSaisons(expecteSaisons);
	
		AdfSaison saison2 = new AdfSaison("saison2");
		ajouteSaison(saison2);
		expecteSaisons.add(saison2);
		listeSaisons(expecteSaisons);

		// ajout de saison existante
		ajouteSaisonExistante(saison1);
		listeSaisons(expecteSaisons);

	}

	@Test
	public void should_ErreurBeanValidation_when_addSaison() throws JsonProcessingException, Exception {
		
		AdfSaison saison = new AdfSaison();
		mockMvc.perform(post("/saisons").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string("arguments invalides : adfSaison.nom"));
		
	}

	
	private void ajouteSaison(AdfSaison saison) throws JsonProcessingException, Exception {
		mockMvc.perform(post("/saisons").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk());
	}

	private void ajouteSaisonExistante(AdfSaison saison) throws JsonProcessingException, Exception {
		mockMvc.perform(post("/saisons").content(mapper.writeValueAsString(saison)).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().string("La saison["+saison.getNom()+"] existe déjà"));
		
	}

	private MvcResult listeSaisons(List<AdfSaison> expectedSaisons) throws JsonProcessingException, Exception {
		return mockMvc.perform(get("/saisons").accept(MediaType.parseMediaType("application/json")))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().string(mapper.writeValueAsString(expectedSaisons))).andReturn();
	}
	
	
	
}
