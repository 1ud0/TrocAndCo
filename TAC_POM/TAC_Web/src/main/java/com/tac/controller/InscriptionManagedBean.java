package com.tac.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceInscription;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;

@ManagedBean(name="mbInscription")
@RequestScoped
public class InscriptionManagedBean {

	@EJB
	private IServiceInscription proxy;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean connexionBean;
	
	private Membre newMembre = new Membre();
	private Localisation lieu = new Localisation();

	public String createMembre() {
		List<Localisation> lieux = new ArrayList<>();
		lieux.add(lieu);
		newMembre.setLocalisations(lieux);
		//TODO mettre avatar par defaut
		String nav = "";
		newMembre = proxy.addMembre(newMembre);
		if (newMembre != null) {
			connexionBean.setMembreConnected(newMembre);
			nav = "/compte-TB.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	public IServiceInscription getProxy() {
		return proxy;
	}

	public void setProxy(IServiceInscription proxy) {
		this.proxy = proxy;
	}

	public Membre getNewMembre() {
		return newMembre;
	}

	public void setNewMembre(Membre newMembre) {
		this.newMembre = newMembre;
	}

	public Localisation getLieu() {
		return lieu;
	}

	public void setLieu(Localisation lieu) {
		this.lieu = lieu;
	}

	public IdentificationManagedBean getConnexionBean() {
		return connexionBean;
	}

	public void setConnexionBean(IdentificationManagedBean connexionBean) {
		this.connexionBean = connexionBean;
	}
	
	
}
