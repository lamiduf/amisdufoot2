package com.gdes.amiduf.repo;

import org.springframework.data.repository.CrudRepository;

import com.gdes.amiduf.domain.Equipe;

public interface EquipeRepository extends CrudRepository<Equipe, Long>{

	Equipe findByLibelle(String libelle);
}
