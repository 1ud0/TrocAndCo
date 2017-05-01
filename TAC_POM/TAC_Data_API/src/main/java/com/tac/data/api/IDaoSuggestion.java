package com.tac.data.api;

import java.util.List;

import com.tac.entity.Suggestion;

public interface IDaoSuggestion {

	Suggestion addSuggestion(Suggestion suggestion);
	void deleteSuggestion(Suggestion suggestion);
	List<Suggestion> getSuggestionsByIdMembre(int idMembre);
}
