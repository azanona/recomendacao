package br.com.zanona.recomendacao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zanona.recomendacao.business.RecomendacaoBC;
import br.com.zanona.recomendacao.domain.Perfil;
import br.com.zanona.recomendacao.domain.Recomendacao;

@RestController
public class RecomendacaoService {

	@Autowired
	private RecomendacaoBC recomBC;

	@RequestMapping(value = "/rbc/buscar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Recomendacao buscar(Perfil perfil) throws Exception {
		return recomBC.executar(perfil);
	}

	@RequestMapping(value = "/rbc/aprender", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public void aprender(Recomendacao recomendacao) {
		recomBC.aprender(recomendacao);
	}
}