package gdes.adf.web.mvc;

import gdes.adf.web.common.AdfSaison;
import gdes.adf.web.domain.Saison;
import gdes.adf.web.domain.SaisonRepository;
import gdes.adf.web.exception.SaisonAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saisons")
public class SaisonController {

	public static final Logger LOG = LoggerFactory
			.getLogger(SaisonController.class);
	
	@Autowired
	protected MessageSource messageSource;

	@Autowired
	protected SaisonRepository saisonRepository;

	@Autowired
	protected ConversionService conversionService;

	@Autowired
	protected Validator validator;

	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	
	@RequestMapping(produces = "application/json")
	@ResponseBody
	public List<AdfSaison> getSaisons() {

		LOG.info("recupération des saisons");

		Iterable<Saison> saisons = saisonRepository.findAll();

		List<AdfSaison> adfSaisons = new ArrayList<AdfSaison>();
		for (Saison saison : saisons) {
			adfSaisons.add(conversionService.convert(saison, AdfSaison.class));
		}
		return adfSaisons;
	}

	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public void addSaison(@RequestBody @Valid AdfSaison adfSaison, BindingResult result)
			throws SaisonAlreadyExistException {

		LOG.info("ajout de la saison " + adfSaison);
		
		if (result.hasErrors()) {
			String errMsg ="arguments invalides : "+result.getObjectName()+"."+result.getFieldError().getField();
			LOG.error(errMsg);
			throw new IllegalArgumentException(errMsg);
		}

		// vérifier que l'on a pas déjà une saison avec le même nom
		Saison existingSaison = saisonRepository.findByNom(adfSaison.getNom());
		if (existingSaison != null) {
			String msg = messageSource.getMessage("msg.saisonAlreadyExist", new Object[] {adfSaison.getNom()},Locale.FRANCE);
			LOG.error(msg);
			throw new SaisonAlreadyExistException(msg);
		}

		saisonRepository.save(conversionService
				.convert(adfSaison, Saison.class));
	}

	@ExceptionHandler(SaisonAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String  handleSaisonAlreadyExistException(SaisonAlreadyExistException e) {
	     return e.getMessage();		
	}


}
