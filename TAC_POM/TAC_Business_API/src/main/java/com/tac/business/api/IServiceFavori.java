package com.tac.business.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Proposition;

public interface IServiceFavori {
	Proposition addToFavoris (Proposition proposition, Membre membre);
	void deleteFavori(Proposition proposition , Membre membre );
	List<Proposition> getFavorisMembre (Membre membre);
	Proposition getFavoriById(int idProposition);
	void deleteAllFavori(Proposition proposition);
	boolean isFavorite(Proposition proposition, Membre membre);

}
