package br.app.blog.galeriadeicones;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.app.blog.utils.Utils;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

	private String[] opcoes = { "Icones de Entrada", "Icones de Bloqueio", "Icones de Midia (Audio/Video)",
			"Icones de Menu", "Icones de Notificaçãoo", "Icones de Sistema", "Sair" };
	private ListView lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inicializarComponentes();
	
	}
	
	private void inicializarComponentes() {
		
		lista = (ListView) findViewById(R.id.lista);
		lista.setOnItemClickListener(this);
		lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes));
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {	
		String titulo = (String) lista.getAdapter().getItem(position);
		switch (position) {
		
		case 0: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_ENTRADA); break;
		case 1: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_BLOQUEIO); break;
		case 2: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_MIDIA); break;
		case 3: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_MENU); break;
		case 4: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_NOTIFICACAO); break;
		case 5: Utils.abrirTela(this, GenericActivity.class, titulo, Utils.ICONES_SISTEMA); break;
		default: finish();
		
		}
		
	}

}
