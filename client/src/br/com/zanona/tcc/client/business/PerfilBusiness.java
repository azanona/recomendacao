package br.com.zanona.tcc.client.business;

import java.util.List;

import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.rest.DomainRestClient;

public class PerfilBusiness {

	private DomainRestClient<BaseDomain> client;

	public PerfilBusiness() {
		this.client = new DomainRestClient<BaseDomain>();
	}

	public List<BaseDomain> sexos() {
		return client.get_return_list("/recomendacao/perfil/sexo/");
	}

	public List<BaseDomain> escolaridades() {
		return client.get_return_list("/recomendacao/perfil/escolaridade/");
	}

	public List<BaseDomain> locaisTrabalho() {
		return client.get_return_list("/recomendacao/perfil/local-trabalho/");
	}

	public List<BaseDomain> estadosCivis() {
		return client.get_return_list("/recomendacao/perfil/estado-civil/");
	}

	public List<BaseDomain> gastosViagem() {
		return client.get_return_list("/recomendacao/perfil/gasto-viagem/");
	}

	public List<BaseDomain> acompanhantes() {
		return client.get_return_list("/recomendacao/perfil/acompanhante/");
	}

	public List<BaseDomain> hospedagens() {
		return client.get_return_list("/recomendacao/perfil/hospedagem/");
	}

	public List<BaseDomain> transportesEvento() {
		return client.get_return_list("/recomendacao/perfil/transporte-evento/");
	}

	public List<BaseDomain> meiosTransporte() {
		return client.get_return_list("/recomendacao/perfil/meio-transporte/");
	}

	public List<BaseDomain> periodicidadesVisita() {
		return client.get_return_list("/recomendacao/perfil/periodicidade-visita/");
	}

	public List<BaseDomain> temposEstadia() {
		return client.get_return_list("/recomendacao/perfil/tempo-estadia/");
	}
}
