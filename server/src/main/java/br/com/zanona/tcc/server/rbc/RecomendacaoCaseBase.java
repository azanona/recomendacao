package br.com.zanona.tcc.server.rbc;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import jcolibri.casebase.CachedLinealCaseBase;
import jcolibri.cbrcore.CBRCase;
import jcolibri.exception.InitializingException;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

@PersistenceController
public class RecomendacaoCaseBase extends CachedLinealCaseBase implements Serializable {
	
	private static final long serialVersionUID = 8806540865369424000L;

	@Inject
	private Logger logger;

	@Inject
	private RecomendacaoConnector connector;
		
	/**
	 * Inicia a base de casos usando o conector do contexto.
	 * @throws InitializingException
	 */
	public void init() throws InitializingException {
		super.init(this.connector);
	}
	
	/**
	 * Armazena o caso sem necessidade de efetuar um init() 
	 * @param cases
	 */
	public void storeCases(Collection<CBRCase> cases) {
		connector.storeCases(cases);
	}
}
