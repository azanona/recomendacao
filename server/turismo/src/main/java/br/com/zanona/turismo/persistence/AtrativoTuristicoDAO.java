package br.com.zanona.turismo.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.vividsolutions.jts.geom.Geometry;

import br.com.zanona.turismo.domain.AtrativoTuristico;

@Repository
public class AtrativoTuristicoDAO extends SimpleJpaRepository<AtrativoTuristico, Long> {

	private EntityManager manager;

	public AtrativoTuristicoDAO(EntityManager em) {
		super(AtrativoTuristico.class, em);
		this.manager = em;
	}

	/**
	 * Busca os vizinhos da <code>referencia</code> em até
	 * <code>distanciaMaxima</code> em metros.
	 * 
	 * @param distanciaMaxima
	 * @param referencia
	 */
	@SuppressWarnings("unchecked")
	public List<AtrativoTuristico> getNeighborhood(Geometry referencia, Integer distanciaMaxima, Integer maxAtrativos) {

		Session s = (Session) manager.getDelegate();
		SQLQuery q = s.createSQLQuery(
				"	select att_id , att_cat_id , att_coordenada , att_nome " + " from atrativo_turistico " + "	where "
						+ "		st_distance( " + "			ST_GeomFromText(:coordenada,4326) , "
						+ "			att_coordenada, " + "			true " + "		) < :distanciaMaxima "

		);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", referencia.toText());
		q.addEntity(AtrativoTuristico.class);
		q.setMaxResults(maxAtrativos);
		return q.list();
	}

	/**
	 * Calcula o total de vizinhos do <code>atrativo</code> entre
	 * <code>distanciaMinima</code> e <code>distanciaMaxima</code> em metros.
	 * 
	 * @param distanciaMinima
	 * @param distanciaMaxima
	 * @param atrativo
	 */
	public Integer getNeighborhood(AtrativoTuristico atrativo, Integer distanciaMinima, Integer distanciaMaxima) {

		Session s = (Session) manager.getDelegate();
		SQLQuery q = s.createSQLQuery("select count(att_id) from (" + "	select att_id , " + "		st_distance( "
				+ "			ST_GeomFromText(:coordenada,4326) , " + "			att_coordenada, " + "			true "
				+ "		) as distancia " + "	from atrativo_turistico " + "	where att_id <> :id " + ") a "
				+ " where (distancia > :distanciaMinima) and (distancia < :distanciaMaxima) ");
		q.setParameter("id", atrativo.getId());
		q.setParameter("distanciaMinima", distanciaMinima);
		q.setParameter("distanciaMaxima", distanciaMaxima);
		q.setParameter("coordenada", atrativo.getCoordenada().toText());
		Number total = (Number) q.uniqueResult();
		return total.intValue();
	}

	public AtrativoTuristico findOne(Integer proxId) {
		return manager.find(AtrativoTuristico.class, proxId);
	}

}
