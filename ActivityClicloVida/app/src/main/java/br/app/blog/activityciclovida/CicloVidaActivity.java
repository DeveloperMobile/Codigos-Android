package br.app.blog.activityciclovida;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import br.app.blog.activityciclovida.utils.ActivityCicloVidaUtil;

@SuppressLint("NewApi")
public class CicloVidaActivity extends AppCompatActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ciclo_vida);
		inicializarComponentes();
		ActivityCicloVidaUtil.mensagem(this, "1.onCreate()");
		
	}
	
	@Override
	protected void onStart() {
		
		super.onStart();
		ActivityCicloVidaUtil.mensagem(this, "2.onStart()");
		
	}
	
	@Override
	protected void onResume() {
		
		super.onResume();
		ActivityCicloVidaUtil.mensagem(this, "3.onResume()");
		
	}
	
	@Override
	protected void onRestart() {
		
		super.onRestart();
		ActivityCicloVidaUtil.mensagem(this, "4.onRestart()");
		
	}
	
	@Override
	protected void onPause() {
		
		super.onPause();
		ActivityCicloVidaUtil.mensagem(this, "5.onPause()");
		
	}
	
	@Override
	protected void onStop() {
		
		super.onStop();
		ActivityCicloVidaUtil.mensagem(this, "6.onStop()");
		
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		ActivityCicloVidaUtil.mensagem(this, "7.onDestroy()");
		
	}
	
	@Override
	public void onClick(View v) {
		
		Uri uri = Uri.parse("http://www.google.com.br");
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(it);

	}
	
	private void inicializarComponentes() {
		
		findViewById(R.id.btnAbrirBrowser).setOnClickListener(this);
		
	}

}
