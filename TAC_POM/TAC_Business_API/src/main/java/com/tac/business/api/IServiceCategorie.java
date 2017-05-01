package com.tac.business.api;

import java.util.List;

import com.tac.entity.Categorie;

public interface IServiceCategorie {

	Categorie addCategorie(Categorie newCategorie);
	Categorie updateCategorie (Categorie categorie);
	void  deleteCategorie(Categorie categorieToDelete);
	List<Categorie> getCategorieMere();
	List<Categorie> getCategorieFille(Integer IdMere);
}
