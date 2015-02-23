package gdes.adf.sansbootjavaconfig.unitaire;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gdes.adf.sansbootjavaconfig.common.AdfSaison;
import gdes.adf.sansbootjavaconfig.domain.Saison;
import gdes.adf.sansbootjavaconfig.domain.SaisonRepository;
import gdes.adf.sansbootjavaconfig.exception.SaisonAlreadyExistException;
import gdes.adf.sansbootjavaconfig.mvc.SaisonController;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.BindingResult;


@RunWith(MockitoJUnitRunner.class)
public class SaisonsControllerTestCase {

	@Mock
	protected MessageSource mockMessageSource;
	
	@Mock
	protected SaisonRepository mockSaisonRepository;

	@Mock
	protected ConversionService mockConversionService;
	
	@InjectMocks
	private SaisonController controller = new SaisonController();
	
	private Saison mockSaison1 = new Saison("saison1");
	private Saison mockSaison2 = new Saison("saison2");

	private AdfSaison mockAdfSaison1 = new AdfSaison("saison1");
	private AdfSaison mockAdfSaison2 = new AdfSaison("saison2");

	@Before
	public void setup() {
		when(mockConversionService.convert(mockSaison1, AdfSaison.class)).thenReturn(mockAdfSaison1);
		when(mockConversionService.convert(mockSaison2, AdfSaison.class)).thenReturn(mockAdfSaison2);

		when(mockConversionService.convert(mockAdfSaison1, Saison.class)).thenReturn(mockSaison1);
		when(mockConversionService.convert(mockAdfSaison2, Saison.class)).thenReturn(mockSaison2);
}
	

	 
	@Test
	public void testGetSaisons() throws Exception {

		when(mockSaisonRepository.findAll()).thenReturn(Arrays.asList(mockSaison1,mockSaison2));
		
		List<AdfSaison> saisons = controller.getSaisons();
		
		assertTrue(saisons.equals(Arrays.asList(mockAdfSaison1,mockAdfSaison2)));
		
	}
	
	
	@Test
	public void testAddSaison() throws Exception {

		BindingResult result = mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(false);

		controller.addSaison(mockAdfSaison1, result);
		
		verify(mockSaisonRepository).save(mockSaison1);
	}
	
	@Test
	public void testAddSaison_KOSaisonExistante() throws Exception {

		BindingResult result = mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(false);
	    
	    when(mockSaisonRepository.findByNom("saison1")).thenReturn(mockSaison1);

	    try {
	    	controller.addSaison(mockAdfSaison1, result);
	    	fail();
	    }
	    catch(SaisonAlreadyExistException e) {
	    	verify(mockSaisonRepository,never()).save(any(Saison.class));
	    }	
	}
	

}
