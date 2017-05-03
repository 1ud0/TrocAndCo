package com.tac.data.api;

import java.util.List;

import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

public interface IDaoLocalisation {
	
	Localisation addLocalisation(Localisation loc);
	Localisation updateLocalisation(Localisation loc);
	void deleteLocalisation(Localisation loc);
	Localisation getById(Integer id);
	List<Localisation> getMembreLocalisations(Integer id);
	List<Localisation> getPropositionLocalisations(Proposition proposition);
}
