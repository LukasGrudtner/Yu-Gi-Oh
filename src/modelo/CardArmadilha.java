package modelo;

public class CardArmadilha extends Card {

	private Tipo propriedade;

	public CardArmadilha(String nome, int numero, Tipo propriedade, String descricao) {
		super(nome, numero, descricao);
		this.propriedade = propriedade;
	}

}
