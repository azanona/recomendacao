package br.com.zanona.tcc.client.business;

import java.util.ArrayList;
import java.util.List;

import br.com.zanona.tcc.client.domain.Perfil;
import br.com.zanona.tcc.client.domain.Recomendacao;
import br.com.zanona.tcc.client.domain.RoteiroTuristico;
import br.com.zanona.tcc.client.rest.RestClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RoteiroTuristicoBusiness {

	private RestClient restClient;

	public RoteiroTuristicoBusiness(RestClient restClient) {
		this.restClient = restClient;
	}
	
	public ArrayList<Recomendacao> buscarRecomendacao( Perfil perfil ) {
		String json = new Gson().toJson(perfil, new TypeToken<Perfil>(){}.getType());
		String jsonReturn = restClient.post("/recomendacao/rbc/buscar", json);
		return new Gson().fromJson(jsonReturn, new TypeToken< ArrayList<Recomendacao> >(){}.getType());
	}
}
 