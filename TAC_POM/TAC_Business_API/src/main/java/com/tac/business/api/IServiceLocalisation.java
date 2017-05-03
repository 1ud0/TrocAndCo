package com.tac.business.api;

import java.util.List;

import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

public interface IServiceLocalisation {
	
	Localisation addLocalisation(Localisation localisation);
	Localisation updateLocalisation(Localisation localisation);
	void deleteLocalisation(Localisation localisation);
	List<Localisation> getMembreLocalisations(Membre membre);
	List<Localisation> getPropositionLocalisations(Proposition proposition);
	
}
