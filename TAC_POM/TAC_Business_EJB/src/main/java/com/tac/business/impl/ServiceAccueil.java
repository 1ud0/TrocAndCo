package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceAccueil;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoMembre;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IServiceAccueil.class)
@Stateless
public class ServiceAccueil implements IServiceAccueil{

	@EJB
	IDaoProposition proxyProposition;
	
	@EJB
	IDaoMembre proxyMembre;
	
	@EJB
	IDaoEchange proxyEchange;
	
	
	@Override
	public List<Proposition> getAllPropDispo() {
		
		return proxyProposition.getPropDispo();
	}

	@Override
	public List<Membre> getAllMembre() {
		return proxyMembre.getAll();
	}

	@Override
	public List<Echange> getAllEchangeFini() {
		return proxyEchange.getAllEchangeFini();
	}

	@Override
	public List<Proposition> getNouveaute(int nbNouveaute) {
		return proxyProposition.getNouveautes(nbNouveaute);
	}

}
