package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

@ManagedBean(name="mbRecherche")
@RequestScoped
public class RechercheManagedBean {

	@EJB
	private IServiceRecherche proxyRecherche;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	
	private List<Proposition> propositions;

	public IServiceRecherche getProxyRecherche() {
		return proxyRecherche;
	}

	public void setProxyRecherche(IServiceRecherche proxyRecherche) {
		this.proxyRecherche = proxyRecherche;
	}

	public List<Proposition> getPropositions() {
		propositions = proxyRecherche.getPropositionsBidon();
		for(Proposition proposition:propositions){
			List<Localisation> localisations = proxyLocalisation.getPropositionLocalisations(proposition);
			proposition.setLocalisations(localisations);
		}
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}
	
	
}
