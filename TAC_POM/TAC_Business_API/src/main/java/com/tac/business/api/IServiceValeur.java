package com.tac.business.api;

import java.util.List;

import com.tac.entity.Valeur;

public interface IServiceValeur {
	Valeur addValeur(Valeur valeur);
	Valeur updateValeur(Valeur valeur);
	void deleteValeur(Valeur valeur);
	Valeur getById(int idValeur);
	List<Valeur> getAllValeur();
}
