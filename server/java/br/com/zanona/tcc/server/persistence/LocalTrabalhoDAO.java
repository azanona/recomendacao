package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.LocalTrabalho;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class LocalTrabalhoDAO extends JPACrud<LocalTrabalho, Integer> {

	private static final long serialVersionUID = -8375083182754116026L;

}
