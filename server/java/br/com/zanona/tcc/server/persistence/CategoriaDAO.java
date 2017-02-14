package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.Categoria;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class CategoriaDAO extends JPACrud<Categoria , Integer>{

	private static final long serialVersionUID = -2190359440357013694L;

}
