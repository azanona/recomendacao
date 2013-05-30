package br.com.zanona.tcc.client.business;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.domain.ServidorRest;

public class PerfilBusiness {
	
	private RestClient client;

	public PerfilBusiness() {
		client = new RestClient(new ServidorRest("192.168.1.125", 8080));
	}
	
	/**
	 * Método que efetua obtem uma lista de objetos BaseDomain
	 * @param path do recurso
	 * @return
	 */
	private List<BaseDomain> get( String path ) {
		String resp = client.get(path);
		Type listType = new TypeToken<ArrayList<BaseDomain>>() {}.getType();
		List<BaseDomain> lista = new Gson().fromJson(resp, listType);
		return lista;
	}
	
	public List<BaseDomain> sexos(){
		return get("/recomendacao/perfil/sexo/");
	}
	
	public List<BaseDomain> escolaridades() {
		return get("/recomendacao/perfil/escolaridade/");
	}

	
	public List<BaseDomain> locaisTrabalho() {
		return get("/recomendacao/perfil/local-trabalho/");
	}

	public List<BaseDomain> estadosCivis() {
		return get("/recomendacao/perfil/estado-civil/");
	}

	public List<BaseDomain> gastosViagem() {
		return get("/recomendacao/perfil/gasto-viagem/");
	}

	public List<BaseDomain> acompanhantes() {
		return get("/recomendacao/perfil/acompanhante/");
	}
	
	public List<BaseDomain> hospedagens() {
		return get("/recomendacao/perfil/hospedagem/");
	}

	public List<BaseDomain> transportesEvento() {
		return get("/recomendacao/perfil/transporte-evento/");
	}

	public List<BaseDomain> meiosTransporte() {
		return get("/recomendacao/perfil/meio-transporte/");
	}

	public List<BaseDomain> periodicidadesVisita() {
		return get("/recomendacao/perfil/periodicidade-visita/");
	}

	public List<BaseDomain> temposEstadia() {
		return get("/recomendacao/perfil/tempo-estadia/");
	}
}
