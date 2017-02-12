package br.com.zanona.tcc.server.rest.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Geometry;

public class GeometrySerializer extends JsonSerializer<Geometry> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public GeometrySerializer() {
		logger.debug("GeometrySerializer :: create");
	}

	@Override
	public void serialize(Geometry value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		logger.debug("GeometrySerializer :: serialize");
		String geom = value == null ? "" : value.toText();
		jgen.writeString(geom);

	}

	@Override
	public Class<Geometry> handledType() {
		return Geometry.class;
	}
}
