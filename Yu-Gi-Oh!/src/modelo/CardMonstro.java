package modelo;

public class CardMonstro extends Card{
	
	protected String atributo;
	protected int nivel;
	protected int ATK;
	protected int DEF;
	
	public void setCard(String nome, int nivel, String atributo, Tipo tipo, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributo = atributo;
		this.tipo = tipo;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	public String getAtributo() {
		return this.atributo;
	}
	
	public int getATK() {
		return this.ATK;
	}
	
	public int getDEF() {
		return this.DEF;
	}

}
