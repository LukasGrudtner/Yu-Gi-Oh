package modelo;

public class Card {
	
	private String nome;
	private int nivel;
	private String atributo; //poderia ser do tipo objeto
	private Tipo tipo;
	private int numero;
	private int ATK;
	private int DEF;
	private String descricao;
	
	public void setCard(String nome, int nivel, String atributo, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributo = atributo;
		//this.tipo = tipo;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
