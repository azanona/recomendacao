package br.com.zanona.turismo.domain;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categoria")
@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
public class Categoria implements Serializable {

	private static final long serialVersionUID = 3525956586556446494L;

	@Id
	@Column(name = "cat_id", columnDefinition="bigserial")
	@GeneratedValue(generator = "seq_categoria")
	private Integer id;

	@Column(name = "cat_nome")
	private String nome;
	
	@Column(name = "cat_descricao")
	private String descricao;

	@NotNull
	@Column(name = "cat_cod_mtur")
	private String codigoMtur;
	
	@ManyToOne
	@JoinColumn(name = "cat_cat_id", referencedColumnName = "cat_id")
	private Categoria categoriaPai;

	public Categoria() { }
	
	public Categoria(Integer id) { 
		this.id = id;
	}
	
	public Categoria(Integer id , String nome) { 
		this.id = id;
		this.nome = nome;
	}
	
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoMtur() {
		return codigoMtur;
	}

	public void setCodigoMtur(String codigoMtur) {
		this.codigoMtur = codigoMtur;
	}

	@Override
	public String toString() {
		return MessageFormat.format("id={0} @ mtur={1} ", getId() , getCodigoMtur() ) ;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}