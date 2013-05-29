package br.com.zanona.tcc.client.activity;

import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.R.id;
import br.com.zanona.tcc.client.R.layout;
import br.com.zanona.tcc.client.R.menu;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.ServidorRest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfiguracaoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracao);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.configuracao, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.salvar:
			Intent intent = new Intent( getApplicationContext() , MapActivity.class );
        	intent.putExtra(IntentConstants.CONFIGURACAO_SERVIDOR_REST, toDomain() );
        	startActivity( intent );
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private ServidorRest toDomain(){
		ServidorRest sr = new ServidorRest();
		final EditText txtEndereco = (EditText) findViewById(R.id.txtEnderecoServidor);
		final EditText txtPorta = (EditText) findViewById(R.id.txtPortaServidor);
		sr.setEndereco(txtEndereco.getText().toString());
		String strPorta = txtPorta.getText().toString();
		strPorta = strPorta.isEmpty() ? "8080" : strPorta;
		
		sr.setPorta( Integer.valueOf( strPorta ) );
		return sr;
	}
	
}
