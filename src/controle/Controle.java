package controle;

import visao.InteracaoUsuario;
import visao.InterfaceGrafica;
import visao.PlaySound;

import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoInvocacao;
import interfaces.Fase;
import interfaces.Invocacao;
import interfaces.Turno;
import modelo.CampoDeBatalha;
import modelo.Card;
import modelo.CardMonstro;
import modelo.CardMonstroFusao;
import modelo.Computador;
import modelo.Jogador;
import modelo.decks.ListaCards;
import modelo.estados.FaseBatalha;
import modelo.estados.FasePrincipal1;
import modelo.estados.FasePrincipal2;
import modelo.estados.LimiteExcedido;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;

public class Controle {
	
	private static Controle controle;
	
	private Jogador jogador;
	private Computador computador;
	private CampoDeBatalha campoDeBatalha;
	private InterfaceGrafica interfaceGrafica;
	private ListaCards listaCards;
	private InteracaoUsuario iu;
	
	private Controle() {
		this.Corpo();
	}
	
	public Controle getInstanceControle() {
		if(controle == null)
			controle = new Controle();
		return controle;
	}
	
	private void Corpo() {
		
		listaCards = new ListaCards();
		jogador = new Jogador(listaCards.getDeckFusao());
		computador = new Computador();
		campoDeBatalha = new CampoDeBatalha(jogador, computador, jogador.getDeck(), jogador.getDeckFusao(), computador.getDeck(), computador.getDeckFusao());
		interfaceGrafica = new InterfaceGrafica();
		interfaceGrafica.setControle(this);
		iu = new InteracaoUsuario();
		campoDeBatalha.setInstanceControle(this);
	}
	
	public void playSound(String soundName) {
		PlaySound p = new PlaySound();
		p.playSound(soundName);
	}
	
	public void atualizaVidaJogador() {
		interfaceGrafica.atualizaVidaJogador();
	}
	
	public void atualizaVidaComputador() {
		interfaceGrafica.atualizaVidaComputador();
	}
	
	public void terminaJogo() {
		interfaceGrafica.terminaJogo();
	}
	
	public void apagaMaoJogador() {
		interfaceGrafica.apagaMaoJogador();
	}
	
	public void criaBotaoCardMaoJogador(int x, int y, Card card, int posicao) {
		interfaceGrafica.criaBotaoCardMaoJogador(x, y, card, posicao);
	}
	
	public void atualizaPilhas() {
		interfaceGrafica.atualizaPilhas();
	}
	
	public void apagaMaoComputador() {
		interfaceGrafica.apagaMaoComputador();
	}
	
	public void criaBotaoCardMaoComputador(int x, int y, Card card, int posicao) {
		interfaceGrafica.criaBotaoCardMaoComputador(x, y, card, posicao);
	}
	
	public void removeCardMonstroJogador(int indice) {
		interfaceGrafica.removeCardMonstroJogador(indice);
	}
	
	public void removeCardMonstroComputador(int indice) {
		interfaceGrafica.removeCardMonstroComputador(indice);
	}
	
