package modelo;

import java.util.ArrayList;
import java.util.List;

import interfaces.Fase;
import modelo.estados.FaseCompra;

public class CampoDeBatalha {
	
	//Cartas do Jogador
	private List<Card> arrayDeckJogador;
	private List<Card> arrayCemiterioJogador;
	private List<Card> arrayDeckFusaoJogador;
	private List<Card> arrayCardsMagiaEArmadilhaJogador;
	private List<Card> arrayCardsMonstrosJogador;
	//Cartas do Computador
	private List<Card> arrayDeckCPU;
	private List<Card> arrayCemiterioCPU;
	private List<Card> arrayDeckFusaoCPU;
	private List<Card> arrayCardsMagiaEArmadilhaCPU;
	private List<Card> arrayCardsMonstrosCPU;
	
	private Fase faseAtual;
	
	public CampoDeBatalha(List<Card> arrayDeckJogador, List<Card> arrayDeckFusaoJogador, List<Card> arrayDeckCPU, List<Card> arrayDeckFusaoCPU) {
		this.arrayDeckJogador = arrayDeckJogador;
		this.arrayDeckFusaoJogador = arrayDeckFusaoJogador;
		this.arrayDeckCPU = arrayDeckCPU;
		this.arrayDeckFusaoCPU = arrayDeckFusaoCPU;
		
		this.arrayCemiterioJogador = new ArrayList<Card>();
		this.arrayCemiterioCPU = new ArrayList<Card>();
		this.arrayCardsMagiaEArmadilhaJogador = new ArrayList<Card>();
		this.arrayCardsMagiaEArmadilhaCPU = new ArrayList<Card>();
		this.arrayCardsMonstrosJogador = new ArrayList<Card>();
		this.arrayCardsMonstrosCPU = new ArrayList<Card>();
		
		this.faseAtual = new FaseCompra(this);
	}
	
	public Fase getFase() {
		return this.faseAtual;
	}
	
	public void mudaFase(Fase proximaFase) {
		this.faseAtual = proximaFase;
	}

}
