package com.tac.business.impl.back;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.back.IServiceAuthentificationBackOffice;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceAuthentificationBackOffice.class)
@Stateless
public class ServiceAuthentificationBackOffice implements IServiceAuthentificationBackOffice {
	@EJB
	IDaoMembre proxyIDaoMembre;

	@Override
	public Membre authentification(String mail, String mdp) {		
		return proxyIDaoMembre.identifyMembre(mail, mdp);
	}

}
