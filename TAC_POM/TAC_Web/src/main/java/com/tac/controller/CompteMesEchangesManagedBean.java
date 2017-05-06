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
	private String status = "";
	private List<Proposition> propositionDuMembre = new ArrayList<>();

	/**
	 * Pour lecture ludo ^ v ^ \ / \ / v Permet de connaitre quel est le status
	 * des échanges
	 * 
	 * @param echange
	 * @return
	 */
	public String statusEchange(Echange echange) {
		if (echange.getDateAnnul() != null && echange.getDateinit() != null) {
			status = "annule";
		} else if (echange.getDateRefus() != null) {
			status = "refus";
		} else if (echange.getDateValidation() != null) {
			status = "effectue";
		} else if (echange.getDateAcceptation() != null && echange.getDateAnnul() == null
				&& echange.getDateRefus() == null && echange.getDateValidation() == null) {
			status = "encours";
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
		echangeDuMembre = proxyEchange.getByMembre(membreCourant);
		for (Echange echange : echangeDuMembre) {
			Proposition prop = proxyEchange.getPropByEchange(echange);
			echange.setProposition(prop);
			prop.setPhotos(proxyObjet.getByProposition(prop));
		}
		return echangeDuMembre;
	}

	/**
	 * ici on récupère les echanges du membre dont il est l'acquéreur!
	 * 
	 * @return
	 */
	public List<Echange> getEchangeByPropositionDuMembre() {
		membreCourant = identifBean.getMembreConnected();
		propositionDuMembre = proxyObjet.getByMembre(membreCourant);
		for (Proposition proposition : propositionDuMembre) {
			 Echange echange = proxyEchange.getEchangeByProp(proposition);
				 
		
		}
		return echangeDuMembre;
	}

	/**
	 *  a modifier
	 * @param echange
	 * @return
	 */
	public String loadEchangeAcquereur(Echange echange) {
		String nav = "";
		selectedEchange = echange;

		if (selectedEchange != null) {
			nav = "/echangeRecap.xhtml?faces-redirect=true";
		}
		return nav;
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

}
