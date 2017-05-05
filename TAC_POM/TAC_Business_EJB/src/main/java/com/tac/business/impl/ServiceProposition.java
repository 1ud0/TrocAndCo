package com.tac.business.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceProposition;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoPhoto;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Membre;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

@Remote(IServiceProposition.class)
@Stateless
public class ServiceProposition implements IServiceProposition {
	
	@EJB
	private IDaoProposition proxyDaoProposition;
	@EJB
	private IDaoPhoto proxyDaoPhoto;
	@EJB
	private IDaoEchange proxyEchange;

	@Override
	public Proposition addProposition(Proposition proposition) {
		proposition.setDateAjout(new Date());
		return proxyDaoProposition.addProposition(proposition);
	}

	@Override
	public Proposition updateProposition(Proposition proposition) {
		
		return proxyDaoProposition.updateProposition(proposition);
	}

	@Override
	public void deleteProposition(Proposition proposition) {
		proxyDaoProposition.deleteProposition(proposition);

	}

	@Override
	public List<Proposition> getByMembre(Membre membre) {
		
		return proxyDaoProposition.getByMembre(membre.getIdMembre());
	}

	@Override
	public List<Photo> getByProposition(Proposition proposition) {
		
		return proxyDaoPhoto.getByProposition(proposition);
	}

	@Override
	public List<Proposition> getPropDispoByMembre(Membre membre) {
		return proxyDaoProposition.getPropoDispoByMembre(membre.getIdMembre());	
	}
	
	@Override
	public Proposition getById(Integer idObjet) throws DataAccessException {
		return proxyDaoProposition.getById(idObjet);
	}

}
