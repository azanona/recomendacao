package br.com.zanona.tcc.client.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.business.PerfilBusiness;
import br.com.zanona.tcc.client.domain.BaseDomain;

public class PerfilActivity extends Activity {

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

	private PerfilBusiness business;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);

		business = new PerfilBusiness();

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
	}

	private void carregarDados() {
		carregarSpinner(business.sexos(), spnSexo);
		carregarSpinner(business.escolaridades(), spnEscolaridade);
		carregarSpinner(business.locaisTrabalho(), spnLocalTrabalho);
		carregarSpinner(business.estadosCivis(), spnEstadoCivil);
		carregarSpinner(business.gastosViagem(), spnGastoViagem);
		carregarSpinner(business.acompanhantes(), spnAcompanhante);
		carregarSpinner(business.hospedagens(), spnHospedagem);
		carregarSpinner(business.transportesEvento(), spnTransporteEvento);
		carregarSpinner(business.meiosTransporte(), spnMeioTransporte);
		carregarSpinner(business.periodicidadesVisita(), spnPeriodicidade);
		carregarSpinner(business.temposEstadia(), spnTempoEstadia);
	}

	private void carregarSpinner(List<BaseDomain> lista , Spinner spn) {
		spn.setAdapter( new ArrayAdapter<BaseDomain>(
				this, 
				android.R.layout.simple_spinner_dropdown_item, 
				lista
		));
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.perfil, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.buscar:
			Intent intent = new Intent();
			setResult(RESULT_OK, intent);
			return true;
		case R.id.cancelar:
			setResult(RESULT_CANCELED, new Intent());
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


}
