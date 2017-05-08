package com.tac.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.tac.business.api.IServiceRdv;
import com.tac.entity.Rdv;

@ManagedBean(name="mbRdv")
public class RdvManagedBean {

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	@EJB
	IServiceRdv proxyRdv;
	
	public Rdv addRdv(Rdv rdv){
		rdv = proxyRdv.addRdv(rdv);
		return rdv;	
	}
	
	public void deleteRdv(Rdv rdv){
		proxyRdv.deleteRdv(rdv);
	}
	
	public Rdv updateRdv(Rdv rdv){
		rdv = proxyRdv.updateRdv(rdv);
		return rdv;
	}
	
	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public IServiceRdv getProxyRdv() {
		return proxyRdv;
	}

	public void setProxyRdv(IServiceRdv proxyRdv) {
		this.proxyRdv = proxyRdv;
	}

	public List<Rdv> getAllRdvByMembre(){
		System.out.println(identifBean.getMembreConnected().getNom());
		return proxyRdv.getRdvByMembre(identifBean.getMembreConnected().getIdMembre());
	}
	
}
