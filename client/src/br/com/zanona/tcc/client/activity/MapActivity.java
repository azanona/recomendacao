package br.com.zanona.tcc.client.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import br.com.zanona.tcc.client.R;
import br.com.zanona.tcc.client.constants.IntentConstants;
import br.com.zanona.tcc.client.domain.AtrativoTuristico;
import br.com.zanona.tcc.client.domain.Recomendacao;
import br.com.zanona.tcc.client.facade.RecomendacaoFacade;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

	private Marker minhaPosicao;
	private Marker atrativoSelecionado;
	private Recomendacao recomendacao;
	private RecomendacaoFacade facade;
	private AlertDialog.Builder popup;
	private Boolean jaInseriu = false;
	
	private Map<MarkerOptions, AtrativoTuristico> mapRelacionados;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		facade = new RecomendacaoFacade();

		popup = criarPopup();

		if (getMap() != null) {
			minhaPosicaoGPS();
			getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(minhaPosicao.getPosition(), 10));
			// click nos marcadores
			getMap().setOnMarkerClickListener(new OnMarkerClickListener() {
				@Override
				public boolean onMarkerClick(Marker marker) {
					if (marker.equals(minhaPosicao)) {
						return false;
					}
					atrativoSelecionado = marker;
					popup.show();
					return true;
				}
			});
		}

	}

	private void minhaPosicaoGPS() {
		// posicao atual gps
		BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);

		minhaPosicao = getMap().addMarker(
				new MarkerOptions().position(facade.getPosicaoGPS(this))
						.title("Minha posição no GPS").icon(bitmapDescriptor));

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

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if ( recomendacao != null && ! jaInseriu ) {
			menu.add( "Salvar recomendação" );
			jaInseriu = true;
		}
		return super.onPrepareOptionsMenu(menu);
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
		case R.id.limpar:
			limparMapa();
			minhaPosicaoGPS();
			break;
		case 0 :
			Toast.makeText(getApplicationContext(),
					"Aprendendo o roteiro sugerido!", Toast.LENGTH_SHORT)
					.show();
			facade.salvar( recomendacao );
			break;
		default:
			retorno = super.onOptionsItemSelected(item);
		}
		return retorno;
	}

	private AlertDialog.Builder criarPopup() {
		AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
		builder.setTitle("O que deseja fazer?");
		String[] lista = new String[] { " Informações ", " Remover " };
		builder.setItems(lista, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case 0:
					Toast.makeText(getApplicationContext(),
							atrativoSelecionado.getTitle(), Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					recomendacao.getSolucao().getAtrativos()
							.remove(mapRelacionados.get(atrativoSelecionado));
					atrativoSelecionado.remove();
					break;

				default:
					break;
				}
			}
		});
		builder.setInverseBackgroundForced(true);
		builder.create();
		return builder;
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
				mapRelacionados = new HashMap<MarkerOptions, AtrativoTuristico>();
				for (AtrativoTuristico at : recomendacao.getSolucao()
						.getAtrativos()) {
					LatLng latLng = new LatLng(at.getLatitude(), at.getLongitude());
					MarkerOptions marker = new MarkerOptions().position(
							latLng)
							.title(at.getNome());

					getMap().addMarker(marker);
					mapRelacionados.put(marker, at);
				}
				getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(minhaPosicao.getPosition(), 10));

				break;

			default:
				break;
			}
		}
	}

}