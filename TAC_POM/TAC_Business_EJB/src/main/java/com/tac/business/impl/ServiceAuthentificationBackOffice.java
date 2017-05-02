package com.tac.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceAuthentificationBackOffice;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceAuthentificationBackOffice.class)
@Stateless
public class ServiceAuthentificationBackOffice implements IServiceAuthentificationBackOffice {
	@EJB
	IDaoMembre proxyIDaoMembre;

	@Override
	public Membre authentification(String mail, String mdp) {
		Membre membreAuth = proxyIDaoMembre.identifyMembre(mail, mdp);
		return membreAuth;
		
	}

}
