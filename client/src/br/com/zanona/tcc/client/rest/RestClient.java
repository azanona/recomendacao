package br.com.zanona.tcc.client.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;
import br.com.zanona.tcc.client.domain.ServidorRest;

public class RestClient {

	private ServidorRest servidor;

	private RestClient() {
		this(new ServidorRest("192.168.1.134", 8080));
	}

	public RestClient(ServidorRest servidor) {
		this.servidor = servidor;
	}


	public static RestClient getInstance() {
		return new RestClient();
	}

	/**
	 * Efetua uma requisição GET ao servidor.
	 * 
	 * @param pathService
	 * @return
	 * @throws Exception
	 */
	public String get(String pathService) {
		HttpHost target = new HttpHost(servidor.getEndereco(),
				servidor.getPorta());
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(pathService);
		String result = null;
		try {
			HttpResponse response;
			response = client.execute(target, get);
			HttpEntity results = response.getEntity();
			result = EntityUtils.toString(results);
		} catch (Exception e) {
			Log.e("RestClient", e.getMessage());
		}

		return result;
	}

	/**
	 * Efetua uma requisição POST ao servidor;
	 * 
	 * @param pathService
	 * @param params
	 * @throws Exception
	 */
	public String post(String pathService, String params) {
		HttpHost target = new HttpHost(servidor.getEndereco(),
				servidor.getPorta());
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(pathService);
		String result = "";
		HttpEntity entity;
		try {
			entity = new StringEntity(params , "UTF-8");
			post.setEntity(entity);

			post.setHeader("Accept", "application/json");
			post.setHeader("Content-type", "application/json");

			HttpResponse response = client.execute(target, post);
			HttpEntity results = response.getEntity();
			result = EntityUtils.toString(results);

		} catch (Exception e) {
			Log.e("RestClient", e.getMessage());
		}
		return result;
	}

}
