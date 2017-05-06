package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceMessage;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

@ManagedBean(name = "mbMessage")
@SessionScoped
public class MessageManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@EJB
	private IServiceMessage proxyMessage;
	
	@EJB
	private IServiceProposition proxyProposition;
	
	
	
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	private Membre membreCourant;
	
	public List<Proposition> getAllDiscussions(){
		membreCourant = identifBean.getMembreConnected();
		List<Message> tout = proxyMessage.getByMembre(membreCourant);
		List<Proposition> resultat = new ArrayList<Proposition>();
		for(Message message : tout){
			if(!resultat.contains(message.getProposition())){
				resultat.add(message.getProposition());
				
			}
		}
		return resultat;
	}
	
	public List<Proposition> getAllDiscussionsLues(){
		membreCourant = identifBean.getMembreConnected();
		List<Message> tout = proxyMessage.getByMembre(membreCourant);
		List<Proposition> resultat = new ArrayList<Proposition>();
		
		for(Message message : tout){
			if(!resultat.contains(message.getProposition()) && message.isLu()==true){
				resultat.add(message.getProposition());
			}
		}
		return resultat;
	}
	
	public List<Proposition> getAllDiscussionsNonLues(){
		membreCourant = identifBean.getMembreConnected();
		List<Message> tout = proxyMessage.getByMembre(membreCourant);
		List<Proposition> resultat = new ArrayList<Proposition>();
		for(Message message : tout){
			if(!getAllDiscussionsLues().contains(message.getProposition()) && !resultat.contains(message.getProposition())){
				resultat.add(message.getProposition());
			}
		}
		
		return resultat;
	}
	

	public IServiceMessage getProxyMessage() {
		return proxyMessage;
	}

	public void setProxyMessage(IServiceMessage proxyMessage) {
		this.proxyMessage = proxyMessage;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}
	
	

}
