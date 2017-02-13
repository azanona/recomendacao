package br.com.zanona.turismo.business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.zanona.turismo.domain.Acompanhante;
import br.com.zanona.turismo.domain.Escolaridade;
import br.com.zanona.turismo.domain.EstadoCivil;
import br.com.zanona.turismo.domain.GastoViagem;
import br.com.zanona.turismo.domain.Hospedagem;
import br.com.zanona.turismo.domain.LocalTrabalho;
import br.com.zanona.turismo.domain.MeioTransporte;
import br.com.zanona.turismo.domain.PeriodicidadeVisita;
import br.com.zanona.turismo.domain.Sexo;
import br.com.zanona.turismo.domain.TempoEstadia;
import br.com.zanona.turismo.domain.TransporteEvento;
import br.com.zanona.turismo.persistence.AcompanhanteDAO;
import br.com.zanona.turismo.persistence.EscolaridadeDAO;
import br.com.zanona.turismo.persistence.EstadoCivilDAO;
import br.com.zanona.turismo.persistence.GastoViagemDAO;
import br.com.zanona.turismo.persistence.HospedagemDAO;
import br.com.zanona.turismo.persistence.LocalTrabalhoDAO;
import br.com.zanona.turismo.persistence.MeioTransporteDAO;
import br.com.zanona.turismo.persistence.PeriodicidadeVisitaDAO;
import br.com.zanona.turismo.persistence.TempoEstadiaDAO;
import br.com.zanona.turismo.persistence.TransporteEventoDAO;

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
