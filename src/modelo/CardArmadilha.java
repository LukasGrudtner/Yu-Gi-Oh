package modelo;

public class CardArmadilha extends Card {

	private Tipo propriedade;

	public CardArmadilha(String nome, int numero, Tipo propriedade, String descricao) {
		this.nome = nome;
		this.numero = numero;
		this.propriedade = propriedade;
		this.descricao = descricao;
		this.face = face;
	}

}
