package com.tac.data.api;

import java.util.List;

import com.tac.entity.Etat;

public interface IDaoEtat {

	Etat addEtat(Etat etat);
	Etat updateEtat(Etat etat);
	void deleteEtat(Etat etat);
	Etat getById(int idEtat);
	List<Etat> getAllEtat();
}
