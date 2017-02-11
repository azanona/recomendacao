package br.com.zanona.tcc.server.domain;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

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
	@Type(type = "org.hibernatespatial.GeometryUserType")
	private Geometry coordenada;

	@Column(name = "per_sexo")
	private Sexo sexo;

	@Column(name = "per_idade")
	private Integer idade;

	@Column(name = "per_renda_mensal")
	private Float rendaMensal;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_esc_id", referencedColumnName = "esc_id")
	private Escolaridade escolaridade;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_lot_id", referencedColumnName = "lot_id")
	private LocalTrabalho localTrabalho;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_etc_id", referencedColumnName = "etc_id")
	private EstadoCivil estadoCivil;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_gav_id", referencedColumnName = "gav_id")
	private GastoViagem gastoViagem;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_aco_id", referencedColumnName = "aco_id")
	private Acompanhante acompanhante;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_hos_id", referencedColumnName = "hos_id")
	private Hospedagem hospedagem;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_tre_id", referencedColumnName = "tre_id")
	private TransporteEvento transporteEvento;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_met_id", referencedColumnName = "met_id")
	private MeioTransporte meioTransporte;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_pev_id", referencedColumnName = "pev_id")
	private PeriodicidadeVisita periodicidadeVisita;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "per_tee_id", referencedColumnName = "tee_id")
	private TempoEstadia tempoEstadia;

	public Perfil() { }
	
	public Perfil(Geometry coordenada) {
		this.coordenada = coordenada;
	}

	public GastoViagem getGastoViagem() {
		return gastoViagem;
	}

	public void setGastoViagem(GastoViagem gastoViagem) {
		this.gastoViagem = gastoViagem;
	}

	public Acompanhante getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Acompanhante acompanhante) {
		this.acompanhante = acompanhante;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public TransporteEvento getTransporteEvento() {
		return transporteEvento;
	}

	public void setTransporteEvento(TransporteEvento transporteEvento) {
		this.transporteEvento = transporteEvento;
	}

	public MeioTransporte getMeioTransporte() {
		return meioTransporte;
	}

	public void setMeioTransporte(MeioTransporte meioTransporte) {
		this.meioTransporte = meioTransporte;
	}

	public PeriodicidadeVisita getPeriodicidadeVisita() {
		return periodicidadeVisita;
	}

	public void setPeriodicidadeVisita(PeriodicidadeVisita periodicidadeVisita) {
		this.periodicidadeVisita = periodicidadeVisita;
	}

	public TempoEstadia getTempoEstadia() {
		return tempoEstadia;
	}

	public void setTempoEstadia(TempoEstadia tempoEstadia) {
		this.tempoEstadia = tempoEstadia;
	}

//	@JsonSerialize(using = GeometrySerializer.class)
	public Geometry getCoordenada() {
		return coordenada;
	}

//	@JsonDeserialize(using = GeometryDeserializer.class)
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

	@Override
//	@JsonIgnore
	public Attribute getIdAttribute() {
		return new Attribute("id", getClass());
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

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public LocalTrabalho getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(LocalTrabalho localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return MessageFormat
				.format("nome={0} , rendaMensal={1} , coordenada={2} , "
						+ "acompanhante={3} , escolaridade={4} , estadoCivil={5} , "
						+ "gastoViagem={6} , hospedagem={7} , localTrabalho={8} , "
						+ "meioTransporte={9} , periodicidadeVisita={10} , tempoEstadia={11} , "
						+ "transporteEvento={12} , sexo={13} ", nome,
						rendaMensal, coordenada.toText(), acompanhante,
						escolaridade, estadoCivil, gastoViagem, hospedagem,
						localTrabalho, meioTransporte, periodicidadeVisita,
						tempoEstadia, transporteEvento, sexo
		);
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