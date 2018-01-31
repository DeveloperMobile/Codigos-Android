package br.app.blog.activityciclovida;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import br.app.blog.activityciclovida.R.id;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inicializarComponentes();
	
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case id.btnCicloVida: startActivity(new Intent(this, CicloVidaActivity.class)); break;
		case id.btnListActivity: startActivity(new Intent(this, ExemploListActivity.class)); break;
		case id.btnListActivityAdapter: startActivity(new Intent(this, ExemploListActivityAdapter.class)); break;
		
		}
		
	}

	private void inicializarComponentes() {
		
		findViewById(R.id.btnCicloVida).setOnClickListener(this);
		findViewById(R.id.btnListActivity).setOnClickListener(this);
		findViewById(R.id.btnListActivityAdapter).setOnClickListener(this);
		
	}
	
}
