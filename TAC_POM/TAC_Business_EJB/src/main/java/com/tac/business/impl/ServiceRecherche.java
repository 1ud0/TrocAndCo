package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceRecherche;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Proposition;
import com.tac.util.CritereSearch;

@Remote(IServiceRecherche.class)
@Stateless
public class ServiceRecherche implements IServiceRecherche {

	@EJB
	private IDaoProposition proxyProposition;
	
	@Override
	public List<Proposition> getPropositionsBidon() {
		return proxyProposition.getNouveautes(20);
	}

	@Override
	public List<Proposition> rechercher(CritereSearch carac) {
		System.out.println("intitule : " + carac.getIntitule());
		System.out.println("cat : " + carac.getCat());
		System.out.println("souscat : " + carac.getSousCat());
		System.out.println("dep : " + carac.getDepartement());
		System.out.println("dist : " + carac.getDistanceMax());
		System.out.println("etat : " + carac.getEtat());
		for (String  elem : carac.getLieux()) {
			System.out.println("lieu : " + elem);
		}
		for (String coucou : carac.getValeurs()) {
			System.out.println("val : " + coucou);
		}
		return null;
	}

}
