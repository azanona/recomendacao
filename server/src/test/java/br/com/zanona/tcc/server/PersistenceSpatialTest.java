package br.com.zanona.tcc.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.zanona.tcc.server.domain.AtrativoTuristico;
import br.com.zanona.tcc.server.persistence.AtrativoTuristicoDAO;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.pagination.Pagination;
import br.gov.frameworkdemoiselle.pagination.PaginationContext;

@RunWith(DemoiselleRunner.class)
public class PersistenceSpatialTest {

	@Inject
	private AtrativoTuristicoDAO atrativoDAO ;
	
	@Inject
    private PaginationContext paginationContext;
	
	@Test
	public void  existeUmAtrativo() {
		AtrativoTuristico at = atrativoDAO.load(1);
		assertTrue( at != null );
	}
	
	@Test
	public void  existeDezAtrativos() {
		Pagination pagination = paginationContext.getPagination(AtrativoTuristico.class , true);
		pagination.setFirstResult(1);
		pagination.setPageSize(10);
		
		List<AtrativoTuristico> lstAtrativos = atrativoDAO.findAll();
		assertEquals(true, lstAtrativos.size() == 10 );
	}
	
}
