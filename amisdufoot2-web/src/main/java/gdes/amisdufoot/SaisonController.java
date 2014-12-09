package gdes.amisdufoot;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saisons")
public class SaisonController {
	
	public static final Logger LOG = LoggerFactory.getLogger(SaisonController.class);
	
	@RequestMapping
	public List<Saison> getSaisons() {
		LOG.info("recupération des saisons");
		List<Saison> saisons = new ArrayList<Saison>();
		saisons.add(new Saison(1L, "2012-2013"));
		saisons.add(new Saison(2L, "2013-2014"));
		return saisons;
	}

	@RequestMapping(method=RequestMethod.POST)
	public void addSaison(Saison saison) {
		LOG.info("ajout de la saison "+saison);
	}

}
