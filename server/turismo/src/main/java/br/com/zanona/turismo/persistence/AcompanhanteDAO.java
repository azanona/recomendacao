package br.com.zanona.turismo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.turismo.domain.Acompanhante;

@Repository
public interface AcompanhanteDAO extends JpaRepository<Acompanhante , Integer> {

}
