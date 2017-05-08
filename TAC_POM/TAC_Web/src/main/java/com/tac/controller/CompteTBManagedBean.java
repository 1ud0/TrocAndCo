package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceLocalisation;
import com.tac.entity.Echange;
import com.tac.entity.Membre;





@ManagedBean(name="mbCompteTB")
@RequestScoped
public class CompteTBManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceLocalisation proxyLocalisation;
	
	@ManagedProperty(value="#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	@ManagedProperty(value="#{mbMessage}")
	private MessageManagedBean messageBean;
	
	@ManagedProperty(value="#{mbCompteEchange}")
	private CompteMesEchangesManagedBean compteEchangeBean;
	



	private Membre membreCourant;
	
	public Membre getMembreCourant() {
		membreCourant = identifBean.getMembreConnected();
		membreCourant.setLocalisations(proxyLocalisation.getMembreLocalisations(membreCourant));
		List<Echange> echanges = proxyEchange.getByMembre(membreCourant);
		membreCourant.setEchanges(echanges);
		return membreCourant;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public MessageManagedBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageManagedBean messageBean) {
		this.messageBean = messageBean;
	}

	public CompteMesEchangesManagedBean getCompteEchangeBean() {
		return compteEchangeBean;
	}

	public void setCompteEchangeBean(CompteMesEchangesManagedBean compteEchangeBean) {
		this.compteEchangeBean = compteEchangeBean;
	}


	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public IServiceLocalisation getProxyLocalisation() {
		return proxyLocalisation;
	}

	public void setProxyLocalisation(IServiceLocalisation proxyLocalisation) {
		this.proxyLocalisation = proxyLocalisation;
	}

	public List<Echange> getEchangesQuandDonneur(Membre membre) {
		return proxyEchange.getByMembreDonneurFini(membre);
	}

	public List<Echange> getEchangesQuandAcheteur(Membre membre) {
		return proxyEchange.getByMembreChercheurFini(membre);
	}




	


}
