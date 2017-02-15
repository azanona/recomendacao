package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.TempoEstadia;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class TempoEstadiaDAO extends JPACrud<TempoEstadia, Integer> {

	private static final long serialVersionUID = 379445572407314144L;

}
