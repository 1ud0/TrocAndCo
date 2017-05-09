package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;





@ManagedBean(name="mbCompteTB")
@RequestScoped
public class CompteTBManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceRecherche proxySearch;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	@ManagedProperty(value="#{mbMessage}")
	private MessageManagedBean messageBean;
	
	@ManagedProperty(value="#{mbCompteEchange}")
	private CompteMesEchangesManagedBean compteEchangeBean;
	



	private Membre membreCourant;
	private List<Proposition> propositions;
	
	public Membre getMembreCourant() {
		membreCourant = identifBean.getMembreConnected();
		membreCourant.setLocalisations(proxyLocalisation.getMembreLocalisations(membreCourant));
		List<Echange> echanges = proxyEchange.getByMembre(membreCourant);
		membreCourant.setEchanges(echanges);
		return membreCourant;
	}

	
	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public MessageManagedBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageManagedBean messageBean) {
		this.messageBean = messageBean;
	}

	public CompteMesEchangesManagedBean getCompteEchangeBean() {
		return compteEchangeBean;
	}

	public void setCompteEchangeBean(CompteMesEchangesManagedBean compteEchangeBean) {
		this.compteEchangeBean = compteEchangeBean;
	}


	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public List<Echange> getEchangesQuandDonneur(Membre membre) {
		return proxyEchange.getByMembreDonneurFini(membre);
	}

	public List<Echange> getEchangesQuandAcheteur(Membre membre) {
		return proxyEchange.getByMembreChercheurFini(membre);
	}

	public IServiceRecherche getProxySearch() {
		return proxySearch;
	}

	public void setProxySearch(IServiceRecherche proxySearch) {
		this.proxySearch = proxySearch;
	}

	public List<Proposition> getPropositions() {
		return proxySearch.findSuggestion(identifBean.getMembreConnected());
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}




	


}
