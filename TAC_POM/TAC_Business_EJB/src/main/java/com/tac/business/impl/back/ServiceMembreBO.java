package com.tac.business.impl.back;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.back.IServiceMembreBO;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IServiceMembreBO.class)
@Stateless
public class ServiceMembreBO implements IServiceMembreBO{

	@EJB
	IDaoMembre proxyMembre;

	@Override
	public Membre updateMembre(Membre membre) {

		return proxyMembre.updateMembre(membre);
	}

	@Override
	public List<Membre> getAllActif() {
		
		return proxyMembre.getAllActif();
	}

	@Override
	public List<Membre> getAllRadie() {
		return proxyMembre.getAllRadie();
	}

	@Override
	public Membre getIdMembre(int IdMembre) {

		return proxyMembre.getById(IdMembre);
	}


	
}
