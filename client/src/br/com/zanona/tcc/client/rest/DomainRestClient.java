package br.com.zanona.tcc.client.rest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.zanona.tcc.client.domain.ServidorRest;

/**
 * Classe que encapsula o <code>RestClient</code> permitindo converter os
 * objetos JSon em classes de dominio.
 * 
 * @author arthur
 * 
 * @param <T>
 */
public class DomainRestClient<T> {

	private RestClient client;

	public DomainRestClient() {
		client = new RestClient(new ServidorRest("192.168.1.125", 8080));
	}

	/**
	 * Método que obtem uma lista de objetos T
	 * 
	 * @param path
	 *            do recurso
	 * @return
	 */
	public List<T> get_return_list(String path) {
		String resp = client.get(path);
		Type listType = new TypeToken<ArrayList<T>>() {
		}.getType();
		List<T> lista = new Gson().fromJson(resp, listType);
		return lista;
	}

	public T get(String path) {
		return null;
	}

	public T post(String path) {
		return null;
	}

	public List<T> post_return_list(String path) {
		return null;
	}
}
