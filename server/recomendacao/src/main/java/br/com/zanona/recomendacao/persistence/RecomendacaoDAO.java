package br.com.zanona.recomendacao.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.recomendacao.domain.Recomendacao;

@Repository
public interface RecomendacaoDAO extends JpaRepository<Recomendacao, Integer> {

}
