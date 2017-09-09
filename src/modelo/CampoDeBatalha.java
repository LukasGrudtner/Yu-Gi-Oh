package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import interfaces.Turno;
import modelo.estados.FasePrincipal1;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;

public class CampoDeBatalha {
	
	//Cartas do Jogador
	private List<Card> deckJogador;
	private List<Card> cemiterioJogador;
	private List<CardMonstroFusao> deckFusaoJogador;
	private List<Card> cardsMagiaEArmadilhaJogador;
	private List<CardMonstro> cardsMonstrosJogador;
	private List<Card> maoJogador;
	private int pontosVidaJogador;
	//Cartas do Computador
	private List<Card> deckCPU;
	private List<Card> cemiterioComputador;
	private List<CardMonstroFusao> deckFusaoCPU;
	private List<Card> cardsMagiaEArmadilhaCPU;
	private List<CardMonstro> cardsMonstrosCPU;
	private List<Card> maoCPU;
	private int pontosVidaCPU;
	
	private int round;
	
	private Fase fase;
	private Turno turno;
	
	public CampoDeBatalha(List<Card> arrayDeckJogador, List<CardMonstroFusao> arrayDeckFusaoJogador, List<Card> arrayDeckCPU, List<CardMonstroFusao> arrayDeckFusaoCPU) {
		this.deckJogador = arrayDeckJogador;
		this.deckFusaoJogador = arrayDeckFusaoJogador;
		this.cemiterioJogador = new ArrayList<Card>();
		this.cardsMagiaEArmadilhaJogador = new ArrayList<Card>();
		this.cardsMonstrosJogador = new ArrayList<CardMonstro>();
		this.maoJogador = new ArrayList<Card>();
		this.pontosVidaJogador = 8000;
		
		this.deckCPU = arrayDeckCPU;
		this.deckFusaoCPU = arrayDeckFusaoCPU;
		this.cemiterioComputador = new ArrayList<Card>();
		this.cardsMagiaEArmadilhaCPU = new ArrayList<Card>();
		this.cardsMonstrosCPU = new ArrayList<CardMonstro>();
		this.maoCPU = new ArrayList<Card>();
		this.pontosVidaCPU = 8000;
		
		this.turno = new TurnoJogador(this);
		this.fase = new FasePrincipal1(this);
	}
	
	public void embaralhaCards() {
		
	}
	
	public void trocaTurno() {
		try {

			if (getTurno() instanceof TurnoJogador)
				mudaParaTurnoComputador();
			
			else
				mudaParaTurnoJogador();

		} catch (ExcecaoTurno e) {

		}
	}
	
	public Fase getFase() {
		return this.fase;
	}
	
	public void mudaFase(Fase fase) {
		this.fase = fase;
	}
	
	public Turno getTurno() {
		return this.turno;
	}
	
	public void mudaTurno(Turno turno) {
		this.turno = turno;
	}
	
	public void addCardMaoJogador() {
		int indice = this.getDeckJogador().size() - 1;
		this.maoJogador.add(this.getDeckJogador().get(indice));
		this.removeCardDeckJogador(indice);
	}
	
	public void addCardMaoCPU() {
		int indice = this.getDeckJogador().size() - 1;
		this.maoCPU.add(this.getDeckCPU().get(indice));
		this.removeCardDeckCPU(indice);
	}
	
	public List<Card> getDeckJogador() {
		return this.deckJogador;
	}
	
	public List<Card> getDeckCPU() {
		return this.deckCPU;
	}
	
	public List<Card> getMaoJogador() {
		return this.maoJogador;
	}
	
	public List<Card> getMaoComputador() {
		return this.maoCPU;
	}
	
	public void removeCardDeckJogador(int indice) {
		this.deckJogador.remove(indice);
	}
	
	public void removeCardDeckCPU(int indice) {
		this.deckCPU.remove(indice);
	}
	
	public void mudaParaFasePrincipal1() throws ExcecaoFase {
		fase.mudaParaFasePrincipal1();
	}
	
	public void mudaParaFaseBatalha() throws ExcecaoFase {
		fase.mudaParaFaseBatalha();
	}
	
	public void mudaParaFasePrincipal2() throws ExcecaoFase {
		fase.mudaParaFasePrincipal2();
	}
	
	public void mudaParaTurnoJogador() throws ExcecaoTurno {
		turno.turnoJogador();
	}
	
	public void mudaParaTurnoComputador() throws ExcecaoTurno {
		turno.turnoComputador();
	}
	
	public List<Card> getCemiterioJogador() {
		return cemiterioJogador;
	}
	
	public List<Card> getCemiterioComputador() {
		return cemiterioComputador;
	}
	
	public void removeCardCemiterio(String card) {
		for(int i = 0; i < this.cemiterioJogador.size(); i++) {
			if(this.cemiterioJogador.get(i).getNome().equals(card))
				this.cemiterioJogador.remove(i);
		}
	}
	
	public void removeTodosOsCardsMonstrosNoCampoDoJogador() {
		for(int i = 0; i < this.cardsMonstrosJogador.size(); i++) {
			this.cardsMonstrosJogador.remove(i);
		}
	}
	
	public void removeTodosOsCardsMonstrosNoCampoDoComputador() {
		for(int i = 0; i < this.cardsMonstrosCPU.size(); i++) {
			this.cardsMonstrosCPU.remove(i);
		}
	}
	
	public List<CardMonstro> getCardsMonstrosDoCampoDoJogador() {
		return this.cardsMonstrosJogador;
	}
	
	public List<CardMonstro> getCardsMonstrosDoCampoDoComputador() {
		return this.cardsMonstrosCPU;
	}
	
	public void removeCardMonstroComputador(int indice) {
		this.cardsMonstrosCPU.remove(indice);
	}
	
	public void removeCardMonstroJogador(int indice) {
		this.cardsMonstrosJogador.remove(indice);
	}
	
	public void adicionaCardMonstroDoJogadorAosCardsMonstrosDoComputadorNoCampo(int indice) {
		this.cardsMonstrosCPU.add(this.cardsMonstrosJogador.get(indice));
	}
	
	public void adicionaCardDaMaoDoJogadorAoCemiterio(int indice) {
		this.cemiterioJogador.add(this.maoJogador.get(indice));
		this.maoJogador.remove(indice);
	}
	
	public void adicionaCardDaMaoDoComputadorAoCemiterio(int indice) {
		this.cemiterioComputador.add(this.maoCPU.get(indice));
		this.maoCPU.remove(indice);
	}
	
	public void compraCardJogador() {
		this.maoJogador.add(this.deckJogador.get(this.deckJogador.size() - 1));
		this.deckJogador.remove(this.deckJogador.size() - 1);
	}
	
	public void compraCardComputador() {
		this.maoCPU.add(this.deckCPU.get(this.deckCPU.size() - 1));
		this.deckCPU.remove(this.deckCPU.size() - 1);
	}

}
