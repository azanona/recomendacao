package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.Recomendacao;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class RecomendacaoDAO extends JPACrud<Recomendacao, Integer> {

	private static final long serialVersionUID = -7227336918551077446L;

	
}
