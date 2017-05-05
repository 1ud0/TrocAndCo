package com.tac.data.api;


import java.util.List;

import com.tac.entity.Proposition;

public interface IDaoProposition {

	Proposition addProposition(Proposition proposition);
	Proposition updateProposition(Proposition proposition);
	void deleteProposition(Proposition proposition);
	Proposition getById(int idProposition);
	List<Proposition> getByMembre(int idMembre);
	List<Proposition> getPropDispo();
	List<Proposition> getNouveautes(int nombre);
	List<Proposition> getPropoDispoByMembre( int idMembre);
	
	
}
