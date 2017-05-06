package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceFavori;
import com.tac.data.api.IDaoFavori;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

@Remote(IServiceFavori.class)
@Stateless
public class ServiceFavori implements IServiceFavori {
	@EJB
	private IDaoFavori proxyDaoFavori;
	
	@EJB
	private IDaoProposition proxyDaoProposition;
	
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

	@Override
	public Proposition getFavoriById(int idProposition) {
		try {
			return proxyDaoProposition.getById(idProposition);
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public void deleteAllFavori(Proposition proposition) {

		proxyDaoFavori.deleteAllFavori(proposition);
	}
	
	

}
