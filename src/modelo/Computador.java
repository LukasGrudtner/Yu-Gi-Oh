package modelo;

import java.util.ArrayList;
import java.util.List;

public class Computador {
	
	private int pontosDeVida;
	private List<Card> deckCards;
	private List<CardMonstroFusao> deckCardsFusao;

	//public Computador computador;
	
	public Computador() {
		pontosDeVida = 8000;
		deckCards = new ArrayList<>();
		deckCardsFusao = new ArrayList<>();
	}
	
//	public Computador getInstance() {
//		if(computador == null)
//			computador = new Computador();
//		return computador;
//	}
	
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
	
}
