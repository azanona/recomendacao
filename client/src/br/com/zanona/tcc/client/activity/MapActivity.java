package br.com.zanona.tcc.client.activity;

import android.app.Activity;
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
import br.com.zanona.tcc.client.domain.AtrativoTuristico;
import br.com.zanona.tcc.client.domain.Perfil;
import br.com.zanona.tcc.client.domain.Recomendacao;
import br.com.zanona.tcc.client.facade.RecomendacaoFacade;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

	private Marker minhaPosicao;
	private Recomendacao recomendacao;
	private RecomendacaoFacade facade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		if (getMap() != null) {
			getMap().setOnMapClickListener(new OnMapClickListener() {
				@Override
				public void onMapClick(LatLng point) {
					// senao efetuou recomendacao pode definir novo local
					if (recomendacao == null) {
						// limpando posicao antiga
						if (minhaPosicao != null) {
							minhaPosicao.remove();
						}
						// marcador azul
						plotarMinhaPosicao(point);
					}
				}
			});
		}
		facade = new RecomendacaoFacade();

	}

	private void plotarMinhaPosicao(LatLng point) {
		if (minhaPosicao != null) {
			minhaPosicao.remove();
		}
		BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
		// definindo posicao atual
		minhaPosicao = getMap().addMarker(
				new MarkerOptions().position(point)
						.title("Minha posição manual").icon(bitmapDescriptor));
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

	public boolean onOptionsItemSelected(MenuItem item) {
		boolean retorno = true;
		switch (item.getItemId()) {
		case R.id.recomendar:
			Intent intent = new Intent(this, PerfilActivity.class);
			if (minhaPosicao != null) {
				intent.putExtra(IntentConstants.LATITUDE,
						minhaPosicao.getPosition().latitude);
				intent.putExtra(IntentConstants.LONGITUDE,
						minhaPosicao.getPosition().longitude);
			}
			startActivityForResult(intent,
					IntentConstants.RESULT_ROTEIRO_TURISTICO);
			break;
		case R.id.posicao_gps:
			plotarMinhaPosicao(facade.getPosicaoGPS(this));
			break;
		case R.id.limpar:
			limparMapa();
			break;

		default:
			retorno = super.onOptionsItemSelected(item);
		}
		return retorno;
	}

	private void limparMapa() {
		getMap().clear();
		minhaPosicao = null;
		recomendacao = null;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent pData) {

		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
			case IntentConstants.RESULT_ROTEIRO_TURISTICO:
				Object oRoteiroTuristico = pData.getExtras().get(
						IntentConstants.ROTEIRO_TURISTICO);
				recomendacao = (Recomendacao) oRoteiroTuristico;
				for (AtrativoTuristico at : recomendacao.getSolucao()
						.getAtrativos()) {
					getMap().addMarker(
							new MarkerOptions().position(
									new LatLng(at.getLatitude(), at
											.getLongitude())).title(
									at.getNome()));
				}
				break;

			default:
				break;
			}
		}
	}

}