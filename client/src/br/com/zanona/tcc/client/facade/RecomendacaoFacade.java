package br.com.zanona.tcc.client.facade;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.zanona.tcc.client.business.PerfilBusiness;
import br.com.zanona.tcc.client.business.RoteiroTuristicoBusiness;
import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.domain.Perfil;
import br.com.zanona.tcc.client.domain.Recomendacao;
import br.com.zanona.tcc.client.domain.Sexo;
import br.com.zanona.tcc.client.gps.GPSTracker;
import br.com.zanona.tcc.client.rest.RestClient;

public class RecomendacaoFacade {

	private RestClient client;
	private RoteiroTuristicoBusiness roteiroBusiness;
	private PerfilBusiness perfilBusiness;
	
	
	public RecomendacaoFacade() {
		client = RestClient.getInstance();
		roteiroBusiness = new RoteiroTuristicoBusiness(client);
		perfilBusiness = new PerfilBusiness(client);
	}
	
	public List<Sexo> buscarSexo() {
		return perfilBusiness.buscarSexo();
	}

	public List<BaseDomain> buscarEscolaridade() {
		return perfilBusiness.buscarEscolaridade();
	}

	public List<BaseDomain> buscarLocalTrabalho() {
		return perfilBusiness.buscarLocalTrabalho();
	}

	public List<BaseDomain> buscarEstadoCivil() {
		return perfilBusiness.buscarEstadoCivil();
	}

	public List<BaseDomain> buscarGastoViagem() {
		return perfilBusiness.buscarGastoViagem();
	}

	public List<BaseDomain> buscarAcompanhante() {
		return perfilBusiness.buscarAcompanhante();
	}

	public List<BaseDomain> buscarHospedagem() {
		return perfilBusiness.buscarHospedagem();
	}

	public List<BaseDomain> buscarTransporteEvento() {
		return perfilBusiness.buscarTransporteEvento();
	}

	public List<BaseDomain> buscarMeioTransporte() {
		return perfilBusiness.buscarMeioTransporte();
	}

	public List<BaseDomain> buscarPeriodicidadeVisita() {
		return perfilBusiness.buscarPeriodicidadeVisita();
	}

	public List<BaseDomain> buscarTempoEstadia() {
		return perfilBusiness.buscarTempoEstadia();
	}

	public ArrayList<Recomendacao> buscarRecomendacao( Perfil perfil ){
		return roteiroBusiness.buscarRecomendacao(perfil);
	}
	
	public String getPosicaoGPS( Context context ) {
		GPSTracker gps = new GPSTracker(context);
		return gps.getWKT();
	}
	
}
