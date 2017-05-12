package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceEnvie;
import com.tac.data.api.IDaoEnvie;
import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Membre;

@Remote(IServiceEnvie.class)
@Stateless
public class ServiceEnvie implements IServiceEnvie{
	
	@EJB
	private IDaoEnvie proxyDaoEnvie;

	@Override
	public void deleteEnvie(Envie envie) {
		proxyDaoEnvie.deleteEnvie(envie);
		
	}

	@Override
	public Envie getEnvie(int idEnvie) {
		return proxyDaoEnvie.getById(idEnvie);
	}

	@Override
	public List<Envie> getByList(Liste liste) {
		return proxyDaoEnvie.getByListe(liste);
	}

	@Override
	public List<Envie> getByMembre(Membre membre) {
		return proxyDaoEnvie.getByMembre(membre);
	}

	@Override
	public Envie addEnvie(Envie envie) {
		return proxyDaoEnvie.addEnvie(envie);
	}

}
