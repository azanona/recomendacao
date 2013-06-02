package br.com.zanona.tcc.client.activity;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.AtrativoTuristico;
import br.com.zanona.tcc.client.domain.Recomendacao;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
	//	atualizarLocale();
	}
//
//	private void atualizarLocale() {
//		Locale.setDefault( Locale.US );
//		Configuration config = new Configuration();
//		config.locale = Locale.US;
//		this.getBaseContext().getResources().updateConfiguration(config, null);		
//	}

	/**
	 * Método que obtem o mapa instanciado em map.xml
	 * 
	 * @return
	 */
	private GoogleMap getMap() {
		FragmentManager myFragmentManager = getSupportFragmentManager();
		Fragment fragment = myFragmentManager.findFragmentById(R.id.map);
		SupportMapFragment supportMapFragment = (SupportMapFragment) fragment;
		return supportMapFragment.getMap();
	}

	/**
	 * Cria um menu contextual baseado em map.xml
	 * 
	 * @param menu
	 * @return
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.map, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		boolean retorno = true;
		switch (item.getItemId()) {
		case R.id.recomendar:
			startActivityForResult(new Intent(this, PerfilActivity.class),
					IntentConstants.RESULT_ROTEIRO_TURISTICO);
			break;
		default:
			retorno = super.onOptionsItemSelected(item);
		}
		return retorno;
	}
 
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent pData) {

		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
			case IntentConstants.RESULT_ROTEIRO_TURISTICO:
				Object oRoteiroTuristico = pData.getExtras().get(
						IntentConstants.ROTEIRO_TURISTICO);
				ArrayList<Recomendacao> rt = (ArrayList<Recomendacao>) oRoteiroTuristico;
				Recomendacao r = rt.get(0);
				for ( AtrativoTuristico at : r.getSolucao().getAtrativos() ) {
					getMap().addMarker(new MarkerOptions().position( new LatLng(at.getLatitude(), at.getLongitude()) )
					          .title(at.getNome()));
				}				
				break;

			default:
				break;
			}
		}
	}

}