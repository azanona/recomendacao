package br.com.zanona.tcc.server.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.zanona.tcc.server.business.PerfilBC;
import br.com.zanona.tcc.server.domain.Acompanhante;
import br.com.zanona.tcc.server.domain.Escolaridade;
import br.com.zanona.tcc.server.domain.EstadoCivil;
import br.com.zanona.tcc.server.domain.GastoViagem;
import br.com.zanona.tcc.server.domain.Hospedagem;
import br.com.zanona.tcc.server.domain.LocalTrabalho;
import br.com.zanona.tcc.server.domain.MeioTransporte;
import br.com.zanona.tcc.server.domain.PeriodicidadeVisita;
import br.com.zanona.tcc.server.domain.TempoEstadia;
import br.com.zanona.tcc.server.domain.TransporteEvento;

@Path("/perfil")
public class PerfilService {
	
	@Inject
	private PerfilBC perfilBC;
	
	
	@GET
	@Path("/escolaridade/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Escolaridade> escolaridades() {
		return perfilBC.buscarEscolaridades();
	}

	@GET
	@Path("/local-trabalho/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<LocalTrabalho> locaisTrabalho() {
		return perfilBC.buscarLocaisTrabalho();
	}

	@GET
	@Path("/estado-civil/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstadoCivil> estadosCivis() {
		return perfilBC.buscarEstadosCivis();
	}

	@GET
	@Path("/gasto-viagem/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<GastoViagem> gastosViagem() {
		return perfilBC.buscarGastosViagem();
	}

	@GET
	@Path("/acompanhante/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Acompanhante> acompanhantes() {
		return perfilBC.buscarAcompanhantes();
	}
	
	@GET
	@Path("/hospedagem/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospedagem> hospedagens() {
		return perfilBC.buscarHospedagens();
	}

	@GET
	@Path("/transporte-evento/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransporteEvento> transportesEvento() {
		return perfilBC.buscarTransportesEvento();
	}

	@GET
	@Path("/meio-transporte/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<MeioTransporte> meiosTransporte() {
		return perfilBC.buscarMeiosTransporte();
	}

	@GET
	@Path("/periodicidade-visita/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<PeriodicidadeVisita> periodicidadesVisita() {
		return perfilBC.buscarPeriodicidadesVisita();
	}

	@GET
	@Path("/tempo-estadia/") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<TempoEstadia> temposEstadia() {
		return perfilBC.buscarTemposEstadia();
	}

}