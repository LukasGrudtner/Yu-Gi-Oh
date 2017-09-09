package modelo;


import java.util.Random;

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
		listaCards.embaralhaCards();
		for(int i = 0; i < 50; i++) {
			jogador.setCarta(listaCards.retornaCarta(i));
		}
	}
	
	public void defineCartasCPU() {
		listaCards.embaralhaCards();
		for(int i = 0; i < 50; i++) {
			computador.setCarta(listaCards.retornaCarta(i));
		}
	}
	
	public void cartaModoDefesa() {
		
	}
}
