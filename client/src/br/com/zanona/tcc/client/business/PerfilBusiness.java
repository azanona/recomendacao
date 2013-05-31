package br.com.zanona.tcc.client.business;

import java.util.List;

import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.rest.RestClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PerfilBusiness {

	private RestClient restClient;

	public PerfilBusiness( RestClient restClient ) {
		this.restClient = restClient;
	}

	public List<BaseDomain> buscarSexo() {
		String strJson = restClient.get("/recomendacao/perfil/sexo/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarEscolaridade() {
		String strJson = restClient.get("/recomendacao/perfil/escolaridade/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarLocalTrabalho() {
		String strJson = restClient.get("/recomendacao/perfil/local-trabalho/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarEstadoCivil() {
		String strJson = restClient.get("/recomendacao/perfil/estado-civil/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarGastoViagem() {
		String strJson = restClient.get("/recomendacao/perfil/gasto-viagem/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarAcompanhante() {
		String strJson = restClient.get("/recomendacao/perfil/acompanhante/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarHospedagem() {
		String strJson = restClient.get("/recomendacao/perfil/hospedagem/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarTransporteEvento() {
		String strJson = restClient
				.get("/recomendacao/perfil/transporte-evento/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarMeioTransporte() {
		String strJson = restClient
				.get("/recomendacao/perfil/meio-transporte/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarPeriodicidadeVisita() {
		String strJson = restClient
				.get("/recomendacao/perfil/periodicidade-visita/");
		return toList(strJson);
	}

	public List<BaseDomain> buscarTempoEstadia() {
		String strJson = restClient.get("/recomendacao/perfil/tempo-estadia/");
		return toList(strJson);
	}

	private List<BaseDomain> toList( String json ) {
		 return new Gson().fromJson(json, new TypeToken<List<BaseDomain>>(){}.getType());
	}
	
}
