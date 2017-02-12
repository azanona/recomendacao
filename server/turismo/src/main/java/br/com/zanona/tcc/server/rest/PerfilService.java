package br.com.zanona.tcc.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zanona.tcc.server.business.PerfilBC;
import br.com.zanona.tcc.server.domain.Acompanhante;
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

@RestController
public class PerfilService {

	@Autowired
	private PerfilBC perfilBC;

	@RequestMapping(value = "/perfil/sexo/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Sexo> sexos() {
		return perfilBC.buscarSexo();
	}

	@RequestMapping(value = "/perfil/escolaridade/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Escolaridade> escolaridades() {
		return perfilBC.buscarEscolaridades();
	}

	@RequestMapping(value = "/perfil/local-trabalho/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<LocalTrabalho> locaisTrabalho() {
		return perfilBC.buscarLocaisTrabalho();
	}

	@RequestMapping(value = "/perfil/estado-civil/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<EstadoCivil> estadosCivis() {
		return perfilBC.buscarEstadosCivis();
	}

	@RequestMapping(value = "/perfil/gasto-viagem/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<GastoViagem> gastosViagem() {
		return perfilBC.buscarGastosViagem();
	}

	@RequestMapping(value = "/perfil/acompanhante/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Acompanhante> acompanhantes() {
		return perfilBC.buscarAcompanhantes();
	}

	@RequestMapping(value = "/perfil/hospedagem/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Hospedagem> hospedagens() {
		return perfilBC.buscarHospedagens();
	}

	@RequestMapping(value = "/perfil/transporte-evento/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<TransporteEvento> transportesEvento() {
		return perfilBC.buscarTransportesEvento();
	}

	@RequestMapping(value = "/perfil/meio-transporte/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<MeioTransporte> meiosTransporte() {
		return perfilBC.buscarMeiosTransporte();
	}

	@RequestMapping(value = "/perfil/periodicidade-visita/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<PeriodicidadeVisita> periodicidadesVisita() {
		return perfilBC.buscarPeriodicidadesVisita();
	}

	@RequestMapping(value = "/perfil/tempo-estadia/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<TempoEstadia> temposEstadia() {
		return perfilBC.buscarTemposEstadia();
	}

}