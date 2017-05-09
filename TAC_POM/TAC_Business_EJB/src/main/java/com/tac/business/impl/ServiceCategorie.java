package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceCategorie;
import com.tac.data.api.IDaoCategorie;
import com.tac.entity.Categorie;

@Remote(IServiceCategorie.class)
@Stateless
public class ServiceCategorie implements IServiceCategorie{
	
	@EJB
	private IDaoCategorie proxyDaoCategorie;
	
	@Override
	public Categorie addCategorie(Categorie newCategorie) {
		
		return proxyDaoCategorie.addCategorie(newCategorie);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return proxyDaoCategorie.updateCategorie(categorie);
	}

	@Override
	public void deleteCategorie(Categorie categorieToDelete) {
		proxyDaoCategorie.deleteCategorie(categorieToDelete);
		
	}

	@Override
	public List<Categorie> getCategorieMere() {
		
		return proxyDaoCategorie.getCategorieMere();
	}

	@Override
	public List<Categorie> getCategorieFille(Integer IdMere) {
		
		return proxyDaoCategorie.getCategorieFille(IdMere);
	}

	@Override
	public Categorie getById(Integer idCategorie) {
		return proxyDaoCategorie.getById(idCategorie);
	}

}
