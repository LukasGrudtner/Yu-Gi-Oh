package modelo;


import modelo.decks.ListaCards;
import modelo.estados.FaseBatalha;

public class Gerenciador {
	
	CampoDeBatalha campoDeBatalha;
	ListaCards listaCards;
	Jogador jogador;
	Computador computador;
	
	public Gerenciador(Jogador jogador, Computador computador) {
		this.listaCards = new ListaCards();
		this.jogador = jogador;
		this.computador = computador;
		
	}
	
	public void setCampoDeBatalha(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}
	
	public void defineCartasJogador() {
		for(int i = 0; i < 50; i++) {
			jogador.setCarta(listaCards.retornaCarta(i));
		}
	}
	
	public void defineCartasCPU() {
		for(int i = 0; i < 50; i++) {
			computador.setCarta(listaCards.retornaCarta(i));
		}
	}
	
	public void compra5CardsInicio() {
		//for(int i = 24; i > (24 - 5); i--) {//campoDeBatalha.getDeckJogador().size(); i > campoDeBatalha.getDeckJogador().size()- 5; i--) {
		int j = campoDeBatalha.getDeckJogador().size() - 1;
		for(int i = j; i > j - 5; i--) {	
			campoDeBatalha.addCardMaoJogador();
			campoDeBatalha.addCardMaoCPU();
		}
	}
	
	public void cartaModoDefesa() {
		
	}
}
