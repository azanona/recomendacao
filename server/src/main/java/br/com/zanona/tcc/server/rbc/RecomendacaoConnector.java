package br.com.zanona.tcc.server.rbc;

import java.io.Serializable;
import java.net.URL;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CaseBaseFilter;
import jcolibri.cbrcore.Connector;
import jcolibri.exception.InitializingException;

import org.hibernate.Session;
import org.slf4j.Logger;

import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.com.zanona.tcc.server.domain.RoteiroTuristico;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.vividsolutions.jts.geom.Geometry;


@PersistenceController
public class RecomendacaoConnector implements Connector, Serializable {

	private static final long serialVersionUID = -3319316842861913591L;

	@Inject
	private EntityManager entityManager;
	
	@Inject
	private Logger logger;

	private Integer count = 0;

	/**
	 * Método que remove todos os casos passados por parametro.
	 */
	@Override
	@Transactional
	public void deleteCases(Collection<CBRCase> colecao) {
		if (colecao != null && !colecao.isEmpty()) {
			logger.debug("deleteCases inicio");
			for (CBRCase caso : colecao) {
				entityManager.remove(entityManager.find(Recomendacao.class, caso.getID()));
			}
			logger.debug("deleteCases fim");
		}
	}

	/**
	 * Calcula a distancia entre duas geometrias.
	 * @param g1
	 * @param g2
	 * @return distancia em KM
	 */
	public double distance( Geometry g1 , Geometry g2 ) {
		Session session = (Session) entityManager.getDelegate();
		return (Double) session.createSQLQuery( "select st_distance( st_geomfromtext(:geometriaUm) , st_geomfromtext(:geometriaDois) , true) / 1000 " )
			.setParameter("geometriaUm", g1.toText())
			.setParameter("geometriaDois", g2.toText())
			.uniqueResult();
	}
	
	/**
	 * Método que recupera todos os casos da base.
	 */
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		logger.debug("retreive all cases");
		return entityManager.createQuery("select new jcolibri.cbrcore.CBRCase( r.descricao , r.solucao ) from "+ Recomendacao.class.getName() +" r").getResultList();
	}

	/**
	 * Método que armazena todos os casos passados por parametros.
	 */
	@Override
	public void storeCases(Collection<CBRCase> colecao) {
		if (colecao != null && !colecao.isEmpty()) {
			logger.debug("storeCases inicio");
			for (CBRCase caso : colecao) {
				if (caso.getDescription() instanceof Perfil && caso.getSolution() instanceof RoteiroTuristico) {
					entityManager.persist( new Recomendacao((Perfil) caso.getDescription() , (RoteiroTuristico) caso.getSolution()) );
				}
			}
			logger.debug("storeCases fim");
		}
	}

	@Override
	public void close() {
		logger.debug("close");
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
		throw new InitializingException("initFromXMLfile não pode ser iniciado. Entity manager gerenciado pelo container.");
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter caseFilter) {
		logger.debug("retreive some cases nao implementado");
		return null;
	}

}
