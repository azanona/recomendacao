package br.com.zanona.tcc.server.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.tcc.server.domain.Escolaridade;

@Repository
public interface EscolaridadeDAO extends CrudRepository<Escolaridade, Integer> {

}
