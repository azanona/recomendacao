package br.com.zanona.tcc.server;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.com.zanona.tcc.server.business.PerfilBC;
import br.com.zanona.tcc.server.business.RecomendacaoBC;
import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class RecomendacaoTest {
 
	@Inject
	private RecomendacaoBC recomBC;

	@Inject
	private PerfilBC perfilBC;
	
	@Inject
	private Logger log;
	
	@Test
	public void recomendarRoteiroSemCompromisso() throws Exception {
		Perfil perfil = new Perfil(); //perfilBC.load(10);
		Recomendacao recomendacao = recomBC.executar(perfil, false);
		log.info(recomendacao.toString());
	}

}
