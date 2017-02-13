package br.com.zanona.turismo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.turismo.domain.Escolaridade;

@Repository
public interface EscolaridadeDAO extends JpaRepository<Escolaridade, Integer> {

}