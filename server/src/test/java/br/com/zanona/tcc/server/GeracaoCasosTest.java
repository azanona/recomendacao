package br.com.zanona.tcc.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import br.com.zanona.tcc.server.domain.Acompanhante;
import br.com.zanona.tcc.server.domain.AtrativoTuristico;
import br.com.zanona.tcc.server.domain.Escolaridade;
import br.com.zanona.tcc.server.domain.EstadoCivil;
import br.com.zanona.tcc.server.domain.GastoViagem;
import br.com.zanona.tcc.server.domain.Hospedagem;
import br.com.zanona.tcc.server.domain.LocalTrabalho;
import br.com.zanona.tcc.server.domain.MeioTransporte;
import br.com.zanona.tcc.server.domain.Perfil;
import br.com.zanona.tcc.server.domain.PeriodicidadeVisita;
import br.com.zanona.tcc.server.domain.Recomendacao;
import br.com.zanona.tcc.server.domain.RoteiroTuristico;
import br.com.zanona.tcc.server.domain.Sexo;
import br.com.zanona.tcc.server.domain.TempoEstadia;
import br.com.zanona.tcc.server.domain.TransporteEvento;
import br.com.zanona.tcc.server.persistence.AcompanhanteDAO;
import br.com.zanona.tcc.server.persistence.AtrativoTuristicoDAO;
import br.com.zanona.tcc.server.persistence.EscolaridadeDAO;
import br.com.zanona.tcc.server.persistence.EstadoCivilDAO;
import br.com.zanona.tcc.server.persistence.GastoViagemDAO;
import br.com.zanona.tcc.server.persistence.HospedagemDAO;
import br.com.zanona.tcc.server.persistence.LocalTrabalhoDAO;
import br.com.zanona.tcc.server.persistence.MeioTransporteDAO;
import br.com.zanona.tcc.server.persistence.PerfilDAO;
import br.com.zanona.tcc.server.persistence.PeriodicidadeVisitaDAO;
import br.com.zanona.tcc.server.persistence.RecomendacaoDAO;
import br.com.zanona.tcc.server.persistence.TempoEstadiaDAO;
import br.com.zanona.tcc.server.persistence.TransporteEventoDAO;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class GeracaoCasosTest {

	@Inject
	private Logger log;

	private String[] nomesAleatorios;

	private List<AtrativoTuristico> destinoAleatorio;

	private List<Escolaridade> escolaridades;
	private List<LocalTrabalho> locaisTrabalho;
	private List<EstadoCivil> estadosCivis;
	private List<GastoViagem> gastosViagem;
	private List<Acompanhante> acompanhantes;
	private List<Hospedagem> hospedagens;
	private List<TransporteEvento> transportesEvento;
	private List<MeioTransporte> meiosTransporte;
	private List<PeriodicidadeVisita> periodicidadesVisita;
	private List<TempoEstadia> temposEstadia;

	@Inject
	private PerfilDAO perfilDAO;
	
	@Inject
	private EscolaridadeDAO escolaridadeDAO;
	
	@Inject
	private LocalTrabalhoDAO localTrabalhoDAO;
	
	@Inject
	private EstadoCivilDAO estadoCivilDAO;
	
	@Inject
	private GastoViagemDAO gastoViagemDAO;
	
	@Inject
	private AcompanhanteDAO acompanhanteDAO;
	
	@Inject
	private HospedagemDAO hospedagemDAO;
	
	@Inject
	private TransporteEventoDAO transporteventoDAO;
	
	@Inject
	private MeioTransporteDAO meioTransporteDAO;
	
	@Inject
	private PeriodicidadeVisitaDAO periodicidadeVisitaDAO;
	
	@Inject
	private TempoEstadiaDAO tempoEstadiaDAO;
	
	@Inject
	private AtrativoTuristicoDAO atrativoDAO;

	@Inject
	private RecomendacaoDAO recomendacaoDAO;
	
	/**
	 * http://www.wjr.eti.br/nameGenerator/
	 * @param pathArquivo
	 * @return
	 * @throws IOException
	 */
	private String[] carregarNomes(String pathArquivo) throws IOException {
		String[] nomes = new String[0];
		InputStream inputStream = getClass().getResourceAsStream(pathArquivo);
		try {
			nomes = IOUtils.toString(inputStream).split("\n");
		} finally {
			inputStream.close();
		}
		return nomes;
	}

	@Before
	public void init() throws Exception {
		nomesAleatorios = carregarNomes("/nomes-aleatorios");
		//destinoAleatorio = carregarDestinos(nomesAleatorios.length);
		escolaridades = escolaridadeDAO.findAll();
		locaisTrabalho = localTrabalhoDAO.findAll();
		estadosCivis = estadoCivilDAO.findAll();
		gastosViagem = gastoViagemDAO.findAll();
		acompanhantes = acompanhanteDAO.findAll();
		hospedagens = hospedagemDAO.findAll();
		transportesEvento = transporteventoDAO.findAll();
		meiosTransporte = meioTransporteDAO.findAll();
		temposEstadia = tempoEstadiaDAO.findAll();
		periodicidadesVisita = periodicidadeVisitaDAO.findAll();
	}

	private List<AtrativoTuristico> carregarDestinos(Integer numDestinos) {
		List<AtrativoTuristico> lista = new ArrayList<AtrativoTuristico>();
		Integer total = atrativoDAO.count();
		Integer distanciaMinima = 0;
		Integer distanciaMaxima = 10000;
		Integer totalMinimoVizinhos = 20;
		Random r = new Random();
		for (int i = 0; i < numDestinos;) {
			Integer proxId = 1 + r.nextInt(total);
			AtrativoTuristico atrativo = atrativoDAO.load(proxId);
			Integer totalAtrativos = atrativoDAO.getNeighborhood(atrativo , distanciaMinima , distanciaMaxima );
			Integer totalPerfil = perfilDAO.getNeighborhood(new Perfil(atrativo.getCoordenada()), 500);
			if (totalAtrativos >= totalMinimoVizinhos && totalPerfil == 0 ) {
				lista.add(atrativo);
				i++;
			}
		}
		return lista;
	}

	@Test
	public void inserirCasos() {
		Random random = new Random();
		for (String nome : nomesAleatorios) {
			// perfil
			Perfil descricao = new Perfil();
			descricao.setNome(nome);
			descricao.setRendaMensal( 1000 + random.nextFloat() * (7000 - 1000) ); // R$1000 e R$7000
			descricao.setIdade( 18 + random.nextInt(62) );
			//descricao.setCoordenada(destinoAleatorio.get(random.nextInt(destinoAleatorio.size())).getCoordenada());
			descricao.setAcompanhante( acompanhantes.get( random.nextInt(acompanhantes.size()) ) );
			descricao.setEscolaridade( escolaridades.get( random.nextInt(escolaridades.size()) ) );
			descricao.setEstadoCivil( estadosCivis.get( random.nextInt(estadosCivis.size()) ) );
			descricao.setGastoViagem( gastosViagem.get( random.nextInt(gastosViagem.size()) ) );
			descricao.setHospedagem( hospedagens.get( random.nextInt(hospedagens.size()) ) );
			descricao.setLocalTrabalho( locaisTrabalho.get( random.nextInt(locaisTrabalho.size()) ) );
			descricao.setMeioTransporte( meiosTransporte.get( random.nextInt(meiosTransporte.size()) ) );
			descricao.setPeriodicidadeVisita( periodicidadesVisita.get( random.nextInt(periodicidadesVisita.size()) ) );
			descricao.setTempoEstadia( temposEstadia.get( random.nextInt(temposEstadia.size()) ) );
			descricao.setTransporteEvento( transportesEvento.get( random.nextInt(transportesEvento.size()) ) );
			descricao.setSexo( Sexo.values()[ random.nextInt(2) ] );
			
			// recomendacao
			Recomendacao r = new Recomendacao();
			r.setDescricao(descricao);
			
			RoteiroTuristico solucao = new RoteiroTuristico();
			//solucao.setAtrativos( atrativoDAO.getNeighborhood(descricao.getCoordenada(), 20000 , 5 + random.nextInt(15)) ); // 20km
			r.setSolucao(solucao);
			
			recomendacaoDAO.insert(r);
		}
	}
}
