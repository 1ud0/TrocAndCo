package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceLocalisation;
import com.tac.data.api.IDaoLocalisation;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IServiceLocalisation.class)
@Stateless
public class ServiceLocalisation implements IServiceLocalisation {
	
	@EJB
	private IDaoLocalisation proxyDaoLocalisation;

	@Override
	public Localisation addLocalisation(Localisation localisation) {
		return proxyDaoLocalisation.addLocalisation(localisation);
	}

	@Override
	public Localisation updateLocalisation(Localisation localisation) {
		return proxyDaoLocalisation.updateLocalisation(localisation);
	}

	@Override
	public void deleteLocalisation(Localisation localisation) {
		proxyDaoLocalisation.deleteLocalisation(localisation);
		
	}

	@Override
	public List<Localisation> getMembreLocalisations(Membre membre) {
		return proxyDaoLocalisation.getMembreLocalisations(membre.getIdMembre());
	}

	@Override
	public List<Localisation> getPropositionLocalisations(Proposition proposition) {
		return proxyDaoLocalisation.getPropositionLocalisations(proposition);
	}

	@Override
	public Localisation getById(Integer idLocalisation) {
		return proxyDaoLocalisation.getById(idLocalisation);
	}
	
	

}
