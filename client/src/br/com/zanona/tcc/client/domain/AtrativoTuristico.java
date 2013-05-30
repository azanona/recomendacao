package br.com.zanona.tcc.client.domain;

import java.io.Serializable;

public class AtrativoTuristico implements Serializable {

	private static final long serialVersionUID = -5234385734168890505L;

	private Integer id;
	private String nome;
	private String coordenada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}

}
