package br.com.zanona.tcc.server.rest.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class GeometryDeserializer extends JsonDeserializer<Geometry> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
