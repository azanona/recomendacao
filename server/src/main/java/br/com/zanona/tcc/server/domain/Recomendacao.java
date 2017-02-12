package br.com.zanona.tcc.server.domain;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "recomendacao")
@SequenceGenerator(name = "seq_recomendacao", sequenceName = "seq_recomendacao", allocationSize = 1)
public class Recomendacao implements Serializable {

	private static final long serialVersionUID = 583719923667588582L;

	@Id
	@Column(name = "rec_id", columnDefinition="bigserial")
	@GeneratedValue(generator = "seq_recomendacao")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rec_per_id", referencedColumnName = "per_id")
	private Perfil descricao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rec_rot_id", referencedColumnName = "rot_id")
	private RoteiroTuristico solucao;

	public Recomendacao() { }
	
	public Recomendacao(Perfil descricao, RoteiroTuristico solucao) {
		super();
		this.descricao = descricao;
		this.solucao = solucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	@Override
	public String toString() {
		return MessageFormat.format("perfil={0} @ roteiroTuristico={1}", descricao,
				solucao);
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
		Recomendacao other = (Recomendacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
