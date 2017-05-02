package com.tac.controller.back;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tac.business.api.IServiceAuthentificationBackOffice;
import com.tac.entity.Membre;
import java.io.Serializable;

@SuppressWarnings("serial")
@ManagedBean(name = "mbAuthentification")
@SessionScoped
public class ConnectionManagedBean implements Serializable{
	@EJB
	private IServiceAuthentificationBackOffice proxyAuthentificationBackOffice;
	private String mail;
	private String mdp;
	private Membre adminConnected;

	public String seConnecter() {
		String nav = "";
		adminConnected = proxyAuthentificationBackOffice.authentification(mail, mdp);
		
		if (adminConnected != null) {
				nav = "index.xhtml?faces-redirect=true";
		}else {
			nav = "loginTandCo.xhtml?faces-redirect=true";
		}
		return nav;
	}

	public String seDeconnecter() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		String redirection = "loginTandC.xhtml?faces-redirect=true";
		return redirection;
	}

	

	public Membre getAdminConnected() {
		return adminConnected;
	}

	public void setAdminConnected(Membre adminConnected) {
		this.adminConnected = adminConnected;
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

}
