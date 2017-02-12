package br.com.zanona.tcc.server.business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
import br.com.zanona.tcc.server.persistence.AcompanhanteDAO;
import br.com.zanona.tcc.server.persistence.EscolaridadeDAO;
import br.com.zanona.tcc.server.persistence.EstadoCivilDAO;
import br.com.zanona.tcc.server.persistence.GastoViagemDAO;
import br.com.zanona.tcc.server.persistence.HospedagemDAO;
import br.com.zanona.tcc.server.persistence.LocalTrabalhoDAO;
import br.com.zanona.tcc.server.persistence.MeioTransporteDAO;
import br.com.zanona.tcc.server.persistence.PeriodicidadeVisitaDAO;
import br.com.zanona.tcc.server.persistence.TempoEstadiaDAO;
import br.com.zanona.tcc.server.persistence.TransporteEventoDAO;

@Controller
public class PerfilBC implements Serializable {

	private static final long serialVersionUID = -2887240428592023876L;

	@Autowired
	private EscolaridadeDAO escolaridadeDAO;

	@Autowired
	private LocalTrabalhoDAO localTrabalhoDAO;

	@Autowired
	private EstadoCivilDAO estadoCivilDAO;

	@Autowired
	private GastoViagemDAO gastoViagemDAO;

	@Autowired
	private AcompanhanteDAO acompanhanteDAO;

	@Autowired
	private HospedagemDAO hospedagemDAO;

	@Autowired
	private TransporteEventoDAO transporteventoDAO;

	@Autowired
	private MeioTransporteDAO meioTransporteDAO;

	@Autowired
	private PeriodicidadeVisitaDAO periodicidadeVisitaDAO;

	@Autowired
	private TempoEstadiaDAO tempoEstadiaDAO;

	public List<Escolaridade> buscarEscolaridades() {
		return escolaridadeDAO.findAll();
	}

	public List<LocalTrabalho> buscarLocaisTrabalho() {
		return localTrabalhoDAO.findAll();
	}

	public List<EstadoCivil> buscarEstadosCivis() {
		return estadoCivilDAO.findAll();
	}

	public List<GastoViagem> buscarGastosViagem() {
		return gastoViagemDAO.findAll();
	}

	public List<Acompanhante> buscarAcompanhantes() {
		return acompanhanteDAO.findAll();
	}

	public List<Hospedagem> buscarHospedagens() {
		return hospedagemDAO.findAll();
	}

	public List<TransporteEvento> buscarTransportesEvento() {
		return transporteventoDAO.findAll();
	}

	public List<MeioTransporte> buscarMeiosTransporte() {
		return meioTransporteDAO.findAll();
	}

	public List<PeriodicidadeVisita> buscarPeriodicidadesVisita() {
		return periodicidadeVisitaDAO.findAll();
	}

	public List<TempoEstadia> buscarTemposEstadia() {
		return tempoEstadiaDAO.findAll();
	}

	public List<Sexo> buscarSexo() {
		return Arrays.asList(Sexo.values());
	}

}
