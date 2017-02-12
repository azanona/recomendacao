package br.com.zanona.tcc.client.business;

import java.util.List;

import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.domain.Sexo;
import br.com.zanona.tcc.client.rest.RestClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PerfilBusiness {

	private RestClient restClient;

	public PerfilBusiness( RestClient restClient ) {
		this.restClient = restClient;
	}

	public List<Sexo> buscarSexo() {
		String strJson = restClient.get("/recomendacao/perfil/sexo/");
		return new Gson().fromJson(strJson, new TypeToken<List<Sexo>>(){}.getType());
	}

	public List<BaseDomain> buscarEscolaridade() {
		String strJson = restClient.get("/recomendacao/perfil/escolaridade/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarLocalTrabalho() {
		String strJson = restClient.get("/recomendacao/perfil/local-trabalho/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarEstadoCivil() {
		String strJson = restClient.get("/recomendacao/perfil/estado-civil/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarGastoViagem() {
		String strJson = restClient.get("/recomendacao/perfil/gasto-viagem/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarAcompanhante() {
		String strJson = restClient.get("/recomendacao/perfil/acompanhante/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarHospedagem() {
		String strJson = restClient.get("/recomendacao/perfil/hospedagem/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarTransporteEvento() {
		String strJson = restClient
				.get("/recomendacao/perfil/transporte-evento/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarMeioTransporte() {
		String strJson = restClient
				.get("/recomendacao/perfil/meio-transporte/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarPeriodicidadeVisita() {
		String strJson = restClient
				.get("/recomendacao/perfil/periodicidade-visita/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}

	public List<BaseDomain> buscarTempoEstadia() {
		String strJson = restClient.get("/recomendacao/perfil/tempo-estadia/");
		 return new Gson().fromJson(strJson, new TypeToken<List<BaseDomain>>(){}.getType());
	}
	
}
