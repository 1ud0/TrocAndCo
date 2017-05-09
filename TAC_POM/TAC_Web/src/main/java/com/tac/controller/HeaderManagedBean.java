package com.tac.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tac.business.api.IServiceCategorie;
import com.tac.entity.Categorie;


@ManagedBean(name="mbHeader")
@SessionScoped
public class HeaderManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private IServiceCategorie proxyCategorie;
	
	
	public List<Categorie> recupererCategoriesMeres(){
		List<Categorie> categories = proxyCategorie.getCategorieMere();
		for(Categorie cat : categories) {
			cat.setSousCategories(proxyCategorie.getCategorieFille(cat.getIdCategorie()));
		}
		return categories;
	}
	
	
}
