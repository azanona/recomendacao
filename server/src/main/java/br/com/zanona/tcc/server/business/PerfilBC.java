package br.com.zanona.tcc.server.business;

import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.persistence.PerfilDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class PerfilBC extends DelegateCrud<Perfil, Integer, PerfilDAO> {

	private static final long serialVersionUID = -2176638875556055283L;

}
