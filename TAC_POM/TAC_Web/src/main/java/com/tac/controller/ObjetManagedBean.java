package com.tac.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.tac.business.api.IServiceProposition;
import com.tac.entity.Proposition;

@ManagedBean(name="mbObjet")
@SessionScoped
public class ObjetManagedBean {

	@EJB
	private IServiceProposition proxyProp;
	
	private Proposition selectedProp;
	private Integer entryId;
	
	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true&id=" + selectedProp.getIdProposition();
		}
		return nav;
	}
	
	public void loadEntry() {
		System.out.println(entryId);
		//selectedProp = proxyProp
	}
	

	public IServiceProposition getProxyProp() {
		return proxyProp;
	}

	public void setProxyProp(IServiceProposition proxyProp) {
		this.proxyProp = proxyProp;
	}

	public Proposition getSelectedProp() {
		return selectedProp;
	}

	public void setSelectedProp(Proposition selectedProp) {
		this.selectedProp = selectedProp;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}
	
	
}
