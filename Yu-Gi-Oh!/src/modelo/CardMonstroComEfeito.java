package modelo;

import modelo.tipos.Efeito;

public class CardMonstroComEfeito extends CardMonstro {
	
	private Efeito efeito;
	
	public void setCard(String nome, int nivel, String atributo, Tipo tipo, Efeito efeito, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributo = atributo;
		this.tipo = tipo;
		this.efeito = efeito;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return this.nome;
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
	public String getDescricao() {
		return this.descricao;
	}

}
