package com.codigosandroid.appbroadcastreceiver.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codigosandroid.appbroadcastreceiver.R;
import com.codigosandroid.appbroadcastreceiver.receiver.Receiver2;
import com.codigosandroid.appbroadcastreceiver.receiver.Receiver4;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ListView listView;
    private String[] opcoes = {
            "Receiver 1", "Receiver 2 - API", "Receiver 3 - ANR",
            "Receiver 4 - Iniciar Activity", "Receiver 5 - Integrar outra aplicação - APP_TESTE",
            "Sair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        registerReceiver(new Receiver2(), new IntentFilter("RECEIVER_2"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        unregisterReceiver(new Receiver2());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: sendBroadcast(new Intent("RECEIVER_1")); break;
            case 1: sendBroadcast(new Intent("RECEIVER_2")); break;
            case 2: sendBroadcast(new Intent("RECEIVER_ANR")); break;
            case 3: sendBroadcast(new Intent(this, Receiver4.class)); break;
            case 4: sendBroadcast(new Intent("APP_TESTE")); break;
            default: finish();
        }
    }

    private void inicializar() {
        listView = (ListView) findViewById(R.id.lista);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes));
    }

}
