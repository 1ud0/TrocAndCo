package com.tac.data.api;

import java.util.List;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

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
	int getTotalEchangeAvecNote(Integer idMembre);
	int[] getToutesLesNotes(int idMembre);
	List<Echange> getByMembreDonneurFini(Integer idMembreDonneur);
	List<Echange> getByMembreChercheurFini(Integer idMembreChercheur);
	int getCreditEnMoins(Integer idMembre);
	int getCreditEnPlus(Integer idMembre);
	Proposition getbyEchange(Echange echange);
	Echange getEchangeByProp(Proposition proposition);
	List<Echange> getByMembreDonneurDateAcceptNull(Membre membre);
	List<Echange> getAll();
	List<Echange> getByMembreDonneurChercheurDateAcceptNull(Integer idMembre);
	long getNbEchangesFinis();
	List<Echange> getByMembreFini(Integer idMembre);
}
