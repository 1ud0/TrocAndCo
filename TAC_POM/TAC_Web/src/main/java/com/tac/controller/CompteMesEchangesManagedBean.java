package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbCompteEchange")
@ViewScoped
public class CompteMesEchangesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceProposition proxyObjet;
	@EJB
	private IServiceCategorie proxyCategorie;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	private Echange selectedEchange;
	private Proposition selectedProposition;
	private Membre membreCourant;
	private List<Echange> echangeDuMembre;
	private List<Echange> donDuMembre;
	private String status;

	@PostConstruct
	public void init() {
		System.out.println("dans le construct compte echange");
		membreCourant = identifBean.getMembreConnected();
		echangeDuMembre = proxyEchange.getByMembreChercheur(membreCourant.getIdMembre());
		donDuMembre = proxyEchange.getByMembreDonneur(membreCourant.getIdMembre());
	}

	/**
	 *  Permet de connaitre quel est le status
	 * des échanges
	 * 
	 * @param echange
	 * @return
	 */
	public String statusEchange(Echange echange) {
		if (echange.getDateAnnul() != null) {
			status = "annule";
		} else if (echange.getDateRefus() != null) {
			status = "refus";
		} else if (echange.getDateValidation() != null) {
			status = "effectue";
		} else {
			status = "en cours";
		}
		return status;
	}

	//getters & setters
	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public IServiceProposition getProxyObjet() {
		return proxyObjet;
	}

	public void setProxyObjet(IServiceProposition proxyObjet) {
		this.proxyObjet = proxyObjet;
	}

	public IServiceCategorie getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(IServiceCategorie proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Echange getSelectedEchange() {
		return selectedEchange;
	}

	public void setSelectedEchange(Echange selectedEchange) {
		this.selectedEchange = selectedEchange;
	}

	public Proposition getSelectedProposition() {
		return selectedProposition;
	}

	public void setSelectedProposition(Proposition selectedProposition) {
		this.selectedProposition = selectedProposition;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public List<Echange> getEchangeDuMembre() {
		return echangeDuMembre;
	}

	public void setEchangeDuMembre(List<Echange> echangeDuMembre) {
		this.echangeDuMembre = echangeDuMembre;
	}

	public List<Echange> getDonDuMembre() {
		return donDuMembre;
	}

	public void setDonDuMembre(List<Echange> donDuMembre) {
		this.donDuMembre = donDuMembre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
