package com.tac.controller.back;


import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tac.business.api.IServiceAuthentificationBackOffice;
import com.tac.entity.Membre;

@ManagedBean(name="mbCnx")
@SessionScoped
public class ConnectionManagedBean {
	@EJB
private IServiceAuthentificationBackOffice proxyAuthentificationBackOffice;
	private String mail;
	private String mdp;
	private Membre userConnected;
	public String seConnecter() {
		userConnected = proxyAuthentificationBackOffice.authentification(mail, mdp);
		String nav = "";
		if(userConnected != null) {
			if(isAdmin()) {
				nav = "/index.xhtml?faces-redirect=true";
			} else {
				nav = "/loginTandC.xhtml?faces-redirect=true";
			}
		}
		return nav;
	}
	public String seDeconnecter() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();
		return "/loginTandC.xhtml?faces-redirect=true";
	}
	public boolean isAdmin() {
		boolean retour = false;
		if(userConnected.getMail() == "admin@trocandco.com") {
			retour = true;
		}
		return retour;
	}
	public void securePage() {
		if(userConnected == null) {
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			nav.performNavigation("/indecTandC.xhtml?faces-redirect=true");
		}
	}
	public Membre getUserConnected() {
		return userConnected;
	}
	public void setUserConnected(Membre userConnected) {
		this.userConnected = userConnected;
	}
	public IServiceAuthentificationBackOffice getProxyIdent() {
		return proxyAuthentificationBackOffice;
	}
	public void setProxyproxyIdentification(IServiceAuthentificationBackOffice proxyIdent) {
		this.proxyAuthentificationBackOffice = proxyIdent;
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
