package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.TransporteEvento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class TransporteEventoDAO extends JPACrud<TransporteEvento, Integer> {

	private static final long serialVersionUID = -3733645180287302162L;

}
