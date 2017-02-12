package br.com.zanona.tcc.server.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name = "atrativo_turistico")
@SequenceGenerator(name = "seq_atrativo_turistico", sequenceName = "seq_atrativo_turistico", allocationSize = 1)
public class AtrativoTuristico implements Serializable {

	private static final long serialVersionUID = 50543830543470719L;

	@Id
	@Column(name = "att_id" , columnDefinition="bigserial")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_atrativo_turistico")
    private Integer id;

	@Column(name = "att_nome")
	private String nome;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "att_cat_id", referencedColumnName = "cat_id")
	private Categoria categoria;

	@Column(name = "att_coordenada", nullable = true)
	private Geometry coordenada;

	public AtrativoTuristico() {}
		
//	@JsonSerialize(using=GeometrySerializer.class)
	public Geometry getCoordenada() {
		return coordenada;
	}
	
//	@JsonDeserialize(using=GeometryDeserializer.class)
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "[nome={"+ nome  +", point="+ coordenada == null ? null : coordenada.toText() +"]";
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
		AtrativoTuristico other = (AtrativoTuristico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}