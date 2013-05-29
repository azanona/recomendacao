package br.com.zanona.tcc.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import br.com.zanona.tcc.client.R;

public class SplashActivity extends Activity {

	private long ms = 0;
	private long splashTime = 2000;
	private boolean splashActive = true;
	private boolean paused = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread thread = getThread();
		thread.start();
	}


	private Thread getThread() {
		return new Thread(){
			@Override
			public void run() {
				try {
					while(splashActive && ms < splashTime) {
						if (!paused) {
							ms += 100;
						}
						sleep(100);
					}
				}catch (Exception e) { }
				finally {
					Intent intent = new Intent(SplashActivity.this , MapActivity.class);
					startActivity(intent);
				}
				super.run();
			}
		};
	}
}
