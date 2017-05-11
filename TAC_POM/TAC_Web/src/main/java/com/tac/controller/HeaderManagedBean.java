package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
import com.tac.util.CritereSearch;

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
	private List<Categorie> categories;
	private Integer idCategorieSelected;

	@ManagedProperty(value = "#{mbRecherche}")
	private RechercheManagedBean rechercheBean;
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	@PostConstruct
	public void init() {
		categories = proxyCategorie.getCategorieMere();
	}

	public void listenerCatChange() {
		for (Categorie cat : categories) {
			if (cat.getIdCategorie() == idCategorieSelected) {
				CritereSearch crits = rechercheBean.getCritere();
				crits.setCat(cat);
				break;
			}
		}
	}
	
	public RechercheManagedBean getRechercheBean() {
		return rechercheBean;
	}

	public void setRechercheBean(RechercheManagedBean rechercheBean) {
		this.rechercheBean = rechercheBean;
	}

	public String clickCategorieMere(Categorie categorie) {
		CritereSearch critereSearch = new CritereSearch();
		critereSearch.setCat(categorie);
		rechercheBean.setCritere(critereSearch);
		return rechercheBean.seekAndNotDestroy();
	}

	public String clickSousCat(Categorie categorie) {
		CritereSearch critereSearch = new CritereSearch();
		critereSearch.setSousCat(categorie);
		rechercheBean.setCritere(critereSearch);
		return rechercheBean.seekAndNotDestroy();
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

	public Membre getMembreSelected() {
		return membreSelected;
	}

	public void setMembreSelected(Membre membreSelected) {
		this.membreSelected = membreSelected;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Integer getIdCategorieSelected() {
		return idCategorieSelected;
	}

	public void setIdCategorieSelected(Integer idCategorieSelected) {
		this.idCategorieSelected = idCategorieSelected;
	}

}
