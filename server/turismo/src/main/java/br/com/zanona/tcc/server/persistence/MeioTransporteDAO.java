package br.com.zanona.tcc.server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.tcc.server.domain.MeioTransporte;

@Repository
public interface MeioTransporteDAO extends JpaRepository<MeioTransporte, Integer> {


}
