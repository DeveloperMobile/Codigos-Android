package br.app.blog.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Classe responsável por fornecer as constantes referentes
 * ao prefixo dos pacotes dos icones nativos do android como
 * também os métodos utilizados para recuperar os icones, ativar a navegação
 * no action bar e abrir uma activity recebendo parametros
 * @author Tiago Vieira Silva
 * @ */

public class Utils {

	public static final String ICONES_ENTRADA = "ic_input_";
	public static final String ICONES_BLOQUEIO = "ic_lock_";
	public static final String ICONES_MIDIA = "ic_media_";
	public static final String ICONES_MENU = "ic_menu_";
	public static final String ICONES_NOTIFICACAO = "stat_notify_";
	public static final String ICONES_SISTEMA = "stat_sys_";
	
	/**
	 *  Metodo que retorna uma lista com os icones nativos do android
	 *  de acordo com o prefixo fornecido atravez de um objeto da classe
	 *  Field
	 *  @param pacote
	 * */
	public static List<Field> fonteIcones(String pacote) {

		Field[] campos = android.R.drawable.class.getDeclaredFields();
		List<Field> dados = new ArrayList<Field>();

		for (Field campo : campos) {

			if (campo.getName().startsWith(pacote)) {

				dados.add(campo);

			}

		}

		return dados;

	}

	
	/**
	 * Metodo para abrir tela(Activity) usando as Classes Bundle e Intent para passar parametros
	 * para a tela a ser aberta.
	 * @param context
	 * @param classe
	 * @param titulo
	 * @param pacote */
	public static void abrirTela(Context context, Class<?> classe, String titulo, String pacote) {
		
		Bundle params = new Bundle();
		params.putString("pacote", pacote);
		params.putString("titulo", titulo);
		Intent it = new Intent(context, classe);
		it.putExtras(params);
		context.startActivity(it);
		
	}

}