	public void criaBotaoCardMagiaEArmadilhaJogador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMagiaEArmadilhaJogador(x, y, card, xMao, yMao);
	}
	
	public void criaBotaoCardMonstroAtaqueJogador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMonstroAtaqueJogador(x, y, card, xMao, yMao);
	}
	
	public void criaBotaoCardMonstroDefesaJogador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMonstroDefesaJogador(x, y, card, xMao, yMao);
	}
	
	public void criaBotaoCardMagiaEArmadilhaComputador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMagiaEArmadilhaComputador(x, y, card, xMao, yMao);
	}
	
	public void criaBotaoCardMonstroAtaqueComputador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMonstroAtaqueComputador(x, y, card, xMao, yMao);
	}
	
	public void criaBotaoCardMonstroDefesaComputador(int x, int y, Card card, int xMao, int yMao) {
		interfaceGrafica.criaBotaoCardMonstroDefesaComputador(x, y, card, xMao, yMao);
	}
	
	public Map<Integer, JButton> getListaButtonsCardsMonstrosJogador() {
		return interfaceGrafica.getListaButtonsCardsMonstrosJogador();
	}
	
	public Map<Integer, JButton> getListaButtonsCardsMonstrosComputador() {
		return interfaceGrafica.getListaButtonsCardsMonstrosComputador();
	}
	
	public void removeCardMagiaEArmadilhaJogador(int posicao) {
		interfaceGrafica.removeCardMagiaEArmadilhaJogador(posicao);
	}
	
	public void removeCardMagiaEArmadilhaComputador(int posicao) {
		interfaceGrafica.removeCardMagiaEArmadilhaComputador(posicao);
	}
	
	public void imprimeString(String string) {
		iu.imprimeString(string);
	}
	
	public Turno getTurno() {
		return campoDeBatalha.getTurno();
	}
	
	public Fase getFase() {
		return campoDeBatalha.getFase();
	}
	
	public void setCardDisabledJogador(Card card) {
		campoDeBatalha.setCardDisabledJogador(card);
	}
	
	public void setAtacanteBattle(CardMonstro cardAtacante) {
		campoDeBatalha.setAtacanteBattle(cardAtacante);
	}
	
	public void setAlvoBattle(CardMonstro cardAlvo) {
		campoDeBatalha.setAlvoBattle(cardAlvo);
	}
	
	public int retornaPosicaoCardMonstroNoCampoJogador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardMonstroNoCampoJogador(nomeCard);
	}
	
	public int retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(nomeCard);
	}
	
	public void setCardEnabledComputador() {
		campoDeBatalha.setCardEnabledComputador();
	}
	
	public void setCardDisabledComputador(Card card) {
		campoDeBatalha.setCardDisabledComputador(card);
	}
	
	public int retornaPosicaoCardMonstroNoCampoComputador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardMonstroNoCampoComputador(nomeCard);
	}
	
	public int retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(nomeCard);
	}
	
	public Jogador getJogador() {
		return campoDeBatalha.getJogador();
	}
	
	public Computador getComputador() {
		return campoDeBatalha.getComputador();
	}
	
	public Invocacao getInvocacao() {
		return campoDeBatalha.getInvocacao();
	}
	
	public int getNumCardsMonstrosDoCampoDoJogador() {
		return campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size();
	}
	
	public int getNumCardsMonstrosDoCampoDoComputador() {
		return campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size();
	}
	
	public int getDeckJogador() {
		return campoDeBatalha.getDeckJogador().size();
	}
	
	public List<Card> getDeckComputador() {
		return campoDeBatalha.getDeckComputador();
	}
	
	public void adicionaCardDaMaoDoJogadorAoCemiterio(int indice) {
		campoDeBatalha.adicionaCardDaMaoDoJogadorAoCemiterio(indice);
	}
	
	public void adicionaCardDaMaoDoJogadorAoCampo(int indice, int xMao, int yMao, Card card) {
		campoDeBatalha.adicionaCardDaMaoDoJogadorAoCampo(indice, xMao, yMao, card);
	}
	
	public void adicionaCardDaMaoDoComputadorAoCemiterio(int indice) {
		campoDeBatalha.adicionaCardDaMaoDoComputadorAoCemiterio(indice);
	}
	
	public void adicionaCardDaMaoDoComputadorAoCampo(int indice, int xMao, int yMao, Card card) {
		campoDeBatalha.adicionaCardDaMaoDoComputadorAoCampo(indice, xMao, yMao, card);
	}
	
	public int retornaPosicaoCardNaMaoJogador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardNaMaoJogador(nomeCard);
	}
	
	public int retornaPosicaoCardNaMaoComputador(String nomeCard) {
		return campoDeBatalha.retornaPosicaoCardNaMaoComputador(nomeCard);
	}
	
	public void mudaParaLimiteNaoExcedidoJogador() {
		campoDeBatalha.mudaParaLimiteNaoExcedidoJogador();
	}
	
	public void mudaParaLimiteNaoExcedidoComputador() {
		campoDeBatalha.mudaParaLimiteNaoExcedidoComputador();
	}
	
	public void mudaParaFaseBatalha() {
		try {
			campoDeBatalha.mudaParaFaseBatalha();
		} catch (ExcecaoFase e) {
			e.printStackTrace();
		}
	}
	
	public void mudaParaFasePrincipal1() {
		try {
			campoDeBatalha.mudaParaFasePrincipal1();
		} catch (ExcecaoFase e) {
			e.printStackTrace();
		}
	}
	
	public void mudaParaFasePrincipal2() {
		try {
			campoDeBatalha.mudaParaFasePrincipal2();
		} catch (ExcecaoFase e) {
			e.printStackTrace();
		}
	}
	
	public String retornaEstatisticas() {
		return campoDeBatalha.retornaEstatisticas();
	}
	
	public int getVidaJogador() {
		return campoDeBatalha.getVidaJogador();
	}
	
	public int getVidaComputador() {
		return campoDeBatalha.getVidaComputador();
	}
	
	public List<CardMonstroFusao> getDeckFusaoJogador() {
		return campoDeBatalha.getDeckFusaoJogador();
	}
	
	public void setInicioJogo() {
		campoDeBatalha.setInicioJogo();
	}
	
	public void salvaArquivo() {
		campoDeBatalha.salvaArquivo();
	}
	
	public void trocaTurno() {
		campoDeBatalha.trocaTurno();
	}
	
	public void addCardMaoJogadorNaInterfaceGrafica() {
		campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
	}
	
	public void addCardMaoComputadorNaInterfaceGrafica() {
		campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
	}
	
	public void mudaParaMonstroInvocado() {
		try {
			campoDeBatalha.mudaParaMonstroInvocado();
		} catch (ExcecaoInvocacao e) {
		}
	}
	
	public int getNumCardsMaoJogador() {
		return campoDeBatalha.getMaoJogador().size();
	}
	
	public int getNumCardsMaoComputador() {
		return campoDeBatalha.getMaoComputador().size();
	}
	
	public boolean verificaTurnoJogador() {
		if (campoDeBatalha.getTurno() instanceof TurnoJogador)
			return true;
		else
			return false;
	}
	
	public boolean verificaTurnoComputador() {
		if (campoDeBatalha.getTurno() instanceof TurnoComputador)
			return true;
		else
			return false;
	}
	
	public boolean verificaFasePrincipal1() {
		if (campoDeBatalha.getFase() instanceof FasePrincipal1)
			return true;
		else
			return false;
	}
	
	public boolean verificaFasePrincipal2() {
		if (campoDeBatalha.getFase() instanceof FasePrincipal2)
			return true;
		else 
			return false;
	}
	
	public boolean verificaFaseBatalha() {
		if (campoDeBatalha.getFase() instanceof FaseBatalha) 
			return true;
		else
			return false;
	}
	
	public boolean verificaSeLimiteDoJogadorFoiExcedido() {
		if (campoDeBatalha.getJogador().getLimite() instanceof LimiteExcedido)
			return true;
		else
			return false;
	}
	
	public boolean verificaSeLimiteDoComputadorFoiExcedido() {
		if (campoDeBatalha.getComputador().getLimite() instanceof LimiteExcedido)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		new Controle();
	}
}
