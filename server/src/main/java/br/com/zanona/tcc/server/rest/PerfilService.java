package br.com.zanona.tcc.server.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.zanona.tcc.server.business.PerfilBC;
import br.com.zanona.tcc.server.domain.Acompanhante;
import br.com.zanona.tcc.server.domain.BaseDomain;
import br.com.zanona.tcc.server.domain.Escolaridade;
import br.com.zanona.tcc.server.domain.EstadoCivil;
import br.com.zanona.tcc.server.domain.GastoViagem;
import br.com.zanona.tcc.server.domain.Hospedagem;
import br.com.zanona.tcc.server.domain.LocalTrabalho;
import br.com.zanona.tcc.server.domain.MeioTransporte;
import br.com.zanona.tcc.server.domain.PeriodicidadeVisita;
import br.com.zanona.tcc.server.domain.Sexo;
import br.com.zanona.tcc.server.domain.TempoEstadia;
import br.com.zanona.tcc.server.domain.TransporteEvento;

@Path("/perfil")
public class PerfilService {
	
	@Inject
	private PerfilBC perfilBC;
	
	@GET
	@Path("/sexo/") 
	@Produces("application/json;charset=UTF-8")
	public List<BaseDomain> sexos() {
		return perfilBC.buscarSexo();
	}

	
	@GET
	@Path("/escolaridade/") 
	@Produces("application/json;charset=UTF-8")
	public List<Escolaridade> escolaridades() {
		return perfilBC.buscarEscolaridades();
	}

	@GET
	@Path("/local-trabalho/") 
	@Produces("application/json;charset=UTF-8")
	public List<LocalTrabalho> locaisTrabalho() {
		return perfilBC.buscarLocaisTrabalho();
	}

	@GET
	@Path("/estado-civil/") 
	@Produces("application/json;charset=UTF-8")
	public List<EstadoCivil> estadosCivis() {
		return perfilBC.buscarEstadosCivis();
	}

	@GET
	@Path("/gasto-viagem/") 
	@Produces("application/json;charset=UTF-8")
	public List<GastoViagem> gastosViagem() {
		return perfilBC.buscarGastosViagem();
	}

	@GET
	@Path("/acompanhante/") 
	@Produces("application/json;charset=UTF-8")
	public List<Acompanhante> acompanhantes() {
		return perfilBC.buscarAcompanhantes();
	}
	
	@GET
	@Path("/hospedagem/") 
	@Produces("application/json;charset=UTF-8")
	public List<Hospedagem> hospedagens() {
		return perfilBC.buscarHospedagens();
	}

	@GET
	@Path("/transporte-evento/") 
	@Produces("application/json;charset=UTF-8")
	public List<TransporteEvento> transportesEvento() {
		return perfilBC.buscarTransportesEvento();
	}

	@GET
	@Path("/meio-transporte/") 
	@Produces("application/json;charset=UTF-8")
	public List<MeioTransporte> meiosTransporte() {
		return perfilBC.buscarMeiosTransporte();
	}

	@GET
	@Path("/periodicidade-visita/") 
	@Produces("application/json;charset=UTF-8")
	public List<PeriodicidadeVisita> periodicidadesVisita() {
		return perfilBC.buscarPeriodicidadesVisita();
	}

	@GET
	@Path("/tempo-estadia/") 
	@Produces("application/json;charset=UTF-8")
	public List<TempoEstadia> temposEstadia() {
		return perfilBC.buscarTemposEstadia();
	}

}