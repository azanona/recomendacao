package br.com.zanona.tcc.server;

//@RunWith(DemoiselleRunner.class)
public class GeracaoCasosTest {

//	private String[] nomesAleatorios;
//
//	private List<AtrativoTuristico> destinoAleatorio;
//
//	private List<Escolaridade> escolaridades;
//	private List<LocalTrabalho> locaisTrabalho;
//	private List<EstadoCivil> estadosCivis;
//	private List<GastoViagem> gastosViagem;
//	private List<Acompanhante> acompanhantes;
//	private List<Hospedagem> hospedagens;
//	private List<TransporteEvento> transportesEvento;
//	private List<MeioTransporte> meiosTransporte;
//	private List<PeriodicidadeVisita> periodicidadesVisita;
//	private List<TempoEstadia> temposEstadia;
//
//	@Autowired
//	private PerfilDAO perfilDAO;
//
//	@Autowired
//	private EscolaridadeDAO escolaridadeDAO;
//
//	@Autowired
//	private LocalTrabalhoDAO localTrabalhoDAO;
//
//	@Autowired
//	private EstadoCivilDAO estadoCivilDAO;
//
//	@Autowired
//	private GastoViagemDAO gastoViagemDAO;
//
//	@Autowired
//	private AcompanhanteDAO acompanhanteDAO;
//
//	@Autowired
//	private HospedagemDAO hospedagemDAO;
//
//	@Autowired
//	private TransporteEventoDAO transporteventoDAO;
//
//	@Autowired
//	private MeioTransporteDAO meioTransporteDAO;
//
//	@Autowired
//	private PeriodicidadeVisitaDAO periodicidadeVisitaDAO;
//
//	@Autowired
//	private TempoEstadiaDAO tempoEstadiaDAO;
//
//	@Autowired
//	private AtrativoTuristicoDAO atrativoDAO;
//
//	@Autowired
//	private RecomendacaoDAO recomendacaoDAO;
//
//	/**
//	 * http://www.wjr.eti.br/nameGenerator/
//	 * 
//	 * @param pathArquivo
//	 * @return
//	 * @throws IOException
//	 */
//	private String[] carregarNomes(String pathArquivo) throws IOException {
//		String[] nomes = new String[0];
//		InputStream inputStream = getClass().getResourceAsStream(pathArquivo);
//		try {
//			nomes = IOUtils.toString(inputStream).split("\n");
//		} finally {
//			inputStream.close();
//		}
//		return nomes;
//	}
//
//	@Before
//	public void init() throws Exception {
//		nomesAleatorios = carregarNomes("/nomes-aleatorios");
//		destinoAleatorio = carregarDestinos(nomesAleatorios.length);
//		escolaridades = escolaridadeDAO.findAll();
//		locaisTrabalho = localTrabalhoDAO.findAll();
//		estadosCivis = estadoCivilDAO.findAll();
//		gastosViagem = gastoViagemDAO.findAll();
//		acompanhantes = acompanhanteDAO.findAll();
//		hospedagens = hospedagemDAO.findAll();
//		transportesEvento = transporteventoDAO.findAll();
//		meiosTransporte = meioTransporteDAO.findAll();
//		temposEstadia = tempoEstadiaDAO.findAll();
//		periodicidadesVisita = periodicidadeVisitaDAO.findAll();
//	}
//
//	private List<AtrativoTuristico> carregarDestinos(Integer numDestinos) {
//		List<AtrativoTuristico> lista = new ArrayList<AtrativoTuristico>();
//		Integer total = (int)atrativoDAO.count();
//		Integer distanciaMinima = 0;
//		Integer distanciaMaxima = 10000;
//		Integer totalMinimoVizinhos = 20;
//		Random r = new Random();
//		for (int i = 0; i < numDestinos;) {
//			Integer proxId = 1 + r.nextInt(total);
//			AtrativoTuristico atrativo = atrativoDAO.findOne(proxId);
//			Integer totalAtrativos = atrativoDAO.getNeighborhood(atrativo, distanciaMinima, distanciaMaxima);
//			Integer totalPerfil = perfilDAO.getNeighborhood(new Perfil(atrativo.getCoordenada()), 500);
//			if (totalAtrativos >= totalMinimoVizinhos && totalPerfil == 0) {
//				lista.add(atrativo);
//				i++;
//			}
//		}
//		return lista;
//	}
//
//	@Test
//	public void inserirCasos() {
//		Random random = new Random();
//		for (String nome : nomesAleatorios) {
//			// perfil
//			Perfil descricao = new Perfil();
//			descricao.setNome(nome);
//			descricao.setRendaMensal(1000 + random.nextFloat() * (7000 - 1000)); // R$1000
//																					// e
//																					// R$7000
//			descricao.setIdade(18 + random.nextInt(62));
//			descricao.setCoordenada(destinoAleatorio.get(random.nextInt(destinoAleatorio.size())).getCoordenada());
//			descricao.setAcompanhante(acompanhantes.get(random.nextInt(acompanhantes.size())));
//			descricao.setEscolaridade(escolaridades.get(random.nextInt(escolaridades.size())));
//			descricao.setEstadoCivil(estadosCivis.get(random.nextInt(estadosCivis.size())));
//			descricao.setGastoViagem(gastosViagem.get(random.nextInt(gastosViagem.size())));
//			descricao.setHospedagem(hospedagens.get(random.nextInt(hospedagens.size())));
//			descricao.setLocalTrabalho(locaisTrabalho.get(random.nextInt(locaisTrabalho.size())));
//			descricao.setMeioTransporte(meiosTransporte.get(random.nextInt(meiosTransporte.size())));
//			descricao.setPeriodicidadeVisita(periodicidadesVisita.get(random.nextInt(periodicidadesVisita.size())));
//			descricao.setTempoEstadia(temposEstadia.get(random.nextInt(temposEstadia.size())));
//			descricao.setTransporteEvento(transportesEvento.get(random.nextInt(transportesEvento.size())));
//			descricao.setSexo(Sexo.values()[random.nextInt(2)]);
//
//			// recomendacao
//			Recomendacao r = new Recomendacao();
//			r.setDescricao(descricao);
//
//			RoteiroTuristico solucao = new RoteiroTuristico();
//			solucao.setAtrativos(atrativoDAO.getNeighborhood(descricao.getCoordenada(), 20000, 5 + random.nextInt(15))); // 20km
//			r.setSolucao(solucao);
//
//			recomendacaoDAO.save(r);
//		}
//	}
}
