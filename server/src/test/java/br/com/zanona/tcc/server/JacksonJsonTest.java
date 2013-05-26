package br.com.zanona.tcc.server;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.com.zanona.tcc.server.domain.AtrativoTuristico;
import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.persistence.AtrativoTuristicoDAO;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class JacksonJsonTest {

	@Inject
	private Logger logger;
	
	@Inject
	private AtrativoTuristicoDAO atrativoDAO;
	
	@Test
	public void serializar() {

		try {

			AtrativoTuristico at = atrativoDAO.load(1); 
			ObjectMapper oMapper = new ObjectMapper();
			String outputChild1 = oMapper.writeValueAsString(at);
			logger.debug(outputChild1);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void deserializar() {

		try {

			//AtrativoTuristico at = atrativoDAO.load(1); 
			
			ObjectMapper oMapper = new ObjectMapper();
		
			//AtrativoTuristico inputChild1 = oMapper.readValue("{\"coordenada\":\"POINT (-27 -43)\"}", AtrativoTuristico.class);
			Perfil p = oMapper.readValue("{\"coordenada\":\"POINT (-27 -43)\" ,\"categoria\": { \"id\" : 108 } }", Perfil.class);
			logger.debug(p.toString());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
