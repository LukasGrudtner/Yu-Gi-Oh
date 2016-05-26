package modelo;

public class CardMonstro extends Card{
	
	private String atributo;
	private int nivel;
	private int ATK;
	private int DEF;
	
	public void setCard(String nome, int nivel, String atributo, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributo = atributo;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}

}
