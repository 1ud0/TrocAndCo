package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceRecherche;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Proposition;

@Remote(IServiceRecherche.class)
@Stateless
public class ServiceRecherche implements IServiceRecherche {

	@EJB
	private IDaoProposition proxyProposition;
	
	@Override
	public List<Proposition> getPropositionsBidon() {
		return proxyProposition.getNouveautes(50);
	}

}
