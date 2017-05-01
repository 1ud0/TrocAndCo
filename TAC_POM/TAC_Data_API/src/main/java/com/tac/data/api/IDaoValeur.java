package com.tac.data.api;

import com.tac.entity.Valeur;

public interface IDaoValeur {

	Valeur addValeur(Valeur valeur);
	Valeur updateValeur(Valeur valeur);
	void deleteValeur(Valeur valeur);
	Valeur getById(int idValeur);
}
