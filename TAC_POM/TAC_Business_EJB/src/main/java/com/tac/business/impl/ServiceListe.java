package com.tac.business.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceListe;
import com.tac.data.api.IDaoListe;
import com.tac.entity.Liste;
import com.tac.entity.Membre;

@Remote(IServiceListe.class)
@Stateless
public class ServiceListe implements IServiceListe {
@EJB
private IDaoListe proxyDaoListe;
	
	@Override
	public Liste addListe(Liste liste) {
		return proxyDaoListe.addListe(liste);
	}

	@Override
	public Liste updateListe(Liste newListe) {
		return proxyDaoListe.updateListe(newListe);
	}

	@Override
	public void deleteListe(Liste liste) {
	proxyDaoListe.deleteListe(liste.getIdListe());
	}

	@Override
	public List<Liste> getByMembre(Membre membre) {
		return proxyDaoListe.getByMembreId(membre.getIdMembre());
	}



}
