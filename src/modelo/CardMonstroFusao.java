package modelo;

import modelo.CardMonstro.AtributoCard;
import modelo.CardMonstro.TipoCard;

public class CardMonstroFusao extends CardMonstro {
	
	boolean fusao;
	
	public CardMonstroFusao(String nome, int nivel, AtributoCard atributoCard, TipoCard tipoCard, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributoCard = atributoCard;
		this.tipoCard = tipoCard;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.fusao = true;
		this.descricao = descricao;
		this.face = face;
	}

	@Override
	public TipoCard getTipoCard() {
		return this.tipoCard;
	}
	
}
