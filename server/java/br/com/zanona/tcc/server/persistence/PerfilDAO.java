package br.com.zanona.tcc.server.persistence;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.zanona.tcc.server.domain.Perfil;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Integer> {

	private static final long serialVersionUID = 7372810074998103669L;
	

	public Integer getNeighborhood (Perfil perfil , Integer distanciaMaxima ) {

		Session s = (Session) getEntityManager().getDelegate();
		SQLQuery q = s.createSQLQuery(
				
						"	select count(per_id) "+
						"	from perfil 		  "+
						"	where "+
						"		st_distance( "+
						"			ST_GeomFromText(:coordenada,4326) , "+
						"			per_coordenada, "+
						"			true "+
						"		) < :distanciaMaxima "						
										
		);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", perfil.getCoordenada().toText() );
		Number total = (Number) q.uniqueResult();
		return total.intValue();
	}

}
