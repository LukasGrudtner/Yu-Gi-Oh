package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import interfaces.Turno;
import modelo.estados.FasePrincipal1;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import visao.InterfaceGrafica;

public class CampoDeBatalha {
	
	InterfaceGrafica ig;
	
	//Cartas do Jogador
	private List<Card> deckJogador;
	private List<Card> cemiterioJogador;
	private List<CardMonstroFusao> deckFusaoJogador;
	private Map<Integer, Card> cardsMagiaEArmadilhaJogador;
	private Map<Integer, Card> cardsMonstrosJogador;
	private List<Card> maoJogador;
	private int pontosVidaJogador;
	
	//Cartas do Computador
	private List<Card> deckComputador;
	private List<Card> cemiterioComputador;
	private List<CardMonstroFusao> deckFusaoComputador;
	private Map<Integer, Card> cardsMagiaEArmadilhaComputador;
	private Map<Integer, Card> cardsMonstrosComputador;
	private List<Card> maoComputador;
	private int pontosVidaComputador;
	
	private int round;
	
	private Fase fase;
	private Turno turno;
	
	private boolean primeiroTurno = true;
	
	public CampoDeBatalha(List<Card> arrayDeckJogador, List<CardMonstroFusao> arrayDeckFusaoJogador, List<Card> arrayDeckCPU, List<CardMonstroFusao> arrayDeckFusaoCPU) {
		this.deckJogador = arrayDeckJogador;
		this.deckFusaoJogador = arrayDeckFusaoJogador;
		this.cemiterioJogador = new ArrayList<Card>();
		this.cardsMagiaEArmadilhaJogador = new HashMap<Integer, Card>();
		this.cardsMonstrosJogador = new HashMap<Integer, Card>();
		this.maoJogador = new ArrayList<Card>();
		this.pontosVidaJogador = 8000;
		
		this.deckComputador = arrayDeckCPU;
		this.deckFusaoComputador = arrayDeckFusaoCPU;
		this.cemiterioComputador = new ArrayList<Card>();
		this.cardsMagiaEArmadilhaComputador = new HashMap<Integer, Card>();
		this.cardsMonstrosComputador = new HashMap<Integer, Card>();
		this.maoComputador = new ArrayList<Card>();
		this.pontosVidaComputador = 8000;
		
//		this.turno = new TurnoJogador(this);
//		this.fase = new FasePrincipal1(this);
	}
	
	public void refreshInterfaceGrafica() {
		ig.refresh();
	}
	
	public void setInicioJogo() {
		this.turno = new TurnoJogador(this);
		this.fase = new FasePrincipal1(this);
	}
	
	public void setInterfaceGrafica(InterfaceGrafica interfaceGrafica) {
		this.ig = interfaceGrafica;
	}
	
	public Card retornaCartaPeloNome(String nomeCard) {
		for(int i = 0; i < getMaoJogador().size(); i++)
			if(nomeCard.equals(maoJogador.get(i).getNome()))
				return getMaoJogador().get(i);
		return null;
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
		this.maoComputador.add(this.getDeckCPU().get(indice));
		this.removeCardDeckCPU(indice);
	}
	
	public void addCardMaoJogadorNaInterfaceGrafica() {
		ig.apagaMaoJogador();
		int x = 1045;
		if(this.getMaoJogador().size() < 8)
			for(int i = 0; i < this.getMaoJogador().size(); i++) {
				ig.criaBotaoCardMao(x, 670, this.getMaoJogador().get(i), i);
				x -= 140;
				ig.refresh();
			}
	}
	
	public int retornaPosicaoCardNaMaoJogador(String nomeCard) {
		for(int i = 0; i < this.maoJogador.size(); i++) {
			if(this.maoJogador.get(i).getNome().equals(nomeCard))
				return i;
		}
		return 0;
	}
	
	public List<Card> getDeckJogador() {
		return this.deckJogador;
	}
	
	public List<Card> getDeckCPU() {
		return this.deckComputador;
	}
	
	public List<Card> getMaoJogador() {
		return this.maoJogador;
	}
	
	public List<Card> getMaoComputador() {
		return this.maoComputador;
	}
	
	public void removeCardDeckJogador(int indice) {
		this.deckJogador.remove(indice);
	}
	
	public void removeCardDeckCPU(int indice) {
		this.deckComputador.remove(indice);
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
		for(int i = 0; i < this.cardsMonstrosComputador.size(); i++) {
			this.cardsMonstrosComputador.remove(i);
		}
	}
	
	public Map<Integer, Card> getCardsMonstrosDoCampoDoJogador() {
		return this.cardsMonstrosJogador;
	}
	
	public Map<Integer, Card> getCardsMonstrosDoCampoDoComputador() {
		return this.cardsMonstrosComputador;
	}
	
	public void removeCardMonstroComputador(int indice) {
		this.cardsMonstrosComputador.remove(indice);
	}
	
	public void removeCardMonstroJogador(int indice) {
		this.cardsMonstrosJogador.remove(indice);
	}
	
	public void adicionaCardMonstroDoJogadorAosCardsMonstrosDoComputadorNoCampo(int indice) {
		for(int i = 0; i < this.cardsMonstrosComputador.size(); i++)
			if(this.cardsMonstrosComputador.get(i) == null) {
				this.cardsMonstrosComputador.put(indice, this.cardsMonstrosJogador.get(indice));
				break;
			}
	}
	
	public void adicionaCardDaMaoDoJogadorAoCemiterio(int indice) {
		this.cemiterioJogador.add(this.maoJogador.get(indice));
		this.maoJogador.remove(indice);
	}
	
	int xAtaque = 485;
	public void adicionaCardMonstroDaMaoDoJogadorAoCampoPosicaoAtaque(int indice) {
		for(int i = 0; i < 5; i++) {
			
			if(this.cardsMonstrosJogador.get(i) == null) {
					this.cardsMonstrosJogador.put(i, this.maoJogador.get(indice));
					ig.criaBotaoCardMonstroAtaque(xAtaque, 380, this.cardsMonstrosJogador.get(i));
					this.maoJogador.remove(indice);
					xAtaque += 140;
					xDefesa += 140;
					break;
			}
		}
	}
	
	int xDefesa = 460;
	public void adicionaCardMonstroDaMaoDoJogadorAoCampoPosicaoDefesa(int indice) {
		for(int i = 0; i < 5; i++) {
			
			if(this.cardsMonstrosJogador.get(i) == null) {
					this.cardsMonstrosJogador.put(i, this.maoJogador.get(indice));
					ig.criaBotaoCardMonstroDefesa(xDefesa, 400, this.cardsMonstrosJogador.get(i));
					this.maoJogador.remove(indice);
					xDefesa += 140;
					xAtaque += 140;
					break;
			}
		}
	}
	
	public void adicionaCardMonstroDaMaoDoComputadorAoCampo(int indice) {
		for(int i = 0; i < this.cardsMonstrosComputador.size(); i++)
			if(this.cardsMonstrosComputador.get(i) == null) {
				this.cardsMonstrosComputador.put(i, (CardMonstro) this.maoJogador.get(indice));
				this.maoComputador.remove(indice);
				break;
			}
	}
	
	public void adicionaCardDaMaoDoComputadorAoCemiterio(int indice) {
		this.cemiterioComputador.add(this.maoComputador.get(indice));
		this.maoComputador.remove(indice);
	}
	
	public void compra5CardsInicio() {
		if(this.primeiroTurno == true) {
			for(int i = 0; i < 5; i++) {	
				addCardMaoJogador();
				addCardMaoCPU();
			}
			this.primeiroTurno = false;
		}
	}
	

}
