package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.GastoViagem;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class GastoViagemDAO extends JPACrud<GastoViagem, Integer> {

	private static final long serialVersionUID = 6238828142708315372L;

}
