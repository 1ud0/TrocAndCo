package com.tac.data.api;


import java.util.List;

import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

public interface IDaoProposition {

	Proposition addProposition(Proposition proposition);
	Proposition updateProposition(Proposition proposition);
	void deleteProposition(Proposition proposition);
	Proposition getById(int idProposition) throws DataAccessException;
	List<Proposition> getByMembre(int idMembre);
	List<Proposition> getPropDispo();
	List<Proposition> getNouveautes(int nombre);
	List<Proposition> getPropoDispoByMembre( int idMembre);
	
	
}
