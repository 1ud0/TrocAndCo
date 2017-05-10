package com.tac.controller.back;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.business.api.IServiceEtat;
import com.tac.business.api.IServiceTag;
import com.tac.business.api.IServiceValeur;
import com.tac.entity.Categorie;
import com.tac.entity.Etat;
import com.tac.entity.Tag;
import com.tac.entity.Valeur;


@ManagedBean(name="mbBackParam")
@SessionScoped
public class ParamManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceEtat proxyEtat;
	@EJB
	private IServiceTag proxyTag;
	@EJB
	private IServiceCategorie proxyCategorie;
	@EJB
	private IServiceValeur proxyValeur;


	
	public List<Etat> getAllEtat(){
		return proxyEtat.getAllEtat();
	}
	public List<Tag> getAllTag(){

		return proxyTag.getAllTag();
	}
	public List<Categorie> getAllCategoriesMere() {
		return proxyCategorie.getCategorieMere();
	}
	public List<Categorie> getAllCategoriesFilles() {

		return proxyCategorie.getAllCategorieFille();
	}
	public List<Valeur> getAllValeurs(){
		return proxyValeur.getAllValeur();
	}

}
