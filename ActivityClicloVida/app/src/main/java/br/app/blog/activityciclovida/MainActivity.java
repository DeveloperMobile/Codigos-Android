package br.app.blog.activityciclovida;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity {

	private static final String TAG = "CicloVidaActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "1.onCreate()");

		Button btnAbrirBrowser = findViewById(R.id.btnAbrirBrowser);
		btnAbrirBrowser.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri uri = Uri.parse("http://www.google.com.br");
				Intent it = new Intent(Intent.ACTION_VIEW, uri);
				// Verifica se a Intent a ser chamada está disponível
				if (it.resolveActivity(getPackageManager()) != null) {
					startActivity(it);
				}
			}
		});

	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "2.onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "3.onResume()");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "4.onRestart()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "5.onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "6.onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "7.onDestroy()");
	}

}
