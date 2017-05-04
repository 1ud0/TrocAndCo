package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceCompte;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbProfil")
@RequestScoped
public class ProfilManagedBean {

	@EJB
	private IServiceCompte proxyCompte;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceProposition proxyProposition;

	@ManagedProperty(value = "#{mbObjet}")
	private ObjetManagedBean objetManagedBean;

	private Membre membreCourant;
	private Proposition selectedProp;

	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true";
		}
		return nav;
	}

	public IServiceCompte getProxyCompte() {
		return proxyCompte;
	}

	public void setProxyCompte(IServiceCompte proxyCompte) {
		this.proxyCompte = proxyCompte;
	}

	public ObjetManagedBean getObjetManagedBean() {
		return objetManagedBean;
	}

	public void setObjetManagedBean(ObjetManagedBean objetManagedBean) {
		this.objetManagedBean = objetManagedBean;
	}

	public Membre getMembreCourant() {
		membreCourant = objetManagedBean.getSelectedMembre();
		membreCourant.setLocalisations(proxyLocalisation.getMembreLocalisations(membreCourant));
		List<Proposition> propositions = proxyProposition.getByMembre(membreCourant);
		for (Proposition proposition : propositions) {
			proposition.setPhotos(proxyProposition.getByProposition(proposition));
			proposition.setLocalisations(proxyLocalisation.getPropositionLocalisations(proposition));

		}

		membreCourant.setPropositions(propositions);

		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

}