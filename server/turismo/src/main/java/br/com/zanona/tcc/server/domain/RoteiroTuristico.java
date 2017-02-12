package br.com.zanona.tcc.server.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roteiro_turistico")
@SequenceGenerator(name = "seq_roteiro_turistico", sequenceName = "seq_roteiro_turistico", allocationSize = 1)
public class RoteiroTuristico implements Serializable {

	private static final long serialVersionUID = -954887524394065230L;

	@Id
	@Column(name = "rot_id", columnDefinition = "bigserial")
	@GeneratedValue(generator = "seq_roteiro_turistico")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "rot_per_id", referencedColumnName = "per_id")
	private Perfil perfil;

	@ManyToMany
	@JoinTable(name = "roteiro_turistico_atrativo", joinColumns = {
			@JoinColumn(name = "rtt_rot_id", referencedColumnName = "rot_id") }, inverseJoinColumns = {
					@JoinColumn(name = "rtt_att_id", referencedColumnName = "att_id") })
	private List<AtrativoTuristico> atrativos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<AtrativoTuristico> getAtrativos() {
		return atrativos;
	}

	public void setAtrativos(List<AtrativoTuristico> atrativos) {
		this.atrativos = atrativos;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
		RoteiroTuristico other = (RoteiroTuristico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
