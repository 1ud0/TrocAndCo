package com.tac.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceProposition;
import com.tac.entity.Proposition;

@ManagedBean(name="mbObjet")
@SessionScoped
public class ObjetManagedBean {

	@EJB
	private IServiceProposition proxyProp;
	
	private Proposition selectedProp;
	
	public String loadProposition(Proposition proposition) {
		String nav = "";
		selectedProp = proposition;
		if (selectedProp != null) {
			nav = "/fiche.xhtml?faces-redirect=true";
		}
		return nav;
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
	
	
}
