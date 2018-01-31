package br.app.blog.activityciclovida.negocio;

import br.app.blog.activityciclovida.R;

public class Smile {

	public static final int FELIZ = 0;
	public static final int TRISTE = 1;
	public static final int LOUCO = 2;
	
	public String nome;
	public final int tipo;
	
	public Smile(String nome, int tipo) {
		
		this.nome = nome;
		this.tipo = tipo;
		
	}
	
	public int getImagem() {
		
		switch (tipo) {
		
		case FELIZ: return R.drawable.feliz;
		case TRISTE: return R.drawable.triste;
		case LOUCO: return R.drawable.louco;	
		
		}
		
		return R.drawable.naoencontrado;
		
	}
	
}
