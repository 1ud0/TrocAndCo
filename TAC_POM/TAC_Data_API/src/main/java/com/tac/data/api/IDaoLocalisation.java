package com.tac.data.api;

import java.util.List;

import com.tac.entity.Localisation;

public interface IDaoLocalisation {
	
	Localisation addLocalisation(Localisation loc);
	Localisation updateLocalisation(Localisation loc);
	void deleteLocalisation(Localisation loc);
	Localisation getById(Integer id);
	List<Localisation> getMembreLocalisations(Integer id);
}
