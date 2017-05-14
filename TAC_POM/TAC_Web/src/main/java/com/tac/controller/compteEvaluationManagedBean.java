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
import com.tac.entity.Echange;
import com.tac.entity.Membre;

@ManagedBean(name = "mbCompteEvaluation")
@RequestScoped
public class compteEvaluationManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceLocalisation proxyLocalisation;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	private double noteMoyenne;
	private List<Echange> echangesQuandChercheur;
	private List<Echange> echangesQuandDonneur;

	@PostConstruct
	void init() {
		System.out.println("dans le construct compte eval");
		membreCourant = identifBean.getMembreConnected();
		List<Echange> echanges = proxyEchange.getByMembre(membreCourant);
		membreCourant.setEchanges(echanges);
		noteMoyenne = proxyEchange.getNoteMoyenne(membreCourant);
		echangesQuandChercheur = proxyEchange.getByMembreChercheurFini(membreCourant);
		echangesQuandDonneur = proxyEchange.getByMembreDonneurFini(membreCourant);
	}

	public boolean NoteVide() {
		if (noteMoyenne == -1.0) {
			return true;
		}
		return false;
	}
	
	public int getNombreNoteValeur(int noteATester) {
		int nombreDeFois = 0;
		int total = 0;
		int pourcentage = 0;
		for (Echange echange : echangesQuandChercheur) {
			if (echange.getNoteChercheur() == noteATester) {
				nombreDeFois = nombreDeFois + 1;
			}
			total = total + 1;
		}
		for (Echange echange : echangesQuandDonneur) {
			if (echange.getNoteDonneur() == noteATester) {
				nombreDeFois = nombreDeFois + 1;
			}
			total = total + 1;
		}
		if (total != 0) {
			pourcentage = (int) ((nombreDeFois * 100) / total);
		}
		return pourcentage;
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

	public double getNoteMoyenne() {
		return noteMoyenne;
	}

	public void setNoteMoyenne(double noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}

	public List<Echange> getEchangesQuandChercheur() {
		return echangesQuandChercheur;
	}

	public void setEchangesQuandChercheur(List<Echange> echangesQuandChercheur) {
		this.echangesQuandChercheur = echangesQuandChercheur;
	}

	public List<Echange> getEchangesQuandDonneur() {
		return echangesQuandDonneur;
	}

	public void setEchangesQuandDonneur(List<Echange> echangesQuandDonneur) {
		this.echangesQuandDonneur = echangesQuandDonneur;
	}


}
