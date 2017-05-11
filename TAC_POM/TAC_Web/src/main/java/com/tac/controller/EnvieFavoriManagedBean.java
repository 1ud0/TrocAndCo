package com.tac.controller;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceListe;
import com.tac.business.api.IServiceLocalisation;
import com.tac.business.api.IServiceRecherche;
import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;


@ManagedBean(name = "mbEnvieFavori")
@SessionScoped
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

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	private Proposition selectedProp;
	private List<Envie> envies;
	private List<Proposition> favoris;

	


	
	public List<Proposition> loadPropositions(Envie envie) {
		return proxyRecherche.rechercherEnvie(envie);
	}
	
	public void deleteEnvie(Envie envie){
		proxyEnvie.deleteEnvie(envie);
		envies.remove(envie);
	}
	
	public void deleteFavoris(Proposition proposition){
		membreCourant = identifBean.getMembreConnected();
		if(membreCourant != null){
		proxyFavori.deleteFavori(proposition, membreCourant);
		favoris.remove(proposition);
		}
	}
	
	public void chargerFavoris() {
		viderTout();
		favoris = proxyFavori.getFavorisMembre(getMembreCourant());
	}

	public boolean isEnvieDeLaListe(Envie envie, Liste liste) {
		if (envie.getListe().getIdListe() == liste.getIdListe()) {
			return true;
		}
		return false;
	}

	public List<Localisation> getLocalisationByMembre() {
		membreCourant = identifBean.getMembreConnected();
		if(membreCourant != null){
		return proxyLocalisation.getMembreLocalisations(membreCourant);
		}
		return null;
	}

	public void chargerEnvie(Liste liste) {
		viderTout();
		envies = proxyEnvie.getByList(liste);
	}

	public void viderTout() {
		envies = new ArrayList<>();
		favoris = new ArrayList<>();
	}

	public int nombreEnviesByListe(Liste listeActuelle) {
		return listeActuelle.getEnvies().size();
	}

	public int nombreFavoris() {
		return proxyFavori.getFavorisMembre(getMembreCourant()).size();
	}

	public List<Liste> getListesByMembre() {
		membreCourant = identifBean.getMembreConnected();
		if(membreCourant != null){

		return proxyListe.getByMembre(membreCourant);
		}
		return null;
	}

	public boolean valeurVide(Envie envie) {
		if (envie.getValeur() == null) {
			return true;
		}
		return false;
	}
	
	public List<Envie> getEnviesDuMembre(Membre membre){
		return proxyEnvie.getByMembre(membre);
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

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Membre getMembreCourant() {
		return identifBean.getMembreConnected();
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

}
