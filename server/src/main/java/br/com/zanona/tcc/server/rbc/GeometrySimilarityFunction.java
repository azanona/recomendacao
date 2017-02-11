package br.com.zanona.tcc.server.rbc;


import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vividsolutions.jts.geom.Geometry;

import jcolibri.exception.NoApplicableSimilarityFunctionException;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class GeometrySimilarityFunction implements LocalSimilarityFunction {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RecomendacaoConnector connector; 
	
	public GeometrySimilarityFunction() {
		logger.debug("GeometrySimilarityFunction init");
	}

	/***
	 * Calcula a distancia entre dois pontos
	 */
	@Override
	public double compute(Object caseObject, Object queryObject)
			throws NoApplicableSimilarityFunctionException {
		double compValue = 0;
 		logger.debug("GeometrySimilarityFunction compute :: iniciando");
		if (caseObject instanceof Geometry && queryObject instanceof Geometry) {
			Geometry p1 = (Geometry) caseObject;
			Geometry p2 = (Geometry) queryObject;
		    compValue = 1 / connector.distance(p1, p2);
			logger.debug(MessageFormat
					.format("GeometrySimilarityFunction compute :: a distancia entre {0} e {1} é de {2}",
							p1.toText(), p2.toText(), compValue));
		} else
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(
					"não é possível calcular distancia entre pontos onde o caso ou query estão null!");

		logger.debug("GeometrySimilarityFunction compute :: finalizando");
		return compValue;
	}

	public boolean isApplicable(Object o1, Object o2) {
		if ((o1 == null) && (o2 == null))
			return true;
		else if (o1 == null)
			return o2 instanceof Geometry;
		else if (o2 == null)
			return o1 instanceof Geometry;
		else
			return (o1 instanceof Geometry) && (o2 instanceof Geometry);
	}
}
