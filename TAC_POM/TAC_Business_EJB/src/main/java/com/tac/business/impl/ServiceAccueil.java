package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceAccueil;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoMembre;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Proposition;

@Remote(IServiceAccueil.class)
@Stateless
public class ServiceAccueil implements IServiceAccueil{

	@EJB
	private IDaoProposition proxyProposition;
	@EJB
	private IDaoMembre proxyMembre;
	@EJB
	private IDaoEchange proxyEchange;
	
	@Override
	public List<Proposition> getNouveaute(int nbNouveaute) {
		return proxyProposition.getNouveautes(nbNouveaute, null);
	}

	@Override
	public long getNbPropDispo() {
		return proxyProposition.getNbPropDispo();
	}

	@Override
	public long getNbMembre() {
		return proxyMembre.getNbMembres();
	}

	@Override
	public long getNbEchangesFinis() {
		return proxyEchange.getNbEchangesFinis();
	}

}
