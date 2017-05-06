package com.tac.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;
import com.tac.util.Catz;
import com.tac.util.CritereSearch;

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
	@EJB
	private IServiceCategorie proxyCat;

	// managedBean
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean connexionBean;

	// attribut
	private CritereSearch critere = new CritereSearch();
	private List<Categorie> categories;
	private List<Proposition> propositions;
	private List<Etat> etats;
	private List<Valeur> valeurs;
	private List<Localisation> adresses;
	
	

	private List<Entry<Categorie, List<Categorie>>> catsEntries;
	private Map<Categorie, List<Categorie>> mycats;
	private List<Categorie> cartouches;
	private Map<Catz, List<Catz>> catzs;

	@PostConstruct
	public void coucou() {
		System.out.println("postconstruct");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("predestroy");
	}
	
	public String seekAndNotDestroy(CritereSearch crit) {
		System.out.println(crit.getIntitule());
		return "/resultatRecherche.xhtml?faces-redirect=true";
	}
	
	public void loadingPage() {
		System.out.println(critere.getIntitule());
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
		catsEntries = new ArrayList<>(mycats.entrySet());
	}
	
	
	
	public void loaddP() {
		propositions = proxyRecherche.getPropositionsBidon();
		cartouches = new ArrayList<>();
		for (Proposition proposition : propositions) {
			List<Localisation> localisations = proxyLocalisation.getPropositionLocalisations(proposition);
			proposition.setLocalisations(localisations);
			Categorie cat = proposition.getCategorie();
			Categorie sousCat = proposition.getSousCategorie();
			int inexCat = cartouches.indexOf(cat);
			List<Categorie> sousCategories = new ArrayList<>();
			if (inexCat == -1) {
				sousCategories.add(sousCat);
				cat.setSousCategories(sousCategories);
				cartouches.add(cat);
			} else {
				Categorie catFound = cartouches.get(inexCat);
				List<Categorie> souscatFound = catFound.getSousCategories();
				if (!souscatFound.contains(sousCat)) {
					souscatFound.add(sousCat);
				}
			}
		}
	}
	
	// getters & setters
	public List<Categorie> getCategories() {
		if (categories == null) {
			categories = proxyCat.getCategorieMere();
		}
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public List<Localisation> getAdresses() {
		Membre membreConnect = connexionBean.getMembreConnected();
		if (membreConnect != null) {
			adresses = proxyLocalisation.getMembreLocalisations(membreConnect);
		}
		return adresses;
	}

	public void setAdresses(List<Localisation> adresses) {
		this.adresses = adresses;
	}
	
	public IServiceRecherche getProxyRecherche() {
		return proxyRecherche;
	}

	public void setProxyRecherche(IServiceRecherche proxyRecherche) {
		this.proxyRecherche = proxyRecherche;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceEtat getProxyEtat() {
		return proxyEtat;
	}

	public void setProxyEtat(IServiceEtat proxyEtat) {
		this.proxyEtat = proxyEtat;
	}

	public IServiceValeur getProxyValeur() {
		return proxyValeur;
	}

	public void setProxyValeur(IServiceValeur proxyValeur) {
		this.proxyValeur = proxyValeur;
	}

	public IServiceCategorie getProxyCat() {
		return proxyCat;
	}

	public void setProxyCat(IServiceCategorie proxyCat) {
		this.proxyCat = proxyCat;
	}

	public IdentificationManagedBean getConnexionBean() {
		return connexionBean;
	}

	public void setConnexionBean(IdentificationManagedBean connexionBean) {
		this.connexionBean = connexionBean;
	}

	public CritereSearch getCritere() {
		return critere;
	}

	public void setCritere(CritereSearch critere) {
		this.critere = critere;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public List<Etat> getEtats() {
		return proxyEtat.getAllEtat();
	}

	public void setEtats(List<Etat> etats) {
		this.etats = etats;
	}

	public List<Valeur> getValeurs() {
		return proxyValeur.getAllValeur();
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public List<Entry<Categorie, List<Categorie>>> getCatsEntries() {
		return catsEntries;
	}

	public void setCatsEntries(List<Entry<Categorie, List<Categorie>>> catsEntries) {
		this.catsEntries = catsEntries;
	}

	public Map<Categorie, List<Categorie>> getMycats() {
		return mycats;
	}

	public void setMycats(Map<Categorie, List<Categorie>> mycats) {
		this.mycats = mycats;
	}

	public Map<Catz, List<Catz>> getCatzs() {
		return catzs;
	}

	public void setCatzs(Map<Catz, List<Catz>> catzs) {
		this.catzs = catzs;
	}

	public List<Categorie> getCartouches() {
		return cartouches;
	}

	public void setCartouches(List<Categorie> cartouches) {
		this.cartouches = cartouches;
	}

	


}
