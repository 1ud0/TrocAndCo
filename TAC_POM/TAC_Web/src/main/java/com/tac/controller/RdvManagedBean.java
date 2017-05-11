package com.tac.controller;

import java.util.Calendar;
import java.util.Date;
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

@ManagedBean(name = "mbRdv")
@ViewScoped
public class RdvManagedBean {

	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;

	@EJB
	private IServiceEchange proxyEchange;
	@EJB
	private IServiceRdv proxyRdv;

	private Rdv rdv = new Rdv();
	private List<Echange> echanges;
	private List<Rdv> list;
	private Echange echangeSelected = new Echange();
	private Membre membreSelected;
	private int heure;
	private int minute;
	private Date date;

	@PostConstruct
	public void loadData() {
		membreSelected = identifBean.getMembreConnected();
		if (membreSelected != null) {
			echanges = proxyEchange.getByMembreDonneurChercheurDateAcceptNull(membreSelected.getIdMembre());
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

	public void addRdv() {
		if (date != null && echangeSelected.getIdEchange()!= 0) {
		echangeSelected = proxyEchange.getByNumero(echangeSelected);
		
			rdv.setEchange(echangeSelected);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(calendar.HOUR_OF_DAY, heure);
			calendar.set(calendar.MINUTE, minute);
			date = calendar.getTime();

			rdv.setDateRdv(date);
			
				proxyRdv.addRdv(rdv);
			
		}
	}

	public List<Rdv> getList() {
		return list;
	}

	public void setList(List<Rdv> list) {
		this.list = list;
	}

	public Membre getMembreSelected() {
		return membreSelected;
	}

	public void setMembreSelected(Membre membreSelected) {
		this.membreSelected = membreSelected;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void deleteRdv(Rdv rdv) {
		proxyRdv.deleteRdv(rdv);
	}

	public Rdv updateRdv(Rdv rdv) {
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

	public List<Rdv> getAllRdvByMembre() {
		if (membreSelected != null) {
			list = proxyRdv.getRdvByMembre(membreSelected.getIdMembre());
			list.addAll(proxyRdv.getRdvByMembrePropositionEchange(membreSelected.getIdMembre()));
		}
		return list;
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
