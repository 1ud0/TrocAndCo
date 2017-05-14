package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRdv;
import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Rdv;



@ManagedBean(name="mbCompteTB")
@ViewScoped
public class CompteTBManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceRecherche proxySearch;
	@EJB
	private IServiceRdv proxyRdv;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	@ManagedProperty(value="#{mbCompteEchange}")
	private CompteMesEchangesManagedBean compteEchangeBean;
	private Membre membreCourant;
	private List<Rdv> rdvIncoming;
	private List<Echange> echangesMembreEval;
	private List<Proposition> suggestions;

	@PostConstruct
	public void init() {
		membreCourant = identifBean.getMembreConnected();
		List<Echange> echanges = proxyEchange.getByMembre(membreCourant);
		membreCourant.setEchanges(echanges);
		rdvIncoming = proxyRdv.getByMembreIdEtMembrePropositionPasEncorePasse(membreCourant.getIdMembre());
		echangesMembreEval = proxyEchange.getByMembreFini(membreCourant.getIdMembre());
		suggestions = proxySearch.findSuggestion(membreCourant);		
	}	
	
	//getters & setters
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

	public IServiceRecherche getProxySearch() {
		return proxySearch;
	}

	public void setProxySearch(IServiceRecherche proxySearch) {
		this.proxySearch = proxySearch;
	}

	public IServiceRdv getProxyRdv() {
		return proxyRdv;
	}

	public void setProxyRdv(IServiceRdv proxyRdv) {
		this.proxyRdv = proxyRdv;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public List<Rdv> getRdvIncoming() {
		return rdvIncoming;
	}

	public void setRdvIncoming(List<Rdv> rdvIncoming) {
		this.rdvIncoming = rdvIncoming;
	}

	

	public List<Echange> getEchangesMembreEval() {
		return echangesMembreEval;
	}


	public void setEchangesMembreEval(List<Echange> echangesMembreEval) {
		this.echangesMembreEval = echangesMembreEval;
	}


	public List<Proposition> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Proposition> suggestions) {
		this.suggestions = suggestions;
	}

	public CompteMesEchangesManagedBean getCompteEchangeBean() {
		return compteEchangeBean;
	}

	public void setCompteEchangeBean(CompteMesEchangesManagedBean compteEchangeBean) {
		this.compteEchangeBean = compteEchangeBean;
	}
	


}
