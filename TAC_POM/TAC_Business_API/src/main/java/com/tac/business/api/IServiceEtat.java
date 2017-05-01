package com.tac.business.api;

import com.tac.entity.Etat;

public interface IServiceEtat {
	Etat addEtat(Etat etat);
	Etat updateEtat(Etat etat);
	void deleteEtat(Etat etat);
	Etat getById(int idEtat);
}
