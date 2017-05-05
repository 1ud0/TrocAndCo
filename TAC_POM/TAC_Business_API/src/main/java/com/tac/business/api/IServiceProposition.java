package com.tac.business.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

public interface IServiceProposition {

	Proposition addProposition(Proposition proposition);
	Proposition updateProposition(Proposition proposition);
	Proposition getById(Integer idObjet) throws DataAccessException;
	void deleteProposition(Proposition proposition);
	List<Proposition> getByMembre(Membre membre);
	List<Photo> getByProposition(Proposition proposition);
	
}
