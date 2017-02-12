package br.com.zanona.tcc.server.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.tcc.server.domain.Recomendacao;

@Repository
public interface RecomendacaoDAO extends JpaRepository<Recomendacao, Integer> {

}
