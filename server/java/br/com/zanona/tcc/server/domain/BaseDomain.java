package br.com.zanona.tcc.server.domain;

import java.io.Serializable;

/**
 * Classe simples para transferente de entidades de dominio entre
 * cliente/servidor.
 */
public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 6467280137597675269L;

	public BaseDomain() { }
	
	
	
	public BaseDomain(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	private Integer id;
	private String nome;

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

	
	@Override
	public String toString() {
		return getNome();
	}
}
