package com.tac.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Localisation;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;

@ManagedBean(name = "mbRecherche")
@ViewScoped
public class RechercheManagedBean {

	public static final List<String> DISTANCES = Collections
			.unmodifiableList(Arrays.asList("5km", "10km", "25km", "50km", "Pas de filtre"));

	// EJB
	@EJB
	private IServiceRecherche proxyRecherche;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceEtat proxyEtat;
	@EJB
	private IServiceValeur proxyValeur;

	// managedBean
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean connexionBean;

	// attribut
	private List<Proposition> propositions;
	private List<Etat> etats;
	private String etatSelected;
	private List<Valeur> valeurs;
	private List<String> valeursSelected;
	private String distanceSelected;
	private List<Entry<Categorie, List<Categorie>>> categories;
	private Map<Categorie, List<Categorie>> mycats;

	
	public String seekAndNotDestroy() {
		return "/resultatRecherche.xhtml?faces-redirect=true";
	}
	
	public void loadingPage() {
		propositions = proxyRecherche.getPropositionsBidon();
		mycats = new HashMap<>();
		for (Proposition proposition : propositions) {
			List<Localisation> localisations = proxyLocalisation.getPropositionLocalisations(proposition);
			proposition.setLocalisations(localisations);
			Categorie cat = proposition.getCategorie();
			Categorie sousCat = proposition.getSousCategorie();
			List<Categorie> sousCategories = new ArrayList<>();
			if (!mycats.containsKey(cat)) {
				sousCategories.add(sousCat);
				mycats.put(cat, sousCategories);
				
			} else {
				sousCategories = mycats.get(cat);
				if (!sousCategories.contains(sousCat)) {
					sousCategories.add(sousCat);
				}
			}
		}
		categories = new ArrayList<>(mycats.entrySet());
	}
	
	
	// getters & setters
	public IServiceRecherche getProxyRecherche() {
		return proxyRecherche;
	}

	public void setProxyRecherche(IServiceRecherche proxyRecherche) {
		this.proxyRecherche = proxyRecherche;
	}
	
	public List<Proposition> getPropositions() {
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

	public IdentificationManagedBean getConnexionBean() {
		return connexionBean;
	}

	public void setConnexionBean(IdentificationManagedBean connexionBean) {
		this.connexionBean = connexionBean;
	}

	public List<Etat> getEtats() {
		return proxyEtat.getAllEtat();
	}

	public void setEtats(List<Etat> etats) {
		this.etats = etats;
	}

	public IServiceEtat getProxyEtat() {
		return proxyEtat;
	}

	public void setProxyEtat(IServiceEtat proxyEtat) {
		this.proxyEtat = proxyEtat;
	}

	public String getEtatSelected() {
		return etatSelected;
	}

	public void setEtatSelected(String etatSelected) {
		this.etatSelected = etatSelected;
	}

	public List<Valeur> getValeurs() {
		return proxyValeur.getAllValeur();
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public List<String> getValeursSelected() {
		return valeursSelected;
	}

	public void setValeursSelected(List<String> valeursSelected) {
		this.valeursSelected = valeursSelected;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public String getDistanceSelected() {
		return distanceSelected;
	}

	public void setDistanceSelected(String distanceSelected) {
		this.distanceSelected = distanceSelected;
	}


	public List<Entry<Categorie, List<Categorie>>> getCategories() {
		return categories;
	}

	public void setCategories(List<Entry<Categorie, List<Categorie>>> categories) {
		this.categories = categories;
	}

	public Map<Categorie, List<Categorie>> getMycats() {
		return mycats;
	}

	public void setMycats(Map<Categorie, List<Categorie>> mycats) {
		this.mycats = mycats;
	}

}
