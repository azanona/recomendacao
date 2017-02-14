package br.com.zanona.tcc.server.rest.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.util.Beans;

import com.vividsolutions.jts.geom.Geometry;

public class GeometrySerializer extends JsonSerializer<Geometry> {

	private Logger logger = Beans.getReference(Logger.class);
	
	public GeometrySerializer() {
		logger.debug("GeometrySerializer :: create");
	}
	
	@Override
	public void serialize(Geometry value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		logger.debug("GeometrySerializer :: serialize");
		String geom = value == null ? "" : value.toText();
		jgen.writeString(geom);

	}
	@Override
	public Class<Geometry> handledType() {
		return Geometry.class;
	}
}
