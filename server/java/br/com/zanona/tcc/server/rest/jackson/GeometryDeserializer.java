package br.com.zanona.tcc.server.rest.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.util.Beans;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class GeometryDeserializer extends JsonDeserializer<Geometry> {
	
	private Logger logger = Beans.getReference(Logger.class);
	
	public GeometryDeserializer() {
		logger.debug("GeometryDeserializer :: create");
	}
	 
	@Override
	public Geometry deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		logger.debug("GeometryDeserializer :: deserialize");
		String value = jp.getText();
		WKTReader reader = new WKTReader();
		try {
			return reader.read(value);
		} catch (ParseException e) {
			throw new JsonGenerationException(e);
		}
	}
}
