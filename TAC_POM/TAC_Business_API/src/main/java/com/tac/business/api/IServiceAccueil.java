package com.tac.business.api;

import java.util.List;

import com.tac.entity.Proposition;

public interface IServiceAccueil {

	List<Proposition> getNouveaute(int nbNouveaute);
	long getNbPropDispo();
	long getNbMembre();
	long getNbEchangesFinis();
}
