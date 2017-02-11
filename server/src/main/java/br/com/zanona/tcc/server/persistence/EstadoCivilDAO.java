package br.com.zanona.tcc.server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.tcc.server.domain.EstadoCivil;

@Repository
public interface EstadoCivilDAO extends JpaRepository<EstadoCivil, Integer> {


}
