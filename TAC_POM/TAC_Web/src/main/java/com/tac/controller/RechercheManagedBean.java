package com.tac.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceDepartement;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceListe;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Departement;
import com.tac.entity.Envie;
import com.tac.entity.Etat;
import com.tac.entity.Liste;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Valeur;
import com.tac.util.CritereSearch;
import com.tac.util.Distance;
import com.tac.util.MutableInt;

@ManagedBean(name = "mbRecherche")
@SessionScoped
public class RechercheManagedBean {

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
	@EJB
	private IServiceDepartement proxyDep;
	@EJB
	private IServiceListe proxyListe;
	@EJB
	private IServiceEnvie proxyEnvie;
	@EJB
	private IServiceFavori proxyFavori;

	// managedBean
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean connexionBean;

	// attribut
	private CritereSearch critere = new CritereSearch();
	private List<Distance> distances;
	private List<Categorie> categoriesMere;
	private List<Categorie> categoriesFille;
	private List<Proposition> propositions;
	private List<Etat> etats;
	private List<Valeur> valeurs;
	private List<Localisation> adresses;
	private List<Departement> departements;
	private boolean modalRendered;
	private Integer idCategorieSelected;
	private List<Liste> listes;
	private Integer idListeSelected;
	private String newListeName;
	private Integer valeurMaxSelected;
	private Integer idCatModale;
	private Integer idSousCatModale;
	private String intituleModale;
	private Integer distanceModale;

	private List<Entry<Categorie, List<Categorie>>> catsEntries;
	private Map<Categorie, List<Categorie>> mycats;
	private Map<Categorie, MutableInt> catsCount;

	@PostConstruct
	public void loadData() {
		valeurs = proxyValeur.getAllValeur();
		etats = proxyEtat.getAllEtat();
		departements = proxyDep.getAllDepartements();
		categoriesMere = proxyCat.getCategorieMere();
		distances = new ArrayList<>();
		distances.add(new Distance("Pas de filtre", 0));
		distances.add(new Distance("5km", 5));
		distances.add(new Distance("10km", 10));
		distances.add(new Distance("25km", 25));
		distances.add(new Distance("50km", 50));
		
	}
	
	
	//Méthodes
	public String seekAndNotDestroy() {
		if (idCategorieSelected != null)
			critere.setCat(proxyCat.getById(idCategorieSelected));
		else
			critere.setCat(null);
		return "/resultatRecherche.xhtml?faces-redirect=true";
	}
	
	public void afficherModalListe() {
		modalRendered = !modalRendered;
		
	}
	
	public void startSearching() {
		System.out.println("click sur le bouton");
	}
	
	public void resetFilter() {
		critere = new CritereSearch();
	}
	
	public void getNewPropositions() {
		propositions = proxyRecherche.getNewProps(20, connexionBean.getMembreConnected());
	}
	
	public void loadingPage() {
		propositions = proxyRecherche.rechercher(critere, connexionBean.getMembreConnected());
		mycats = new HashMap<>();
		catsCount = new HashMap<>();
		for (Proposition proposition : propositions) {
			Categorie cat = proposition.getCategorie();
			Categorie sousCat = proposition.getSousCategorie();
			List<Categorie> sousCategories = new ArrayList<>();
			if (!mycats.containsKey(cat)) {
				sousCategories.add(sousCat);
				mycats.put(cat, sousCategories);
				catsCount.put(cat, new MutableInt());
				catsCount.put(sousCat, new MutableInt());
			} else {
				MutableInt compteur = catsCount.get(cat);
				compteur.increment();
				sousCategories = mycats.get(cat);
				if (!sousCategories.contains(sousCat)) {
					sousCategories.add(sousCat);
					catsCount.put(sousCat, new MutableInt());
				} else {
					compteur = catsCount.get(sousCat);
					compteur.increment();
				}
			}
			
		}
		catsEntries = new ArrayList<>(mycats.entrySet());
	}	
	
	public Integer getNbOccurence(Categorie cat) {
		return catsCount.get(cat).get();
	}
	
	public void listenerCat(Categorie cat) {
		if (cat == null) {
			critere.setCat(null);
		} else {
			critere.setCat(cat);
		}
		critere.setSousCat(null);
	}
	
	public void listenerSousCat(Categorie sousCat) {
		critere.setCat(sousCat.getCategorieMere());
		critere.setSousCat(sousCat);
	}
	
	//listener modale ajouter une envie
	public void listenerEnvie() {
		listes = proxyListe.getByMembre(connexionBean.getMembreConnected());
		Categorie catMere = critere.getCat();
		if (catMere != null) {
			System.out.println(catMere.getIntitule());
			categoriesFille = proxyCat.getCategorieFille(catMere.getIdCategorie());
			idCatModale = catMere.getIdCategorie();
		}
		Categorie catFille = critere.getSousCat();
		if (catFille != null) {
			System.out.println(catFille.getIntitule());
			idSousCatModale = catFille.getIdCategorie();
		}
		intituleModale = critere.getIntitule();
	}
	
