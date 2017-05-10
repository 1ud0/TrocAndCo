package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceMessage;
import com.tac.entity.Categorie;
import com.tac.entity.Membre;
import com.tac.entity.Message;


@ManagedBean(name="mbHeader")
@SessionScoped
public class HeaderManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceCategorie proxyCategorie;
	
	@EJB
	private IServiceMessage proxyMessage;
	
	
	public List<Categorie> recupererCategoriesMeres(){
		List<Categorie> categories = proxyCategorie.getCategorieMere();
		for(Categorie cat : categories) {
			cat.setSousCategories(proxyCategorie.getCategorieFille(cat.getIdCategorie()));
		}
		return categories;
	}
	
	//notifications
	
	public int nombreNouveauxMessages(Membre membre){
		List<Message> total = proxyMessage.messageNonLuQuandRecepteur(membre);
		int resultat = 0;
		for(Message message : total){
			if(message.isLu()==false){
				resultat = resultat+1;
			}
		}
		return resultat;
	}
	
	
}
