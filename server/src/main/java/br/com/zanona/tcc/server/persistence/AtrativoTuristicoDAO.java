package br.com.zanona.tcc.server.persistence;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.zanona.tcc.server.domain.AtrativoTuristico;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.vividsolutions.jts.geom.Geometry;

@PersistenceController
public class AtrativoTuristicoDAO extends JPACrud<AtrativoTuristico, Integer> {

	private static final long serialVersionUID = 4325708187005429639L;

	public Integer count(){
		Number total = (Number) getEntityManager().createQuery("select count(this.id) from br.com.zanona.tcc.recserver.domain.AtrativoTuristico this").getSingleResult();
		return total.intValue();
	}

	/** 
	 * Busca os vizinhos da <code>referencia</code> em até  <code>distanciaMaxima</code> em metros.
	 * @param distanciaMaxima
	 * @param referencia
	 */
	public List<AtrativoTuristico> getNeighborhood (Geometry referencia , Integer distanciaMaxima , Integer maxAtrativos) {

		Session s = (Session) getEntityManager().getDelegate();
		SQLQuery q = s.createSQLQuery(
				"	select att_id , att_cat_id , att_coordenada , att_nome "+
						" from atrativo_turistico "+
						"	where "+
						"		st_distance( "+
						"			ST_GeomFromText(:coordenada,4326) , "+
						"			att_coordenada, "+
						"			true "+
						"		) < :distanciaMaxima "
						
						
										
		);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", referencia.toText() );
		q.addEntity(AtrativoTuristico.class);
		q.setMaxResults(maxAtrativos);
		return q.list();
	}
	
	/** 
	 * Calcula o total de vizinhos do <code>atrativo</code> entre <code>distanciaMinima</code> e  <code>distanciaMaxima</code> em metros.
	 * @param distanciaMinima
	 * @param distanciaMaxima
	 * @param atrativo
	 */
	public Integer getNeighborhood (AtrativoTuristico atrativo , Integer distanciaMinima , Integer distanciaMaxima ) {

		Session s = (Session) getEntityManager().getDelegate();
		SQLQuery q = s.createSQLQuery(
				"select count(att_id) from ("+
						"	select att_id , "+
						"		st_distance( "+
						"			ST_GeomFromText(:coordenada,4326) , "+
						"			att_coordenada, "+
						"			true "+
						"		) as distancia "+
						"	from atrativo_turistico "+
						"	where att_id <> :id "+
						") a "+
						" where (distancia > :distanciaMinima) and (distancia < :distanciaMaxima) "				
		);
		q.setParameter("id", atrativo.getId());
		q.setParameter("distanciaMinima", distanciaMinima);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", atrativo.getCoordenada().toText() );
		Number total = (Number) q.uniqueResult();
		return total.intValue();
	}
	
}
