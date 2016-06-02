package modelo;

import modelo.CardMonstro.AtributoCard;
import modelo.CardMonstro.TipoCard;

public class CardMonstroRitual extends CardMonstro {
	
	boolean ritual;
	
	public void setCard(String nome, int nivel, AtributoCard atributoCard, TipoCard tipoCard, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributoCard = atributoCard;
		this.tipoCard = tipoCard;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.ritual = true;
		this.descricao = descricao;
	}

}
