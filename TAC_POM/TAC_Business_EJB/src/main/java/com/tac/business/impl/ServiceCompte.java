package com.tac.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import com.tac.business.api.IServiceCompte;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceCompte.class)
@Stateless
public class ServiceCompte implements IServiceCompte {
@EJB
private IDaoMembre proxyDaoMembre;

	@Override
	public Membre majDonnees(Membre membre) { //Besoin de checkPassword pr autoriser l'update
		proxyDaoMembre.updateMembre(membre);
		return membre;
	}

	@Override
	public boolean checkPassword(String mdp, Integer idMembre) {
		if(proxyDaoMembre.checkMdp(mdp, idMembre) != null){
			return true;
		}
		return false;
	}

	@Override
	public Membre getById(Integer idMembre) {
		return proxyDaoMembre.getById(idMembre);
	}

}
