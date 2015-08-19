package com.gdes.amiduf.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdes.amiduf.domain.Competition;
import com.gdes.amiduf.domain.Saison;

public interface CompetitionRepository extends CrudRepository<Competition, Long>{

	Competition findByLibelleAndSaison(String libelle, Saison saison);
	
	List<Competition> findBySaison(Saison saison);
}
