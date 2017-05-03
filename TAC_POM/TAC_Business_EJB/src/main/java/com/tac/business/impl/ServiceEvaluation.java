package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceEvaluation;
import com.tac.data.api.IDaoEchange;
import com.tac.entity.Echange;
import com.tac.entity.Membre;

@Remote(IServiceEvaluation.class)
@Stateless
public class ServiceEvaluation implements IServiceEvaluation {
	@EJB
	private IDaoEchange proxyDaoEchange;

	@Override
	public Echange evalDonneur(Echange echange) {
		return proxyDaoEchange.updateEchange(echange);
	}

	@Override
	public Echange evalChercheur(Echange echange) {
		return proxyDaoEchange.updateEchange(echange);
	}

	@Override
	public List<Echange> getEvalRecues(Membre membre) {
		return proxyDaoEchange.getByMembre(membre.getIdMembre()); 
	}

	@Override
	public List<Echange> getEvalDonnees(Membre membre) {
		return proxyDaoEchange.getByMembre(membre.getIdMembre());
	}
	
	@Override
	public Double getNoteMoyenneMembre(Membre membre) {
		return proxyDaoEchange.getNoteMoyenneMembre(membre.getIdMembre());
	}

}
