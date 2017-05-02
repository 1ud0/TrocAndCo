package com.tac.business.api;

import java.util.List;

import com.tac.entity.Localisation;
import com.tac.entity.Membre;

public interface IServiceLocalisation {
	
	Localisation addLocalisation(Localisation localisation);
	Localisation updateLocalisation(Localisation localisation);
	void deleteLocalisation(Localisation localisation);
	List<Localisation> getMembreLocalisations(Membre membre);
	
}
