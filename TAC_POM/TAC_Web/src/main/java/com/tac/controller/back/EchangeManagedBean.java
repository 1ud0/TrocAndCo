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
