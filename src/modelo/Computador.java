package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoLimite;
import interfaces.Limite;
import modelo.estados.LimiteNaoExcedido;

public class Computador extends Player {
	
	private Limite limite;
	private int pontosDeVida;
	private List<Card> deckCards;
	private List<CardMonstroFusao> deckCardsFusao;
	
	public Computador() {
		pontosDeVida = 8000;
		deckCards = new ArrayList<>();
		deckCardsFusao = new ArrayList<>();
		this.mudaLimite(new LimiteNaoExcedido(this));
	}
	
	public void setDeck(List<Card> deckCards) {
		this.deckCards = deckCards;
	}
	
	public void setCarta(Card card) {
		this.deckCards.add(card);
	}
	
	public void setDeckFusao(List<CardMonstroFusao> deckFusao){
		this.deckCardsFusao = deckFusao;
	}
	
	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}
	
	public List<Card> getDeck() {
		return this.deckCards;
	}
	
	public List<CardMonstroFusao> getDeckFusao() {
		return this.deckCardsFusao;
	}
	
	public int getPontosDeVida() {
		return this.pontosDeVida;
	}
	
	public void mudaLimite(Limite limite) {
		this.limite = limite;
	}
	
	public Limite getLimite() {
		return this.limite;
	}
	
	public void mudaParaLimiteExcedido() throws ExcecaoLimite {
		limite.mudaParaLimiteExcedido();
	}
	
	public void mudaParaLimiteNaoExcedido() throws ExcecaoLimite {
		limite.mudaParaLimiteNaoExcedido();
	}
	
}
