package br.com.zanona.tcc.client.activity;

import java.io.Serializable;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.BaseDomain;
import br.com.zanona.tcc.client.domain.Perfil;
import br.com.zanona.tcc.client.domain.Recomendacao;
import br.com.zanona.tcc.client.facade.RecomendacaoFacade;

import com.google.android.gms.maps.model.LatLng;

public class PerfilActivity extends Activity {

	private EditText txtNome;
	private EditText txtIdade;
	private EditText txtRenda;
	private Spinner spnSexo;
	private Spinner spnEscolaridade;
	private Spinner spnLocalTrabalho;
	private Spinner spnEstadoCivil;
	private Spinner spnGastoViagem;
	private Spinner spnAcompanhante;
	private Spinner spnHospedagem;
	private Spinner spnTransporteEvento;
	private Spinner spnMeioTransporte;
	private Spinner spnPeriodicidade;
	private Spinner spnTempoEstadia;
	private LatLng minhaPosicao;

	private RecomendacaoFacade facade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);

		facade = new RecomendacaoFacade();

		carregarComponentes();
		carregarDados();
	}

	private void carregarComponentes() {
		spnSexo = (Spinner) findViewById(R.id.spnSexo);
		spnEscolaridade = (Spinner) findViewById(R.id.spnEscolaridade);
		spnLocalTrabalho = (Spinner) findViewById(R.id.spnLocalTrabalho);
		spnEstadoCivil = (Spinner) findViewById(R.id.spnEstadoCivil);
		spnGastoViagem = (Spinner) findViewById(R.id.spnGastoViagem);
		spnAcompanhante = (Spinner) findViewById(R.id.spnAcompanhante);
		spnHospedagem = (Spinner) findViewById(R.id.spnHospedagem);
		spnTransporteEvento = (Spinner) findViewById(R.id.spnTransporteEvento);
		spnMeioTransporte = (Spinner) findViewById(R.id.spnMeioTransporte);
		spnPeriodicidade = (Spinner) findViewById(R.id.spnPeriodicidade);
		spnTempoEstadia = (Spinner) findViewById(R.id.spnTempoEstadia);
		txtNome = (EditText) findViewById(R.id.txtNome);
		txtIdade = (EditText) findViewById(R.id.txtIdade);
		txtRenda = (EditText) findViewById(R.id.txtRenda);

		if (getIntent().getExtras() != null) {
			Double latitude = this.getIntent().getExtras()
					.getDouble(IntentConstants.LATITUDE);
			Double longitude = this.getIntent().getExtras()
					.getDouble(IntentConstants.LONGITUDE);
			if (latitude != null && longitude != null) {
				minhaPosicao = new LatLng(latitude, longitude);
			}
		}
	}

	private void carregarDados() {
		carregarSpinner(facade.buscarSexo(), spnSexo);
		carregarSpinner(facade.buscarEscolaridade(), spnEscolaridade);
		carregarSpinner(facade.buscarLocalTrabalho(), spnLocalTrabalho);
		carregarSpinner(facade.buscarEstadoCivil(), spnEstadoCivil);
		carregarSpinner(facade.buscarGastoViagem(), spnGastoViagem);
		carregarSpinner(facade.buscarAcompanhante(), spnAcompanhante);
		carregarSpinner(facade.buscarHospedagem(), spnHospedagem);
		carregarSpinner(facade.buscarTransporteEvento(), spnTransporteEvento);
		carregarSpinner(facade.buscarMeioTransporte(), spnMeioTransporte);
		carregarSpinner(facade.buscarPeriodicidadeVisita(), spnPeriodicidade);
		carregarSpinner(facade.buscarTempoEstadia(), spnTempoEstadia);
	}

	private void carregarSpinner(List<?> lista, Spinner spn) {
		spn.setAdapter(new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, lista));
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.perfil, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, MapActivity.class);
		switch (item.getItemId()) {
		case R.id.buscar:

			Recomendacao r = facade.buscarRecomendacao(toDomain());
			intent.putExtra(IntentConstants.ROTEIRO_TURISTICO, r);
			setResult(RESULT_OK, intent);
			finish();
			return true;
		case R.id.cancelar:
			setResult(RESULT_CANCELED, intent);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public String toWKT(LatLng latLng) {
		return "POINT(" + latLng.longitude + " " + latLng.latitude + ")";
	}

	private Perfil toDomain() {
		Perfil p = new Perfil();
		p.setNome(txtNome.getText().toString());

		String wkt = toWKT(minhaPosicao == null ? facade.getPosicaoGPS(this)
				: minhaPosicao);

		p.setCoordenada(wkt);
		// p.setSexo(sexo) //FIXME arruma essa coisa, pq no server é um enum..
		p.setAcompanhante((BaseDomain) spnAcompanhante.getSelectedItem());
		p.setEscolaridade((BaseDomain) spnEscolaridade.getSelectedItem());
		p.setEstadoCivil((BaseDomain) spnEstadoCivil.getSelectedItem());
		p.setGastoViagem((BaseDomain) spnGastoViagem.getSelectedItem());
		p.setHospedagem((BaseDomain) spnHospedagem.getSelectedItem());
		p.setIdade(Integer.parseInt(txtIdade.getText().toString()));
		p.setLocalTrabalho((BaseDomain) spnLocalTrabalho.getSelectedItem());
		p.setMeioTransporte((BaseDomain) spnMeioTransporte.getSelectedItem());
		p.setPeriodicidadeVisita((BaseDomain) spnPeriodicidade
				.getSelectedItem());
		p.setRendaMensal(Float.parseFloat(txtRenda.getText().toString()));
		p.setTempoEstadia((BaseDomain) spnTempoEstadia.getSelectedItem());
		p.setTransporteEvento((BaseDomain) spnTransporteEvento
				.getSelectedItem());
		return p;
	}
}
