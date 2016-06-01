package modelo;

import modelo.tipos.Efeito;

public class CardMonstroComEfeito extends CardMonstro {
	
	private Efeito efeito;
	
	public void setCard(String nome, int nivel, AtributoCard atributoCard, TipoCard tipoCard, Efeito efeito, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributoCard = atributoCard;
		this.tipoCard = tipoCard;
		this.efeito = efeito;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}

}
