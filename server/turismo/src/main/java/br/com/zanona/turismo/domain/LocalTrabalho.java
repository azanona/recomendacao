package br.com.zanona.turismo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="local_trabalho")
@SequenceGenerator(name = "seq_local_trabalho", sequenceName = "seq_local_trabalho", allocationSize = 1)
public class LocalTrabalho implements Serializable {

	private static final long serialVersionUID = -8200706760106150201L;

	@Id
	@Column(name = "lot_id", columnDefinition="bigserial")
	@GeneratedValue(generator = "seq_local_trabalho")
	private Integer id;
	
	@Column(name="lot_nome")
	private String nome;

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
		LocalTrabalho other = (LocalTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
