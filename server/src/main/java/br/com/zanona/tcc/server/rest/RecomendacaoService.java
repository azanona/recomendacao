package br.com.zanona.tcc.server.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.zanona.tcc.server.business.RecomendacaoBC;
import br.com.zanona.tcc.server.domain.Recomendacao;

@Path("/base/recomendacao")
public class RecomendacaoService {
	
	@Inject
	private RecomendacaoBC recomendacaoBC;
	
	@GET
	@Path("/buscar/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recomendacao> buscar (){ 
		return recomendacaoBC.findAll(); 
	}
	
	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Recomendacao buscar ( @PathParam("id") Integer id ){ 
		return recomendacaoBC.load(id);
	}

}