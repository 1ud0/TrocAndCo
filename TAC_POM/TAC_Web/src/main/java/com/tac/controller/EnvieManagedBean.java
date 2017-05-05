package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.tac.business.api.IServiceEnvie;
import com.tac.business.api.IServiceListe;
import com.tac.business.api.IServiceLocalisation;
import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;

@ManagedBean(name = "mbEnvie")
@SessionScoped
public class EnvieManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceEnvie proxyEnvie;
	
	@EJB
	private IServiceLocalisation proxyLocalisation;
	
	@EJB
	private IServiceListe proxyListe;
	
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	private Membre membreCourant;
	
	public void securePage() {
		membreCourant = identifBean.getMembreConnected();
		if(membreCourant == null) {
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			nav.performNavigation("/accueil.xhtml?faces-redirect=true");
		}
	}
	
	public List<Envie> getEnviesDuMembre(){
		membreCourant = identifBean.getMembreConnected();
		return proxyEnvie.getByMembre(membreCourant);
		
	}
	
	
	public List<Localisation> getLocalisationByMembre(){
		membreCourant = identifBean.getMembreConnected();
		return proxyLocalisation.getMembreLocalisations(membreCourant);
	}
	
	public boolean valeurVide(Envie envie){
		if(envie.getValeur() == null){
			return true;
		}
		return false;
	}
	
	public int nombreEnviesByListe(Liste listeActuelle){
		return listeActuelle.getEnvies().size();
	}
	
	public List<Envie> getEnvieByList(Liste listeActuelle){
		return proxyEnvie.getByList(listeActuelle);
	}
	
	public List<Liste> getListesByMembre(){
		membreCourant = identifBean.getMembreConnected();
		return proxyListe.getByMembre(membreCourant);
	}

	public IServiceEnvie getProxyEnvie() {
		return proxyEnvie;
	}

	public void setProxyEnvie(IServiceEnvie proxyEnvie) {
		this.proxyEnvie = proxyEnvie;
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
