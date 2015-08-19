package com.gdes.amiduf.repo;

import org.springframework.data.repository.CrudRepository;

import com.gdes.amiduf.domain.Saison;

public interface SaisonRepository extends CrudRepository<Saison, Long>{

	Saison findByLibelle(String libelle);
}
