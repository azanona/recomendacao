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

	private Double[] getLatDouble() {
		int iPos = getCoordenada().indexOf('(') + 1;
		int fPos = getCoordenada().indexOf(')');
		String[] latDouble = getCoordenada().substring(iPos, fPos).split(" ");
		return new Double[]{ Double.parseDouble(latDouble[1]) , Double.parseDouble(latDouble[0] )};
	}
	
	public Double getLatitude(){
		return getLatDouble()[0];
	}
	
	public Double getLongitude(){
		return getLatDouble()[1];
	}
}
