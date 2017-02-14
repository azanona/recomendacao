package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.Acompanhante;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AcompanhanteDAO extends JPACrud<Acompanhante , Integer> {

	private static final long serialVersionUID = 8996623772271751179L;

}
