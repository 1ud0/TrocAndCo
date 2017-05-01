package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;

import com.tac.business.api.IServiceEvaluation;
import com.tac.data.api.IDaoEchange;
import com.tac.entity.Echange;
import com.tac.entity.Membre;

public class ServiceEvaluation implements IServiceEvaluation {
	@EJB
	private IDaoEchange proxyDaoEchange;

	@Override
	public Echange evalDonneur(Echange echange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Echange evalChercheur(Echange echange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Echange> getEvalRecues(Membre membre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Echange> getEvalDonnees(Membre membre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getNoteMoyenneMembre(Membre membre) {
		// TODO Auto-generated method stub
		return null;
	}

}
