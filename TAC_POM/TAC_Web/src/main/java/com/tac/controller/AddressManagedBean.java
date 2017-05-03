package com.tac.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceLocalisation;
import com.tac.entity.Localisation;

@ManagedBean(name="mbAddress")
@ViewScoped
public class AddressManagedBean {

	@EJB
	private IServiceLocalisation proxyLoc;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean connexionBean;
	
	private Localisation lieu;

	
	public void ajouterLocalisation() {
		lieu.setMembre(connexionBean.getMembreConnected());
		proxyLoc.addLocalisation(lieu);
	}
	
	
	public IServiceLocalisation getProxyLoc() {
		return proxyLoc;
	}

	public void setProxyLoc(IServiceLocalisation proxyLoc) {
		this.proxyLoc = proxyLoc;
	}

	public IdentificationManagedBean getConnexionBean() {
		return connexionBean;
	}

	public void setConnexionBean(IdentificationManagedBean connexionBean) {
		this.connexionBean = connexionBean;
	}

	public Localisation getLieu() {
		return lieu;
	}

	public void setLieu(Localisation lieu) {
		this.lieu = lieu;
	}
	
	
}
