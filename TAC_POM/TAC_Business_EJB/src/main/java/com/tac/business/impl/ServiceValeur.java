package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceValeur;
import com.tac.data.api.IDaoValeur;
import com.tac.entity.Valeur;

@Remote(IServiceValeur.class)
@Stateless
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

	@Override
	public List<Valeur> getAllValeur() {
		return proxyDaoValeur.getAllValeur();
	}

}
