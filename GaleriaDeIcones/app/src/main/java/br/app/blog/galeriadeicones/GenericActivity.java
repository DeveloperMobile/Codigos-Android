package br.app.blog.galeriadeicones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import br.app.blog.adapter.LinhaAdapter;
import br.app.blog.utils.Utils;

public class GenericActivity extends AppCompatActivity {

	private Bundle params;
	private String dados, titulo;
	private ListView lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_generic);
		inicializarComponentes();
		
		params = getIntent().getExtras();
		
		if (params != null) {
		
			dados = (String) params.get("pacote");
			titulo = (String) params.getString("titulo");
			lista.setAdapter(new LinhaAdapter(this, Utils.fonteIcones(dados)));
			setTitle(titulo);
			
		}
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		
		case android.R.id.home: finish(); break;
		
		}
		
		return super.onOptionsItemSelected(item);
	
	}
	
	private void inicializarComponentes() {
		
		lista = (ListView) findViewById(R.id.lista1);
		
	}
	
}
