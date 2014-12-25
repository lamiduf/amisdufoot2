package gdes.amisdufoot;

import gdes.amisdufoot.domain.Saison;
import gdes.amisdufoot.domain.SaisonRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saisons")
public class SaisonController {
	
	public static final Logger LOG = LoggerFactory.getLogger(SaisonController.class);
	
	@Autowired
	protected SaisonRepository saisonRepository;
	
	@Autowired
	protected ConversionService conversionService;
	
	@Autowired
	protected Validator validator;
	
	@RequestMapping
	public List<AdfSaison> getSaisons() {
		
		LOG.info("recupération des saisons");
		
		Iterable<Saison> saisons = saisonRepository.findAll();
		
		List<AdfSaison> adfSaisons = new ArrayList<AdfSaison>();
		for (Saison saison : saisons) {
			adfSaisons.add(conversionService.convert(saison, AdfSaison.class));
		}	
		return adfSaisons;
	}

	@RequestMapping(method=RequestMethod.POST)
	public void addSaison(@RequestBody @Valid AdfSaison adfSaison) {
		
		LOG.info("ajout de la saison "+adfSaison);
		
		saisonRepository.save(conversionService.convert(adfSaison, Saison.class));
	}

}
