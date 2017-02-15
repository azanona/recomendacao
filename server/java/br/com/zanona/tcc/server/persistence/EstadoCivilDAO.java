package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.EstadoCivil;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EstadoCivilDAO extends JPACrud<EstadoCivil, Integer> {

	private static final long serialVersionUID = -7310011265249904729L;

}
