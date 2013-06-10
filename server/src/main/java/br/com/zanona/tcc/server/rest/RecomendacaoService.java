package br.com.zanona.tcc.server.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	@Consumes("application/json;charset=UTF-8")
	@Produces("application/json;charset=UTF-8")
	public Response buscar(Perfil perfil) {
		try {
			return Response.ok(recomBC.executar(perfil)).build(); 
		
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/aprender")
	@Consumes("application/json;charset=UTF-8")
	public Response aprender(Recomendacao recomendacao) {
		recomBC.aprender(recomendacao);
		return recomendacao == null ? Response.serverError().build() : Response.ok().build();
	}

}
