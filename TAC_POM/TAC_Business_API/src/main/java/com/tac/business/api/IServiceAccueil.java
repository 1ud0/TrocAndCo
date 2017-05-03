package com.tac.business.api;

import java.util.List;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

public interface IServiceAccueil {

	List<Proposition> getAllPropDispo();
	List<Membre> getAllMembre();
	List<Echange> getAllEchangeFini();
	List<Proposition> getNouveaute(int nbNouveaute);
}
