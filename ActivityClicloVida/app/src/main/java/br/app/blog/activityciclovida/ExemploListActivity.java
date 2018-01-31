package br.app.blog.activityciclovida;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ExemploListActivity extends ListActivity {

	private String[] itens = { "Nome 1", "Nome 2", "Nome 3" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, "Selecionado: " + item, Toast.LENGTH_SHORT).show();
		
	}
	
}
