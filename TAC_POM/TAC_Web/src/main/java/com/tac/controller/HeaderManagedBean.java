package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceMessage;
import com.tac.entity.Categorie;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Message;

@ManagedBean(name = "mbHeader")
@SessionScoped
public class HeaderManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceCategorie proxyCategorie;

	@EJB
	private IServiceMessage proxyMessage;

	@EJB
	private IServiceEchange proxyEchange;

	private Membre membreSelected;

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	public List<Categorie> recupererCategoriesMeres() {
		List<Categorie> categories = proxyCategorie.getCategorieMere();
		for (Categorie cat : categories) {
			cat.setSousCategories(proxyCategorie.getCategorieFille(cat.getIdCategorie()));
		}
		return categories;
	}

	// notifications

	public int nombreNvxEchanges() {
		membreSelected = identifBean.getMembreConnected();
		if (membreSelected != null) {
			List<Echange> echanges = proxyEchange.getByMembreDonneurDateAcceptNull(membreSelected.getIdMembre());
			return echanges.size();
		}
		return 0;
	}

	public int nombreNouveauxMessages() {
		membreSelected = identifBean.getMembreConnected();
		if (membreSelected != null) {
		return proxyMessage.messageNonLuQuandRecepteur(membreSelected).size();
		}
		return 0;
	}

	public IServiceCategorie getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(IServiceCategorie proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
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

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

}
