package br.com.zanona.tcc.server.persistence;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zanona.tcc.server.domain.Perfil;

@Repository
public class PerfilDAO implements Serializable {

	private static final long serialVersionUID = -467567589910185430L;
	
//	@PersistenceContext
	private EntityManager entityManager;

	public Integer getNeighborhood(Perfil perfil, Integer distanciaMaxima) {
		Session s = (Session) entityManager.getDelegate();
		SQLQuery q = s.createSQLQuery(

				"	select count(per_id) " + "	from perfil 		  " + "	where " + "		st_distance( "
						+ "			ST_GeomFromText(:coordenada,4326) , " + "			per_coordenada, "
						+ "			true " + "		) < :distanciaMaxima "

		);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", perfil.getCoordenada().toText());
		Number total = (Number) q.uniqueResult();
		return total.intValue();
	}

}