	public void listenerBtnCreateListe() {
		Liste nouvelleListe = new Liste();
		nouvelleListe.setTitreListe(newListeName);
		nouvelleListe.setMembre(connexionBean.getMembreConnected());
		proxyListe.addListe(nouvelleListe);
		modalRendered = false;
		listes = proxyListe.getByMembre(connexionBean.getMembreConnected());
	}
	
	public void listenerBtnCancelAddEnvie() {
		modalRendered = false;
	}
	
	public void listenerDDLCat() {
		if (idCatModale != null) {
			categoriesFille = proxyCat.getCategorieFille(idCatModale);
		}
	}
	
	public void listenerAjoutEnvie() {
		Envie envie = new Envie();
		envie.setIntitule(intituleModale);
		if (idCatModale != null) {
			envie.setCategorie(proxyCat.getById(idCatModale));
		}
		if (idSousCatModale != null) {
			envie.setSousCategorie(proxyCat.getById(idSousCatModale));
		}
		envie.setValeur(proxyValeur.getById(valeurMaxSelected));
		envie.setListe(proxyListe.getById(idListeSelected));
		envie.setDistance(distanceModale);
		proxyEnvie.addEnvie(envie);
	}
	
	
	// getters & setters
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
		return etats;
	}

	public void setEtats(List<Etat> etats) {
		this.etats = etats;
	}

	public List<Valeur> getValeurs() {
		return valeurs;
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


	public Map<Categorie, MutableInt> getCatsCount() {
		return catsCount;
	}

	public void setCatsCount(Map<Categorie, MutableInt> catsCount) {
		this.catsCount = catsCount;
	}

	public IServiceDepartement getProxyDep() {
		return proxyDep;
	}

	public void setProxyDep(IServiceDepartement proxyDep) {
		this.proxyDep = proxyDep;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public boolean isModalRendered() {
		return modalRendered;
	}


	public void setModalRendered(boolean modalRendered) {
		this.modalRendered = modalRendered;
	}


	public Integer getIdCategorieSelected() {
		return idCategorieSelected;
	}


	public void setIdCategorieSelected(Integer idCategorieSelected) {
		this.idCategorieSelected = idCategorieSelected;
	}


	public List<Liste> getListes() {
		return listes;
	}


	public void setListes(List<Liste> listes) {
		this.listes = listes;
	}


	public IServiceListe getProxyListe() {
		return proxyListe;
	}


	public void setProxyListe(IServiceListe proxyListe) {
		this.proxyListe = proxyListe;
	}


	public Integer getIdListeSelected() {
		return idListeSelected;
	}


	public void setIdListeSelected(Integer idListeSelected) {
		this.idListeSelected = idListeSelected;
	}


	public String getNewListeName() {
		return newListeName;
	}


	public void setNewListeName(String newListeName) {
		this.newListeName = newListeName;
	}


	public Integer getValeurMaxSelected() {
		return valeurMaxSelected;
	}


	public void setValeurMaxSelected(Integer valeurMaxSelected) {
		this.valeurMaxSelected = valeurMaxSelected;
	}


	public List<Categorie> getCategoriesMere() {
		return categoriesMere;
	}


	public void setCategoriesMere(List<Categorie> categoriesMere) {
		this.categoriesMere = categoriesMere;
	}


	public List<Categorie> getCategoriesFille() {
		return categoriesFille;
	}


	public void setCategoriesFille(List<Categorie> categoriesFille) {
		this.categoriesFille = categoriesFille;
	}


	public Integer getIdCatModale() {
		return idCatModale;
	}


	public void setIdCatModale(Integer idCatModale) {
		this.idCatModale = idCatModale;
	}


	public Integer getIdSousCatModale() {
		return idSousCatModale;
	}


	public void setIdSousCatModale(Integer idSousCatModale) {
		this.idSousCatModale = idSousCatModale;
	}


	public String getIntituleModale() {
		return intituleModale;
	}


	public void setIntituleModale(String intituleModale) {
		this.intituleModale = intituleModale;
	}


	public List<Distance> getDistances() {
		return distances;
	}


	public void setDistances(List<Distance> distances) {
		this.distances = distances;
	}


	public Integer getDistanceModale() {
		return distanceModale;
	}


	public void setDistanceModale(Integer distanceModale) {
		this.distanceModale = distanceModale;
	}


	public IServiceEnvie getProxyEnvie() {
		return proxyEnvie;
	}


	public void setProxyEnvie(IServiceEnvie proxyEnvie) {
		this.proxyEnvie = proxyEnvie;
	}


	public IServiceFavori getProxyFavori() {
		return proxyFavori;
	}


	public void setProxyFavori(IServiceFavori proxyFavori) {
		this.proxyFavori = proxyFavori;
	}



}
