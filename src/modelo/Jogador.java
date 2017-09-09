package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private int pontosDeVida;
	private List<Card> deckCards;
	private List<CardMonstroFusao> deckFusaoJogador;
	
	//public Jogador jogador;
	
	public Jogador() {
		pontosDeVida = 8000;
		deckCards = new ArrayList<>();
		deckFusaoJogador = new ArrayList<>();
	}
	
//	public Jogador getInstance() {
//		if(jogador == null)
//			jogador = new Jogador();
//		System.out.println("jogador");
//		return jogador;
//	}
	
	public void setDeck(List<Card> deckCards) {
		this.deckCards = deckCards;
	}
	
	public void setCarta(Card card) {
		this.deckCards.add(card);
	}
	
	public void setDeckFusao(List<CardMonstroFusao> deckFusao){
		this.deckFusaoJogador = deckFusao;
	}
	
	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}
	
	public List<Card> getDeck() {
		return this.deckCards;
	}
	
	public int getSizeDeck() {
		return this.deckCards.size();
	}
	
	public List<CardMonstroFusao> getDeckFusao() {
		return this.deckFusaoJogador;
	}
	
	public int getPontosDeVida() {
		return this.pontosDeVida;
	}

}
