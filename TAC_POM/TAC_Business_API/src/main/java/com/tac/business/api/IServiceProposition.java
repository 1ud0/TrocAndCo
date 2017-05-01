package com.tac.business.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Proposition;

public interface IServiceProposition {

	Proposition addProposition(Proposition proposition);
	Proposition updateProposition(Proposition proposition);
	void deleteProposition(Proposition proposition);
	List<Proposition> getByMembre(Membre membre);
	
}
