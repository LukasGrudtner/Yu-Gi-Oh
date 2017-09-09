package modelo;

public class CardMagia extends Card {
	
	private Tipo propriedade;
	
	public CardMagia(String nome,  int numero, Tipo propriedade, String descricao) {
		super(nome, numero, descricao);
		this.propriedade = propriedade;
	}
	
}
