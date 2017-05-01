package com.tac.data.api;

import java.util.List;

import com.tac.entity.Categorie;

public interface IDaoCategorie {

	Categorie addCategorie(Categorie newCategorie);
	Categorie updateCategorie (Categorie categorie);
	void  deleteCategorie(Categorie categorieToDelete);
	Categorie getById(Integer id);
	List<Categorie> getCategorieMere();
	List<Categorie> getCategorieFille(Integer IdMere);
}
