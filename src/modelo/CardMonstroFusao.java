package modelo;

public class CardMonstroFusao extends CardMonstro {
	
	boolean fusao;
	
	public CardMonstroFusao(String nome, int nivel, boolean fusao, int numero, int ATK, int DEF, String descricao) {
		super(nome, nivel, numero, ATK, DEF, descricao);
		this.fusao = fusao;
	}
	
}
