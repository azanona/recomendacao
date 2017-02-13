package br.com.zanona.turismo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.turismo.domain.EstadoCivil;

@Repository
public interface EstadoCivilDAO extends JpaRepository<EstadoCivil, Integer> {


}
