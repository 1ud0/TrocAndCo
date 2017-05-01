package com.tac.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceIdentification;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceIdentification.class)
@Stateless
public class ServiceIdentification implements IServiceIdentification{

	@EJB
	IDaoMembre proxyMembre;
	
	@Override
	public Membre identification(String pseudo, String mdp) {
		Membre memberIdentified = proxyMembre.identifyMembre(pseudo, mdp);
		return memberIdentified;
	}

}
