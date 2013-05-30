package br.com.zanona.tcc.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MapActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
	}

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

	/**
	 * Método que manda o usuário para outras Activity.
	 * 
	 * @param item
	 * @return
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean retorno = true;
		switch (item.getItemId()) {
			case R.id.recomendar:
				startActivityForResult(
					new Intent(this, PerfilActivity.class),
					IntentConstants.RESULT_REQUEST
				);
				break;
			case R.id.limpar:
				getMap().clear();
				break;
			case R.id.configurar:
				startActivity(
					new Intent(this, ConfiguracaoActivity.class)
				);
				break;
			default:
				retorno = super.onOptionsItemSelected(item);
			}
		return retorno;
	}
}