package com.codigosandroid.appbroadcastreceiver.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityTeste extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		TextView texto = new TextView(this);
		texto.setText("Exemplo abrir activity com BroadcastReceiver");
		setContentView(texto);
		
	}
	
}
