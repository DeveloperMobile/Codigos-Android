package br.app.blog.activityciclovida;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import br.app.blog.activityciclovida.negocio.Smile;
import br.app.blog.activityciclovida.negocio.SmileAdapter;

public class ExemploListActivityAdapter extends ListActivity {

	private List<Smile> lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		lista = new ArrayList<Smile>();
		lista.add(new Smile("FELIZ", Smile.FELIZ));
		lista.add(new Smile("TRISTE", Smile.TRISTE));
		lista.add(new Smile("LOUCO", Smile.LOUCO));
		setListAdapter(new SmileAdapter(this, lista));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Smile smile = (Smile) getListAdapter().getItem(position);
		Toast.makeText(this, "Smile selecionado: " + smile.nome, Toast.LENGTH_SHORT).show();
		
	}
	
}
