package com.tac.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceInscription;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceInscription.class)
@Stateless
public class ServiceInscription implements IServiceInscription {
	
	@EJB
	IDaoMembre proxyInscription;

	@Override
	public Membre addMembre(Membre membre) {
		return proxyInscription.addMembre(membre);
	}

	@Override
	public boolean checkPseudo(String pseudo) {
		if(proxyInscription.getByPseudo(pseudo) != null)
			return(false);
		else{
			return(true);
		}
		
		
	}
	
	

}
