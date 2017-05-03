package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Proposition;

@ManagedBean(name="mbRecherche")
@RequestScoped
public class RechercheManagedBean {

	@EJB
	private IServiceRecherche proxyRecherche;
	
	private List<Proposition> propositions;

	public IServiceRecherche getProxyRecherche() {
		return proxyRecherche;
	}

	public void setProxyRecherche(IServiceRecherche proxyRecherche) {
		this.proxyRecherche = proxyRecherche;
	}

	public List<Proposition> getPropositions() {
		propositions = proxyRecherche.getPropositionsBidon();
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	
}
