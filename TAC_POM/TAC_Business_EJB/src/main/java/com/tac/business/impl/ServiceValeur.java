package com.tac.business.impl;

import javax.ejb.EJB;

import com.tac.business.api.IServiceValeur;
import com.tac.data.api.IDaoValeur;
import com.tac.entity.Valeur;

public class ServiceValeur implements IServiceValeur{
@EJB
private IDaoValeur proxyDaoValeur;

	@Override
	public Valeur addValeur(Valeur valeur) {
		return proxyDaoValeur.addValeur(valeur);
	}

	@Override
	public Valeur updateValeur(Valeur valeur) {
		return proxyDaoValeur.updateValeur(valeur);
	}

	@Override
	public void deleteValeur(Valeur valeur) {
		proxyDaoValeur.deleteValeur(valeur);
		
	}

	@Override
	public Valeur getById(int idValeur) {
		return proxyDaoValeur.getById(idValeur);
	}

}
