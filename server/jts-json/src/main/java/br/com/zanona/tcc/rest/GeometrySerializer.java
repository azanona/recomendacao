package br.com.zanona.tcc.rest;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Geometry;

public class GeometrySerializer extends JsonSerializer<Geometry> {

	public GeometrySerializer() {
	}

	@Override
	public void serialize(Geometry value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String geom = value == null ? "" : value.toText();
		jgen.writeString(geom);

	}

	@Override
	public Class<Geometry> handledType() {
		return Geometry.class;
	}
}
