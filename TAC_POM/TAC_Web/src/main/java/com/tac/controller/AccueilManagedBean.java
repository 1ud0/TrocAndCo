package com.tac.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.tac.business.api.IServiceAccueil;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbAccueil")
public class AccueilManagedBean {

	public static final int NBNOUVEAUTEACCUEIL = 12;

	@EJB
	private IServiceAccueil proxyAccueil;

	public int nbPropositionDispo() {
		return proxyAccueil.getAllPropDispo().size();
	}

	public int nbMembre() {
		return proxyAccueil.getAllMembre().size();
	}

	public int nbEchangeFini() {
		return proxyAccueil.getAllEchangeFini().size();
	}

	public int nbCO2() {
		return proxyAccueil.getAllEchangeFini().size() * 50;
	}

	public List<Proposition> dernieresPropositions() {
		return proxyAccueil.getNouveaute(NBNOUVEAUTEACCUEIL);
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

}
