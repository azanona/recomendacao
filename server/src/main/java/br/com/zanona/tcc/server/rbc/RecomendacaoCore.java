package br.com.zanona.tcc.server.rbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.exception.ExecutionException;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import jcolibri.method.retrieve.selection.SelectCases;
import jcolibri.method.reuse.CombineQueryAndCasesMethod;

import org.slf4j.Logger;

import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.com.zanona.tcc.server.domain.RoteiroTuristico;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

@BusinessController
public class RecomendacaoCore implements StandardCBRApplication {

	@Inject
	private Logger logger;

	@Inject
	private RecomendacaoCaseBase caseBase;

	/**
	 * As configurações são injetadas do contexto.
	 */
	@Override
	@Deprecated
	public void configure() throws ExecutionException {
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		logger.debug("carregando base de casos");
		caseBase.init();
		return caseBase;
	}

	private NNConfig getSimilarityConfig() {
		NNConfig simConfig = new NNConfig();
		// similaridade global
		simConfig.setDescriptionSimFunction(new Average()); 

		// similaridade local @ atributo simples
		simConfig.addMapping(new Attribute("coordenada", Perfil.class), new GeometrySimilarityFunction());
		simConfig.addMapping(new Attribute("sexo", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("idade", Perfil.class), new Interval(0.5));
		simConfig.addMapping(new Attribute("rendaMensal", Perfil.class), new Interval(0.5));
		
		// similaridade local @ atributo complexo (objeto simples)
		simConfig.addMapping(new Attribute("escolaridade", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("localTrabalho", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("estadoCivil", Perfil.class), new Equal());
	
		simConfig.addMapping(new Attribute("gastoViagem", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("acompanhante", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("hospedagem", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("transporteEvento", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("meioTransporte", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("periodicidadeVisita", Perfil.class), new Equal());
		simConfig.addMapping(new Attribute("tempoEstadia", Perfil.class), new Equal());
				
		// Equal 								@ sim(c.a,q.a)= if ( c.a = q.a ) then 1 else 0
		// Interval(interval) 					@ sim(c.a,q.a)=1-(|x-y|/interval)
		// Threshold(t)							@ sim(c.a,q.a)= if ( c.a - q.a < treshold ) then 1 else 0
		// InrecaLessIsBetter(maxValue, jump) 	@ sim(c.a,q.a)= if(c.a < q.a) then 1 else jump * (max(a) - c.a) / (max(a) - q.a)

		return simConfig;
	}

	@Deprecated
	public void cycle(CBRQuery query) throws ExecutionException {
		throw new ExecutionException(
				"método depreciado. use execCycle ou execCycleWithLearn");
	}

	public List<Recomendacao> execCycle(CBRQuery query)
			throws ExecutionException {
		logger.debug("iniciando execucao do ciclo de rbc :: sem aprendizado");

		NNConfig simConfig = getSimilarityConfig();

		logger.debug("executando vizinho mais proximo");
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(
				caseBase.getCases(), query, simConfig);

		logger.debug("selecionando os casos :: obtendo os 10 mais similares");
		eval = SelectCases.selectTopKRR(eval, 10);
		List<Recomendacao> lista = new ArrayList<Recomendacao>();
		for ( RetrievalResult rr : eval ) {
			CBRCase cbrCase = rr.get_case();
			lista.add(new Recomendacao( (Perfil) cbrCase.getDescription() , (RoteiroTuristico) cbrCase.getSolution() ));
		}
		return lista;
	}

	/**
	 * Executa o ciclo de RBC com as etapas de revisão e aprendizado
	 * 
	 * @param eval
	 * @return
	 */
	public CBRCase execCycleWithLearn(CBRQuery query) throws Exception {
		logger.debug("iniciando execucao do ciclo de rbc");
		NNConfig simConfig = getSimilarityConfig();

		logger.debug("executando vizinho mais proximo");
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(
				caseBase.getCases(), query, simConfig);

		logger.debug("selecionando os casos :: obtendo os 10 mais similares");
		Collection<CBRCase> selectedcases = SelectCases.selectTopK(eval, 10);

		logger.debug("reusando casos :: combinando solucoes e descricao do problema");
		Collection<CBRCase> newcases = CombineQueryAndCasesMethod.combine(
				query, selectedcases);

		logger.debug("revisando os casos :: obtendo melhor caso");
		CBRCase bestCase = newcases.iterator().next();

		logger.debug("armazendo melhor caso gerado na etapa de revisão");
		jcolibri.method.retain.StoreCasesMethod.storeCase(caseBase, bestCase);
		return bestCase;
	}

	@Override
	public void postCycle() throws ExecutionException {
		logger.debug("finalizando base de casos");
		this.caseBase.close();
	}

}
