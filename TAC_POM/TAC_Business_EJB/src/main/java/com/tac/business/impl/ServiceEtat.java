package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceEtat;
import com.tac.data.api.IDaoEtat;
import com.tac.entity.Etat;
@Remote(IServiceEtat.class)
@Stateless
public class ServiceEtat implements IServiceEtat{
	
@EJB
private IDaoEtat proxyDaoEtat;
	@Override
	public Etat addEtat(Etat etat) {
		return proxyDaoEtat.addEtat(etat);
	}

	@Override
	public Etat updateEtat(Etat etat) {
		return proxyDaoEtat.updateEtat(etat);
	}

	@Override
	public void deleteEtat(Etat etat) {
		proxyDaoEtat.deleteEtat(etat);
	}

	@Override
	public Etat getById(int idEtat) {
		return proxyDaoEtat.getById(idEtat);
	}

	@Override
	public List<Etat> getAllEtat() {
		return proxyDaoEtat.getAllEtat();
	}

}
