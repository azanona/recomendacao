package br.com.zanona.recomendacao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

import br.com.zanona.tcc.rest.GeometryDeserializer;
import br.com.zanona.tcc.rest.GeometrySerializer;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;

@Entity
@Table(name = "perfil")
@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil", allocationSize = 1)
public class Perfil implements CaseComponent, Serializable {

	private static final long serialVersionUID = 6000662436147672875L;

	@Id
	@Column(name = "per_id", columnDefinition = "bigserial")
	@GeneratedValue(generator = "seq_perfil")
	private Integer id;

	@Column(name = "per_nome")
	private String nome;

	@Column(name = "per_coordenada", nullable = true)
	private Geometry coordenada;

	@Column(name = "per_sexo")
	private String sexo;

	@Column(name = "per_idade")
	private Integer idade;

	@Column(name = "per_renda_mensal")
	private Float rendaMensal;

	@Column(name = "per_escolaridade")
	private String escolaridade;

	@Column(name = "per_local_trabalho")
	private String localTrabalho;

	@Column(name = "per_estado_civil")
	private String estadoCivil;

	@Column(name = "per_gasto_viagem")
	private String gastoViagem;

	@Column(name = "per_hospedagem")
	private String hospedagem;

	@Column(name = "per_transporte_evento")
	private String transporteEvento;

	@Column(name = "per_meio_transporte")
	private String meioTransporte;

	@Column(name = "per_periodicidade_visita")
	private String periodicidadeVisita;

	@Column(name = "per_tempo_estadia")
	private String tempoEstadia;

	public Perfil() {
	}

	public Perfil(Geometry coordenada) {
		this.coordenada = coordenada;
	}

	@JsonSerialize(using = GeometrySerializer.class)
	public Geometry getCoordenada() {
		return coordenada;
	}

	@JsonDeserialize(using = GeometryDeserializer.class)
	public void setCoordenada(Geometry coordenada) {
		this.coordenada = coordenada;
	}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGastoViagem() {
		return gastoViagem;
	}

	public void setGastoViagem(String gastoViagem) {
		this.gastoViagem = gastoViagem;
	}

	public String getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(String hospedagem) {
		this.hospedagem = hospedagem;
	}

	public String getTransporteEvento() {
		return transporteEvento;
	}

	public void setTransporteEvento(String transporteEvento) {
		this.transporteEvento = transporteEvento;
	}

	public String getMeioTransporte() {
		return meioTransporte;
	}

	public void setMeioTransporte(String meioTransporte) {
		this.meioTransporte = meioTransporte;
	}

	public String getPeriodicidadeVisita() {
		return periodicidadeVisita;
	}

	public void setPeriodicidadeVisita(String periodicidadeVisita) {
		this.periodicidadeVisita = periodicidadeVisita;
	}

	public String getTempoEstadia() {
		return tempoEstadia;
	}

	public void setTempoEstadia(String tempoEstadia) {
		this.tempoEstadia = tempoEstadia;
	}

	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", getClass());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}