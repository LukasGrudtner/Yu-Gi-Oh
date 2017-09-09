package modelo;


public class CardMonstroRitual extends CardMonstro {
	
	boolean ritual;
	
	public CardMonstroRitual(String nome, int nivel, boolean ritual, int numero, int ATK, int DEF, String descricao) {
		super(nome, nivel, numero, ATK, DEF, descricao);
		this.ritual = ritual;
	}

}
