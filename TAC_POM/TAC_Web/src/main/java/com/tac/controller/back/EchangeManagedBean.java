package com.tac.controller.back;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.back.IServiceEchangeBO;
import com.tac.entity.Echange;

@ManagedBean(name="mbBackEchange")
@SessionScoped
public class EchangeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@EJB
	private IServiceEchangeBO proxyEchange;
	
	private String status = "";

	
	public String statusEchange(Echange echange) {
		if (echange.getDateAnnul() != null) {
			status = "annule";
		} else if (echange.getDateRefus() != null) {
			status = "refus";
		} else if (echange.getDateValidation() != null) {
			status = "effectue";
		} else {
			status = "en cours";
		}
		return status;
	}
	
	public List<Echange> getAll(){
		return proxyEchange.getAll();
		
	}

	public IServiceEchangeBO getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchangeBO proxyEchange) {
		this.proxyEchange = proxyEchange;
	}
	
	
}
