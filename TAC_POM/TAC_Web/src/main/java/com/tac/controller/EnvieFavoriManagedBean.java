package com.tac.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceIdentification;
import com.tac.business.api.IServiceListe;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbEnvieFavori")
@ViewScoped
public class EnvieFavoriManagedBean {

	@EJB
	private IServiceEnvie proxyEnvie;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	@EJB
	private IServiceListe proxyListe;
	@EJB
	private IServiceFavori proxyFavori;
	@EJB
	private IServiceRecherche proxyRecherche;	
	@EJB
	private IServiceIdentification proxyIdentif;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	private Proposition selectedProp;
	private List<Envie> envies;
	private List<Proposition> favoris;
	private Map<Envie, List<Proposition>> mesEnvies;
	private List<Liste> mesListes;
	private List<Proposition> mesFavoris;
	private boolean favoriShowing = true;

	@PostConstruct
	public void init() {
		System.out.println("dans le construct envie");
		membreCourant = identifBean.getMembreConnected();
		membreCourant = proxyIdentif.identification(membreCourant.getMail(), membreCourant.getPassword());
		if (membreCourant != null) {
			mesEnvies = new HashMap<>();
			mesListes = proxyListe.getByMembre(membreCourant);
			for (Liste liste : mesListes) {
				for (Envie envie : liste.getEnvies()) {
					mesEnvies.put(envie, proxyRecherche.rechercherEnvie(envie));
				}
			}
			mesFavoris = proxyFavori.getFavorisMembre(membreCourant);
			favoris = mesFavoris;
		}
	}

	public List<Proposition> getSuggestions(Envie envie) {
		List<Proposition> props = mesEnvies.get(envie);
		return props;
	}
	
	public void loadFavoris() {
		favoris = mesFavoris;
		favoriShowing = true;
		envies = new ArrayList<>();
	}
	

	public List<Proposition> loadPropositions(Envie envie) {
		return proxyRecherche.rechercherEnvie(envie);
	}

	public void deleteEnvie(Envie envie) {
		proxyEnvie.deleteEnvie(envie);
		envies.remove(envie);
	}

	public void deleteFavoris(Proposition proposition) {
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			proxyFavori.deleteFavori(proposition, membreCourant);
			favoris.remove(proposition);
		}
	}

	public boolean isEnvieDeLaListe(Envie envie, Liste liste) {
		if (envie.getListe().getIdListe() == liste.getIdListe()) {
			return true;
		}
		return false;
	}


	public void chargerEnvie(Liste liste) {
		envies = liste.getEnvies();
		favoriShowing = false;
		favoris = new ArrayList<>();
	}


	public boolean valeurVide(Envie envie) {
		if (envie.getValeur() == null) {
			return true;
		}
		return false;
	}

	public IServiceEnvie getProxyEnvie() {
		return proxyEnvie;
	}

	public void setProxyEnvie(IServiceEnvie proxyEnvie) {
		this.proxyEnvie = proxyEnvie;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public IServiceListe getProxyListe() {
		return proxyListe;
	}

	public void setProxyListe(IServiceListe proxyListe) {
		this.proxyListe = proxyListe;
	}

	public IServiceFavori getProxyFavori() {
		return proxyFavori;
	}

	public void setProxyFavori(IServiceFavori proxyFavori) {
		this.proxyFavori = proxyFavori;
	}

	public IServiceRecherche getProxyRecherche() {
		return proxyRecherche;
	}

	public void setProxyRecherche(IServiceRecherche proxyRecherche) {
		this.proxyRecherche = proxyRecherche;
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

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

	public List<Envie> getEnvies() {
		return envies;
	}

	public void setEnvies(List<Envie> envies) {
		this.envies = envies;
	}

	public List<Proposition> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Proposition> favoris) {
		this.favoris = favoris;
	}

	public Map<Envie, List<Proposition>> getMesEnvies() {
		return mesEnvies;
	}

	public void setMesEnvies(Map<Envie, List<Proposition>> mesEnvies) {
		this.mesEnvies = mesEnvies;
	}

	public List<Liste> getMesListes() {
		return mesListes;
	}

	public void setMesListes(List<Liste> mesListes) {
		this.mesListes = mesListes;
	}

	public boolean isFavoriShowing() {
		return favoriShowing;
	}

	public void setFavoriShowing(boolean favoriShowing) {
		this.favoriShowing = favoriShowing;
	}

	public List<Proposition> getMesFavoris() {
		return mesFavoris;
	}

	public void setMesFavoris(List<Proposition> mesFavoris) {
		this.mesFavoris = mesFavoris;
	}


}
