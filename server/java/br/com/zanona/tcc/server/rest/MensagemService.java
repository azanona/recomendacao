package br.com.zanona.tcc.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/mensagem")
public class MensagemService {

	@GET
	@Path("/{param}")
	public Response exibirMessage(@PathParam("param") String msg) { 
		String result = "Restful com Demoiselle ! Mensagem: " + msg;
		return Response.status(200).entity(result).build();
 
	}
 
}
