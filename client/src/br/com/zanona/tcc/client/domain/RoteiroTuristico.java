package br.com.zanona.tcc.client.domain;

import java.io.Serializable;
import java.util.List;

public class RoteiroTuristico implements Serializable {

	private static final long serialVersionUID = 7141523902633290001L;

	private String nome;
	private List<AtrativoTuristico> atrativos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AtrativoTuristico> getAtrativos() {
		return atrativos;
	}

	public void setAtrativos(List<AtrativoTuristico> atrativos) {
		this.atrativos = atrativos;
	}

}
