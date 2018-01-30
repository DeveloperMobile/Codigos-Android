package br.app.blog.adapter;

import java.lang.reflect.Field;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.app.blog.galeriadeicones.R;

public class LinhaAdapter extends BaseAdapter {

	private List<Field> dados;
	private Context context;
	private int resourceId = 0;
	private LayoutInflater inflater;
	private static final String CATEGORIA = "blogspot";
	
	public LinhaAdapter(Context context, List<Field> dados) {
		
		this.context = context;
		this.dados = dados;
		
	}
	
	@Override
	public int getCount() {
		
		return dados.size();
	}

	@Override
	public Object getItem(int position) {
		
		return dados.get(position);
		
	}

	@Override
	public long getItemId(int position) {
		
		return position;
		
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_linha, null);
		Field atual = dados.get(position);
		
		try {
		
			resourceId = atual.getInt(new Object());
			
		} catch (Exception e) {
			
			Log.e(CATEGORIA, e.getMessage(), e);
			
		}
		
		ImageView icone = (ImageView) view.findViewById(R.id.icone);
		icone.setImageResource(resourceId);
		TextView descricao = (TextView) view.findViewById(R.id.descricao);
		descricao.setText(atual.getName());
		
		return view;
	
	}

}
