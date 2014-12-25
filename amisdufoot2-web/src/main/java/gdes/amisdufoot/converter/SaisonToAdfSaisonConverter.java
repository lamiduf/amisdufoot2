package gdes.amisdufoot.converter;
import gdes.amisdufoot.AdfSaison;
import gdes.amisdufoot.domain.Saison;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

public class SaisonToAdfSaisonConverter implements Converter<Saison, AdfSaison> {

	@Override
	public AdfSaison convert(Saison saison) {
		return new AdfSaison(saison.getNom());
	}

}
