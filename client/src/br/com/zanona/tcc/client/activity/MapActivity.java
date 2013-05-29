package br.com.zanona.tcc.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.ServidorRest;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MapActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		// configuracao padrao
		getMap().setMyLocationEnabled(true);
		Bundle bundle = getIntent().getExtras();
		if ( bundle != null ) {
			ServidorRest sr = (ServidorRest) bundle.getSerializable(IntentConstants.CONFIGURACAO_SERVIDOR_REST);
		}
	}
	
	/**
	 * Método que obtem o mapa instanciado em map.xml
	 * @return
	 */
	private GoogleMap getMap(){
		FragmentManager myFragmentManager = getSupportFragmentManager();
		SupportMapFragment mySupportMapFragment = (SupportMapFragment) myFragmentManager
				.findFragmentById(R.id.map);
		return mySupportMapFragment.getMap();
		
	}
	
	/**
	 * Cria um menu contextual baseado em map.xml
	 * @param menu
	 * @return
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.map, menu);
		return true;
	}

	/**
	 * Método que manda o usuário para outras Activity.
	 * @param item
	 * @return
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.recomendar:
			startActivityForResult(new Intent(this, PerfilActivity.class) , IntentConstants.RESULT_REQUEST);
			return true;
		case R.id.limpar:
			getMap().clear();
			return true;
		case R.id.configurar:
			startActivity(new Intent(this, ConfiguracaoActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}