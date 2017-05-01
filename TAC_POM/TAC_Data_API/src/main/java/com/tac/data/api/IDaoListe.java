package com.tac.data.api;

import java.util.List;
import com.tac.entity.Liste;

public interface IDaoListe {
Liste addListe(Liste liste);
Liste updateListe(Liste newListe);
boolean deleteListe(Integer id);
Liste getById(Integer id);
List<Liste> getByMembreId(Integer idMembre);
}
