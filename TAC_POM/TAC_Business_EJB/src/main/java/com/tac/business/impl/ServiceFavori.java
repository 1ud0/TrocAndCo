package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceFavori;
import com.tac.data.api.IDaoFavori;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IServiceFavori.class)
@Stateless
public class ServiceFavori implements IServiceFavori {
	@EJB
	private IDaoFavori proxyDaoFavori;

	@Override
	public Proposition addToFavoris(Proposition proposition, Membre membre) {
		return proxyDaoFavori.addFavori(proposition, membre);

	}

	@Override
	public void deleteFavori(Proposition proposition, Membre membre) {
		proxyDaoFavori.deleteFavori(proposition, membre);

	}

	@Override
	public List<Proposition> getFavorisMembre(Membre membre) {
		return proxyDaoFavori.getFavorisByMembre(membre);
	}

}
