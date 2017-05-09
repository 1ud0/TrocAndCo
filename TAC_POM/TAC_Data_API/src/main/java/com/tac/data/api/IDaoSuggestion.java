package com.tac.data.api;


import com.tac.entity.Suggestion;

public interface IDaoSuggestion {

	Suggestion addSuggestion(Suggestion suggestion);
	void deleteSuggestion(Suggestion suggestion);
	Suggestion updateSuggestion(Suggestion suggestion);
	Suggestion getSuggestionByIdMembre(int idMembre);
}
