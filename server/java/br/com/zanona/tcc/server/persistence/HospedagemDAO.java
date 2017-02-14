package br.com.zanona.tcc.server.persistence;

import br.com.zanona.tcc.server.domain.Hospedagem;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class HospedagemDAO extends JPACrud<Hospedagem, Integer> {

	private static final long serialVersionUID = -8995975607017421407L;

}
