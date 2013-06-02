package br.com.zanona.tcc.client.domain;

import java.io.Serializable;

public class Recomendacao implements Serializable {

	private static final long serialVersionUID = -2894682957377179389L;

	private Perfil descricao;
	private RoteiroTuristico solucao;

	public Perfil getDescricao() {
		return descricao;
	}

	public void setDescricao(Perfil descricao) {
		this.descricao = descricao;
	}

	public RoteiroTuristico getSolucao() {
		return solucao;
	}

	public void setSolucao(RoteiroTuristico solucao) {
		this.solucao = solucao;
	}

}
