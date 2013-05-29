package br.com.zanona.tcc.client.domain;

import java.io.Serializable;

public class ServidorRest implements Serializable {

	private static final long serialVersionUID = -625472654060339430L;

	public ServidorRest() {
	}

	public ServidorRest(String endereco, Integer porta) {
		super();
		this.endereco = endereco;
		this.porta = porta;
	}

	private String endereco;
	private Integer porta;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

}
