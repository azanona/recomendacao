package br.com.zanona.tcc.server.rbc;

import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.com.zanona.tcc.server.domain.RoteiroTuristico;
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

@Controller
public class RecomendacaoCore implements StandardCBRApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RecomendacaoCaseBase caseBase;

	/**
	 * As configurações são injetadas do contexto.
	 */
	@Override
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
		Attribute attrCoordenada = new Attribute("coordenada", Perfil.class);
		simConfig.addMapping(attrCoordenada, new GeometrySimilarityFunction());
		simConfig.setWeight(attrCoordenada, 10d);

		Attribute attrSexo = new Attribute("sexo", Perfil.class);
		simConfig.addMapping(attrSexo, new Equal());
		simConfig.setWeight(attrSexo, 0.1d);

		Attribute attrIdade = new Attribute("idade", Perfil.class);
		simConfig.addMapping(attrIdade, new Interval(100));
		simConfig.setWeight(attrSexo, 0.1d);

		Attribute attrRenda = new Attribute("rendaMensal", Perfil.class);
		simConfig.addMapping(attrRenda, new Interval(100000));
		simConfig.setWeight(attrRenda, 0.1d);

		// similaridade local @ atributo complexo (objeto simples)
		Attribute attrEscolaridade = new Attribute("escolaridade", Perfil.class);
		simConfig.addMapping(attrEscolaridade, new Equal());
		simConfig.setWeight(attrSexo, 0.1d);

		Attribute attrLocalTrabalho = new Attribute("localTrabalho", Perfil.class);
		simConfig.addMapping(attrLocalTrabalho, new Equal());
		simConfig.setWeight(attrLocalTrabalho, 0.1d);

		Attribute attrEstadoCivil = new Attribute("estadoCivil", Perfil.class);
		simConfig.addMapping(attrEstadoCivil, new Equal());
		simConfig.setWeight(attrEstadoCivil, 0.1d);

		Attribute attrGastoViagem = new Attribute("gastoViagem", Perfil.class);
		simConfig.addMapping(attrGastoViagem, new Equal());
		simConfig.setWeight(attrGastoViagem, 0.1d);

		Attribute attrAcompanhante = new Attribute("acompanhante", Perfil.class);
		simConfig.addMapping(attrAcompanhante, new Equal());
		simConfig.setWeight(attrAcompanhante, 0.1d);

		Attribute attrHospedagem = new Attribute("hospedagem", Perfil.class);
		simConfig.addMapping(attrHospedagem, new Equal());
		simConfig.setWeight(attrHospedagem, 0.1d);

		Attribute attrTransporte = new Attribute("transporteEvento", Perfil.class);
		simConfig.addMapping(attrTransporte, new Equal());
		simConfig.setWeight(attrTransporte, 0.1d);

		Attribute attrMeioTransporte = new Attribute("meioTransporte", Perfil.class);
		simConfig.addMapping(attrMeioTransporte, new Equal());
		simConfig.setWeight(attrMeioTransporte, 0.1d);

		Attribute attrPeriodicidade = new Attribute("periodicidadeVisita", Perfil.class);
		simConfig.addMapping(attrPeriodicidade, new Equal());
		simConfig.setWeight(attrPeriodicidade, 0.1d);

		Attribute attrTempoEstadia = new Attribute("tempoEstadia", Perfil.class);
		simConfig.addMapping(attrTempoEstadia, new Equal());
		simConfig.setWeight(attrTempoEstadia, 0.1d);

		// Equal @ sim(c.a,q.a)= if ( c.a = q.a ) then 1 else 0
		// Interval(interval) @ sim(c.a,q.a)=1-(|x-y|/interval)
		// Threshold(t) @ sim(c.a,q.a)= if ( c.a - q.a < treshold ) then 1 else
		// 0
		// InrecaLessIsBetter(maxValue, jump) @ sim(c.a,q.a)= if(c.a < q.a) then
		// 1 else jump * (max(a) - c.a) / (max(a) - q.a)

		return simConfig;
	}

	@Deprecated
	public void cycle(CBRQuery query) throws ExecutionException {
		throw new ExecutionException("método depreciado. use execCycle ou execCycleWithLearn");
	}

	public Recomendacao execCycle(Perfil perfil) throws ExecutionException {
		logger.debug("iniciando execucao do ciclo de rbc :: sem aprendizado");

		NNConfig simConfig = getSimilarityConfig();

		CBRQuery query = new CBRQuery();
		query.setDescription(perfil);

		logger.debug("executando vizinho mais proximo");
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);

		logger.debug("selecionando os casos :: obtendo os 10 mais similares");
		eval = SelectCases.selectTopKRR(eval, 10);

		CBRCase cbrCase = eval.iterator().next().get_case();

		return new Recomendacao((Perfil) cbrCase.getDescription(), (RoteiroTuristico) cbrCase.getSolution());
	}

	/**
	 * Executa o ciclo de RBC com as etapas de revisão e aprendizado
	 * 
	 * @param eval
	 * @return
	 */
	public Recomendacao execCycleWithLearn(CBRQuery query) throws Exception {
		logger.debug("iniciando execucao do ciclo de rbc");
		NNConfig simConfig = getSimilarityConfig();

		logger.debug("executando vizinho mais proximo");
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);

		logger.debug("selecionando os casos :: obtendo os 10 mais similares");
		Collection<CBRCase> selectedcases = SelectCases.selectTopK(eval, 10);

		logger.debug("reusando casos :: combinando solucoes e descricao do problema");
		Collection<CBRCase> newcases = CombineQueryAndCasesMethod.combine(query, selectedcases);

		logger.debug("revisando os casos :: obtendo melhor caso");
		CBRCase bestCase = newcases.iterator().next();

		logger.debug("armazendo melhor caso gerado na etapa de revisão");
		jcolibri.method.retain.StoreCasesMethod.storeCase(caseBase, bestCase);
		return new Recomendacao((Perfil) bestCase.getDescription(), (RoteiroTuristico) bestCase.getSolution());
	}

	public void learn(Recomendacao recomendacao) {
		caseBase.learnCases(Arrays.asList(new CBRCase(recomendacao.getDescricao(), recomendacao.getSolucao())));
	}

	@Override
	public void postCycle() throws ExecutionException {
		logger.debug("finalizando base de casos");
		this.caseBase.close();
	}

}
