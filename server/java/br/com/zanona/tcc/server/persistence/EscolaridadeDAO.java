package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.Escolaridade;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EscolaridadeDAO extends JPACrud<Escolaridade, Integer> {

	private static final long serialVersionUID = 985842727805142526L;

}
