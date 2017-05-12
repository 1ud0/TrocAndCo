package com.tac.controller;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceIdentification;
import com.tac.business.api.IServiceMessage;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@ManagedBean(name = "mbIdentif")
@SessionScoped
public class IdentificationManagedBean implements Serializable {

	@EJB
	private IServiceIdentification proxyIdentification;
	@EJB
	private IServiceMessage proxyMessage;
	@EJB
	private IServiceEchange proxyEchange;

	private String mail = "bob.toto@toto.com";
	private String mdp = "pass";
	private Membre membreConnected;
	private int nbNouveauxMessages;
	private int nbNouveauxEchanges;
	private int credit;

	public void securePage() {
		if (membreConnected == null) {
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance()
					.getApplication().getNavigationHandler();
			nav.performNavigation("/inscription.xhtml?faces-redirect=true");
		}
	}

	public String seConnecter() {
		String nav = "";
		membreConnected = proxyIdentification.identification(mail, mdp);
		if (membreConnected != null) {
			nav = "/compte-TB.xhtml?faces-redirect=true";
		}
		return nav;
	}


	

	public String seDeconnecter() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		String redirection = "/accueil.xhtml?faces-redirect=true";
		return redirection;
	}
	
	public int getNbNouveauxEchanges() {
		List<Echange> echanges = proxyEchange.getByMembreDonneurDateAcceptNull(membreConnected.getIdMembre());
		return echanges.size();
	}
	
	public int getNbNouveauxMessages() {
		return proxyMessage.messageNonLuQuandRecepteur(membreConnected).size();
	}

	public int getCredit() {
		return proxyEchange.totalCredit(membreConnected);
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	public IServiceIdentification getProxyIdentification() {
		return proxyIdentification;
	}

	public void setProxyIdentification(IServiceIdentification proxyIdentification) {
		this.proxyIdentification = proxyIdentification;
	}

	public IServiceMessage getProxyMessage() {
		return proxyMessage;
	}

	public void setProxyMessage(IServiceMessage proxyMessage) {
		this.proxyMessage = proxyMessage;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	

	public void setNbNouveauxMessages(int nbNouveauxMessages) {
		this.nbNouveauxMessages = nbNouveauxMessages;
	}

	

	public void setNbNouveauxEchanges(int nbNouveauxEchanges) {
		this.nbNouveauxEchanges = nbNouveauxEchanges;
	}

}
