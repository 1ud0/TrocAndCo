package com.tac.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceEchange;
import com.tac.business.api.IServiceRdv;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Rdv;

@ManagedBean(name="mbRdv")
@ViewScoped
public class RdvManagedBean {

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceRdv proxyRdv;
	
	private Rdv rdv= new Rdv();
	private List<Echange> echanges;
	private Echange echangeSelected = new Echange();


	@PostConstruct
	public void loadData(){
		if (identifBean.getMembreConnected() != null) {
			echanges = proxyEchange.getByMembreDonneur(identifBean.getMembreConnected().getIdMembre());
			echanges.addAll(proxyEchange.getByMembreChercheur(identifBean.getMembreConnected().getIdMembre()));
		}
	}
	
	public List<Echange> getEchanges() {
		return echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}


	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public void addRdv(){
		echangeSelected = proxyEchange.getByNumero(echangeSelected);
		rdv.setEchange(echangeSelected);
		if(rdv.getDateRdv() != null){
		proxyRdv.addRdv(rdv);
		}
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

		return proxyRdv.getRdvByMembre(identifBean.getMembreConnected().getIdMembre());
	}

	public IServiceEchange getProxyEchange() {
		return proxyEchange;
	}

	public void setProxyEchange(IServiceEchange proxyEchange) {
		this.proxyEchange = proxyEchange;
	}

	public Echange getEchangeSelected() {
		return echangeSelected;
	}

	public void setEchangeSelected(Echange echangeSelected) {
		this.echangeSelected = echangeSelected;
	}

	
	
}
