package com.tac.business.api;

import java.util.List;
import com.tac.entity.Liste;
import com.tac.entity.Membre;

public interface IServiceListe {
Liste addListe(Liste liste);
Liste updateListe (Liste newListe);
void deleteListe(Liste liste);
List<Liste> getByMembre(Membre membre);
}
