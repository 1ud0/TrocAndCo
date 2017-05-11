package com.tac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.tac.business.api.IServiceAccueil;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbAccueil")
public class AccueilManagedBean {

	public static final int NB_NOUVEAUTE_ACCUEIL = 12;

	@EJB
	private IServiceAccueil proxyAccueil;

	private List<Proposition> lasts;
	private long nbPropDispo;
	private long nbMembre;
	private long nbEchangesFinis;
	private long nbCO2;

	@PostConstruct
	public void init() {
		lasts = proxyAccueil.getNouveaute(NB_NOUVEAUTE_ACCUEIL);
		nbPropDispo = proxyAccueil.getNbPropDispo();
		nbMembre = proxyAccueil.getNbMembre();
		nbEchangesFinis = proxyAccueil.getNbEchangesFinis();
		nbCO2 = nbEchangesFinis * 50;
	}

	public String dureeAjout(Date date) {
		Date now = new Date();
		long time = now.getTime() - date.getTime();
		int msToJour = 3600 * 1000 * 24;
		int msToHeure = 3600 * 1000;
		int msToMin = 1000 * 60;
		long dureejours = time / msToJour;
		long dureeheures = time / msToHeure - dureejours * 24;
		long dureemin = time / msToMin - dureeheures * 60 - dureejours * 24 * 60;

		return " Il y a " + dureejours + "j " + dureeheures + "h " + dureemin + "min!";
	}

	public IServiceAccueil getProxyAccueil() {
		return proxyAccueil;
	}

	public void setProxyAccueil(IServiceAccueil proxyAccueil) {
		this.proxyAccueil = proxyAccueil;
	}

	public List<Proposition> getLasts() {
		return lasts;
	}

	public void setLasts(List<Proposition> lasts) {
		this.lasts = lasts;
	}

	public long getNbPropDispo() {
		return nbPropDispo;
	}

	public void setNbPropDispo(long nbPropDispo) {
		this.nbPropDispo = nbPropDispo;
	}

	public long getNbMembre() {
		return nbMembre;
	}

	public void setNbMembre(long nbMembre) {
		this.nbMembre = nbMembre;
	}

	public long getNbEchangesFinis() {
		return nbEchangesFinis;
	}

	public void setNbEchangesFinis(long nbEchangesFinis) {
		this.nbEchangesFinis = nbEchangesFinis;
	}

	public long getNbCO2() {
		return nbCO2;
	}

	public void setNbCO2(long nbCO2) {
		this.nbCO2 = nbCO2;
	}

}
