package br.com.zanona.tcc.server.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.zanona.tcc.server.business.RecomendacaoBC;
import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;

@Path("/rbc")
public class RecomendacaoService {

	@Inject
	private RecomendacaoBC recomBC;

	@POST
	@Path("/buscar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(Perfil perfil) {
		List<Recomendacao> lstRecomendacao = null;
		try {
			lstRecomendacao = recomBC.executar(perfil, true);
		} catch (Exception e) {
		}
		
		return lstRecomendacao == null ? Response.serverError().build() : Response.ok(lstRecomendacao).build();
	}

}
