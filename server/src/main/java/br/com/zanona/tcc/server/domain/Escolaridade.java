package br.com.zanona.tcc.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="escolaridade")
@SequenceGenerator(name = "seq_escolaridade", sequenceName = "seq_escolaridade", allocationSize = 1)
public class Escolaridade implements Serializable {

	private static final long serialVersionUID = 3344008141922366141L;

	@Id
	@Column(name = "esc_id", columnDefinition="bigserial")
	@GeneratedValue(generator = "seq_escolaridade")
	private Integer id;
	
	@Column(name="esc_nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{ " + this.nome +" }";
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
		Escolaridade other = (Escolaridade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
