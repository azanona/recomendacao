package br.com.zanona.tcc.client.domain;

import java.io.Serializable;


public class Perfil implements Serializable {

	private static final long serialVersionUID = -5175734227725468024L;

	private String nome;

	private String coordenada;

	private Character sexo;

	private Integer idade;

	private Float rendaMensal;

	private BaseDomain escolaridade;

	private BaseDomain localTrabalho;

	private BaseDomain estadoCivil;

	private BaseDomain gastoViagem;

	private BaseDomain acompanhante;

	private BaseDomain hospedagem;

	private BaseDomain transporteEvento;

	private BaseDomain meioTransporte;

	private BaseDomain periodicidadeVisita;

	private BaseDomain tempoEstadia;

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

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Float getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Float rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public BaseDomain getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(BaseDomain escolaridade) {
		this.escolaridade = escolaridade;
	}

	public BaseDomain getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(BaseDomain localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public BaseDomain getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(BaseDomain estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public BaseDomain getGastoViagem() {
		return gastoViagem;
	}

	public void setGastoViagem(BaseDomain gastoViagem) {
		this.gastoViagem = gastoViagem;
	}

	public BaseDomain getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(BaseDomain acompanhante) {
		this.acompanhante = acompanhante;
	}

	public BaseDomain getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(BaseDomain hospedagem) {
		this.hospedagem = hospedagem;
	}

	public BaseDomain getTransporteEvento() {
		return transporteEvento;
	}

	public void setTransporteEvento(BaseDomain transporteEvento) {
		this.transporteEvento = transporteEvento;
	}

	public BaseDomain getMeioTransporte() {
		return meioTransporte;
	}

	public void setMeioTransporte(BaseDomain meioTransporte) {
		this.meioTransporte = meioTransporte;
	}

	public BaseDomain getPeriodicidadeVisita() {
		return periodicidadeVisita;
	}

	public void setPeriodicidadeVisita(BaseDomain periodicidadeVisita) {
		this.periodicidadeVisita = periodicidadeVisita;
	}

	public BaseDomain getTempoEstadia() {
		return tempoEstadia;
	}

	public void setTempoEstadia(BaseDomain tempoEstadia) {
		this.tempoEstadia = tempoEstadia;
	}

	
}
