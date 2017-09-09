package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoLimite;
import interfaces.Limite;
import modelo.estados.LimiteNaoExcedido;

public class Jogador extends Player {
	
	private int pontosDeVida;
	private List<Card> deckCards;
	private List<CardMonstroFusao> deckFusaoJogador;
	public Limite limite;
	
	//public Jogador jogador;
	
	public Jogador(List<CardMonstroFusao> deckFusaoJogador) {
		pontosDeVida = 8000;
		deckCards = new ArrayList<>();
		this.deckFusaoJogador = deckFusaoJogador;
		this.mudaLimite(new LimiteNaoExcedido(this));
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
