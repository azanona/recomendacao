package br.com.zanona.turismo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.turismo.domain.LocalTrabalho;

@Repository
public interface LocalTrabalhoDAO extends JpaRepository<LocalTrabalho, Integer> {


}
