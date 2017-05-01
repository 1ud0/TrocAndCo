package com.tac.controller;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tac.business.api.IServiceIdentification;
import com.tac.entity.Membre;
import java.io.Serializable;

@SuppressWarnings("serial")
@ManagedBean(name="mbIdentif")
@SessionScoped
public class IdentificationManagedBean implements Serializable {

	@EJB
	private IServiceIdentification proxyIdentification;
	private String mail;
	private String mdp;
	private Membre membreConnected;
	
	public String seConnecter(){
		String nav = "";
		membreConnected = proxyIdentification.identification(mail, mdp);
		if(membreConnected!= null){
			nav="/compte-TB.xhtml?faces-redirect=true";
		}
		return nav;
	}
	
	public String seDeconnecter(){
		HttpSession session =(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		String redirection = "/accueil.xhtml?faces-redirect=true";
		return redirection;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Membre getMembreConnected() {
		return membreConnected;
	}

	public void setMembreConnected(Membre membreConnected) {
		this.membreConnected = membreConnected;
	}
	
}
