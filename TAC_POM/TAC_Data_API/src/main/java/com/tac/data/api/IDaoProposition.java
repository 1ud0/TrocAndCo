package com.tac.data.api;


import java.util.List;

import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;
import com.tac.util.CritereSearch;

public interface IDaoProposition {

	Proposition addProposition(Proposition proposition);
	Proposition updateProposition(Proposition proposition);
	Proposition getById(int idProposition) throws DataAccessException;
	List<Proposition> getByMembre(int idMembre);
	List<Proposition> getPropDispo();
	List<Proposition> getNouveautes(int nombre, Integer idMembre);
	List<Proposition> getPropoDispoByMembre(int idMembre);
	List<Proposition> rechercher(CritereSearch carac, Integer idMembre);
	
}
