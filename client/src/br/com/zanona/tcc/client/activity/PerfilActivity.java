package br.com.zanona.tcc.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.Perfil;

public class PerfilActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
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
	
	private Perfil toDomain(){
		Perfil p = new Perfil();
		return p;
	}
	
}
