package br.app.blog.activityciclovida.negocio;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.app.blog.activityciclovida.R;

public class SmileAdapter extends BaseAdapter {

	private Context context;
	private List<Smile> lista;
	
	public SmileAdapter(Context context, List<Smile> lista) {
		
		this.context = context;
		this.lista = lista;
		
	}
	
	@Override
	public int getCount() {
		
		return lista.size();
		
	}

	@Override
	public Object getItem(int position) {
		
		return lista.get(position);
		
	}

	@Override
	public long getItemId(int position) {
		
		return position;
		
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Smile smile = lista.get(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_item_lista, null);
		
		ImageView img = (ImageView) view.findViewById(R.id.img);
		img.setImageResource(smile.getImagem());
		TextView text = (TextView) view.findViewById(R.id.nome);
		text.setText(smile.nome);
		
		return view;
		
	}

}
