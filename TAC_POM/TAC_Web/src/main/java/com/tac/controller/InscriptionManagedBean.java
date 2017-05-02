package com.tac.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tac.business.api.IServiceInscription;
import com.tac.entity.Membre;

@ManagedBean(name="mbInscription")
@RequestScoped
public class InscriptionManagedBean {

	@EJB
	private IServiceInscription proxy;
	
	private Membre newMembre = new Membre();
	private String verifPwd;

	public String createMembre() {
		proxy.addMembre(newMembre);
		return "";
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

	public String getVerifPwd() {
		return verifPwd;
	}

	public void setVerifPwd(String verifPwd) {
		this.verifPwd = verifPwd;
	}
	
	
}
