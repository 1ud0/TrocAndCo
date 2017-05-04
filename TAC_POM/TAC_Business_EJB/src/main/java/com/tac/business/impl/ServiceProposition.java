package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceProposition;
import com.tac.data.api.IDaoPhoto;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Membre;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;

@Remote(IServiceProposition.class)
@Stateless
public class ServiceProposition implements IServiceProposition {
	
	@EJB
	private IDaoProposition proxyDaoProposition;
	@EJB
	private IDaoPhoto proxyDaoPhoto;

	@Override
	public Proposition addProposition(Proposition proposition) {
		
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

}
