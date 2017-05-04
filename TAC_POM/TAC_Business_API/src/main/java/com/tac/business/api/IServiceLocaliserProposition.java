package com.tac.business.api;


import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

public interface IServiceLocaliserProposition {
	void addLocalisationAUneProposition(Proposition proposition, Localisation localisation);
	void deleteLocalisationAUneProposition(Proposition proposition, Localisation localisation);

}
