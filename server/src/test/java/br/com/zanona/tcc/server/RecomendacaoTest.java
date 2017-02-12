package br.com.zanona.tcc.server;

import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.zanona.tcc.server.business.RecomendacaoBC;
import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;

//@RunWith(DemoiselleRunner.class)
public class RecomendacaoTest {
 
	@Autowired
	private RecomendacaoBC recomBC;

	@Autowired
	private Logger log;
	
	@Test
	public void recomendarRoteiroSemCompromisso() throws Exception {
		Perfil perfil = new Perfil(); //perfilBC.load(10);
		Recomendacao recomendacao = recomBC.executar(perfil);
		log.info(recomendacao.toString());
	}

}
