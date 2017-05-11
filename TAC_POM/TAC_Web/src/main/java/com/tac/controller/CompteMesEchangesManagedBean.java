package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<Echange> echangeDuMembre = new ArrayList<>();
	private List<Echange> donDuMembre = new ArrayList<>();
	private String status = "";


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

	/**
	 * return une liste des échanges du membre
	 * 
	 * @return
	 */
	public List<Echange> getEchangeDuMembre() {
		membreCourant = identifBean.getMembreConnected();
		echangeDuMembre = proxyEchange.getByMembreChercheur(membreCourant.getIdMembre());
		for (Echange echange : echangeDuMembre) {
			Proposition prop = proxyEchange.getPropByEchange(echange);
			echange.setProposition(prop);
			prop.setPhotos(proxyObjet.getByProposition(prop));
		}
		return echangeDuMembre;
	}

	/**
	 * ici on récupère les echanges du membre dont il est le donnateur!
	 * 
	 * @return
	 */
	public List<Echange> getDonDuMembre() {
		membreCourant = identifBean.getMembreConnected();
		donDuMembre = proxyEchange.getByMembreDonneur(membreCourant.getIdMembre());
		for (Echange echange : donDuMembre) {
			Proposition prop = proxyEchange.getPropByEchange(echange);
			echange.setProposition(prop);
			prop.setPhotos(proxyObjet.getByProposition(prop));
		}
		return donDuMembre;
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

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public void setDonDuMembre(List<Echange> donDuMembre) {
		this.donDuMembre = donDuMembre;
	}

	public void setEchangeDuMembre(List<Echange> echangeDuMembre) {
		this.echangeDuMembre = echangeDuMembre;
	}

}
