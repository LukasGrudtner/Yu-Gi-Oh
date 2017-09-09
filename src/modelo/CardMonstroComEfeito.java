package modelo;

import modelo.tipos.Efeito;

public class CardMonstroComEfeito extends CardMonstro {
	
	private Efeito efeito;
	
	public CardMonstroComEfeito(String nome, int nivel, Efeito efeito, int numero, int ATK, int DEF, String descricao) {
		super(nome, nivel, numero, ATK, DEF, descricao);
		this.efeito = efeito;
	}
//
//	@Override
//	public TipoCard getTipoCard() {
//		return this.tipoCard;
//	}

}
