package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.tac.business.api.IServiceFavori;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbFavori")
@SessionScoped
public class FavoriManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceFavori proxyFavori;

	@EJB
	private IServiceProposition proxyProposition;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	private Membre membreCourant;
	private Proposition selectedProp;

	public List<Proposition> getFavorisDuMembre() {
		membreCourant = identifBean.getMembreConnected();
		return proxyFavori.getFavorisMembre(membreCourant);

	}
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
	public String loadFavori() {
		String nav = "";
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null) {
			nav = "/favoris.xhtml?faces-redirect=true";
		}
		return nav;
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
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

}
