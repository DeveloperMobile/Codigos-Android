package br.app.blog.activityciclovida.utils;

import android.content.Context;
import android.widget.Toast;

public class ActivityCicloVidaUtil {

	public static void mensagem(Context context, String mensagem) {
		
		Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
		
	}
	
}
