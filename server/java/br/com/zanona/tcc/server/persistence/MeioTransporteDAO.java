package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.MeioTransporte;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class MeioTransporteDAO extends JPACrud<MeioTransporte, Integer> {

	private static final long serialVersionUID = -7076185348872718080L;

}
