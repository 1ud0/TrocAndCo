package com.tac.data.api;

import java.util.List;

import com.tac.entity.Echange;

public interface IDaoEchange {

	Echange addEchange(Echange newChange);

	Echange updateEchange(Echange Change);

	void deleteEchange(Echange changeToDelete);

	Echange getByNumero(Integer numero);

	List<Echange> getByMembre(Integer idMembre);

	List<Echange> getByMembreDonneur(Integer idMembreDonneur);

	List<Echange> getByMembreChercheur(Integer idMembreChercheur);

	Double getNoteMoyenneMembre(Integer idMembre);

	List<Echange> getAllEchangeFini();
}
