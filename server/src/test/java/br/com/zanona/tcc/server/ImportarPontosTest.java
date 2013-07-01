package br.com.zanona.tcc.server;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import br.com.zanona.tcc.server.domain.AtrativoTuristico;
import br.com.zanona.tcc.server.persistence.AtrativoTuristicoDAO;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;


@RunWith(DemoiselleRunner.class)
public class ImportarPontosTest {


	@Inject
	private Logger log;
	
	@Inject
	private AtrativoTuristicoDAO dao;
	
	@Test
	public void carregarAtrativos() throws IOException, ParseException {
		InputStream inputStream = getClass().getResourceAsStream("/pontos-fpolis");
		try {
			String[] atrativos = IOUtils.toString(inputStream).split("\n");
			for ( String arrAtrativo : atrativos ) {
				String[] atrativo = arrAtrativo.split(";");
				String[] nomes = atrativo[2].split("-");

				String nome = nomes[0];
				String wkt = "POINT( " + atrativo[0] + " "+ atrativo[1] + " )";
				//String tipo = nomes[1];
				
				WKTReader read = new WKTReader();
				
				
				AtrativoTuristico att = new AtrativoTuristico();
				att.setNome(nome);
				Geometry g = read.read(wkt);
				g.setSRID(4326);
				att.setCoordenada( g );
				
				//dao.insert(att);
			}
		} finally {
			inputStream.close();
		}
	
	}
}
