package modelo;

public class CardMagia extends Card {
	
	private Tipo propriedade;
	
	public CardMagia(String nome,  int numero, Tipo propriedade, String descricao) {
		this.nome = nome;
		this.numero = numero;
		this.propriedade = propriedade;
		this.descricao = descricao;
		this.face = face;
	}
	
}
