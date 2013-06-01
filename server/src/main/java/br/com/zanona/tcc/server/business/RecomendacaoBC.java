package br.com.zanona.tcc.server.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.method.retrieve.RetrievalResult;

import org.slf4j.Logger;

import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.com.zanona.tcc.server.persistence.RecomendacaoDAO;
import br.com.zanona.tcc.server.rbc.RecomendacaoCore;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class RecomendacaoBC extends DelegateCrud<Recomendacao, Integer, RecomendacaoDAO> {

	private static final long serialVersionUID = 3965362815931539387L;

	@Inject
	private Logger logger;

	@Inject
	private RecomendacaoCore cbrCore;

	
	/**
	 * Este método executa o ciclo de RBC para efetuar a sugestão dos atrativos turísticos 
	 * @param perfil
	 * @param usarAdaptacao
	 * @return
	 * @throws RuntimeException
	 */
	public List<Recomendacao> executar(Perfil perfil , boolean usarAdaptacao) throws Exception {
		logger.debug("iniciando processo de recomendacao");
		List<Recomendacao> lstRecomendacao = new ArrayList<Recomendacao>();

		try {
			
			// carregando base de casos
			cbrCore.preCycle();

			// configurando a consulta
			CBRQuery query = new CBRQuery();
			query.setDescription(perfil);
			
			lstRecomendacao.addAll(cbrCore.execCycle(query) );
			
			// finalizando ciclo
			cbrCore.postCycle();

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		logger.debug("finalizado processo de recomendacao");

		return lstRecomendacao;
	}

}
