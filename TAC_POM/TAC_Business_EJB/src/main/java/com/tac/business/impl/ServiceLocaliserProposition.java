package com.tac.business.impl;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceLocaliserProposition;
import com.tac.data.api.IDaoLocaliser;
import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

@Remote(IServiceLocaliserProposition.class)
@Stateless
public class ServiceLocaliserProposition implements IServiceLocaliserProposition {
	@EJB
	private IDaoLocaliser proxyDaoLocaliser;


	@Override
	public void addLocalisationAUneProposition(Proposition proposition, Localisation localisation) {
		proxyDaoLocaliser.addLocaliser(proposition, localisation);
		
	}

	@Override
	public void deleteLocalisationAUneProposition(Proposition proposition, Localisation localisation) {

		proxyDaoLocaliser.deleteFavori(proposition, localisation);
	}

}
