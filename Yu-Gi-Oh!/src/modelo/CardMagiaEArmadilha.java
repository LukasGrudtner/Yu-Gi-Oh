package modelo;

public class CardMagiaEArmadilha extends Card {
	
	private String propriedade;
	
	public void setCard(String nome,  int numero, String propriedade, String descricao) {
		this.nome = nome;
		this.numero = numero;
		this.propriedade = propriedade;
		this.descricao = descricao;
	}

}
