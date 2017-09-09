package modelo;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import excecoes.ExcecaoAtaque;
import excecoes.ExcecaoFase;
import excecoes.ExcecaoInvocacao;
import excecoes.ExcecaoLimite;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import interfaces.Invocacao;
import interfaces.Limite;
import interfaces.Turno;
import modelo.estados.FasePrincipal1;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import modelo.estados.estadosCard.PosicaoAtaque;
import modelo.estados.estadosCard.PosicaoDefesa;
import modelo.estados.estadosInvocacao.MonstroNaoInvocado;
import visao.InteracaoUsuario;
import visao.InterfaceGrafica;
import visao.PlaySound;

public class CampoDeBatalha {
	
	InteracaoUsuario iu;
	InterfaceGrafica ig;
	Jogador jogador;
	Computador computador;
	
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
	private Invocacao invocacao;
	private Limite limite;
	
	private Battle battle;
	private Pontuacao pontuacao;
	
	private Serializacao serializacao;
	
	private boolean primeiroTurno = true;
	
	public CampoDeBatalha(Jogador jogador, Computador computador, List<Card> arrayDeckJogador, List<CardMonstroFusao> arrayDeckFusaoJogador, List<Card> arrayDeckCPU, List<CardMonstroFusao> arrayDeckFusaoCPU) {
		this.jogador = jogador;
		this.computador = computador;
		
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
		
		this.serializacao = new Serializacao();
		this.pontuacao = this.serializacao.abreArquivo();
		this.iu = new InteracaoUsuario();
		
		battle = new Battle(this);
		//pontuacao.getInstancePontuacao();
		
		this.invocacao = new MonstroNaoInvocado(this);
//		this.turno = new TurnoJogador(this);
//		this.fase = new FasePrincipal1(this);
	}
	
	
	public void setPontosVidaJogador(int pontosVidaJogador) {
		this.pontosVidaJogador = pontosVidaJogador;
		ig.atualizaVidaJogador();
	}
	
	public void setPontosVidaComputador(int pontosVidaComputador) {
		this.pontosVidaComputador = pontosVidaComputador;
		ig.atualizaVidaComputador();
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public Computador getComputador() {
		return this.computador;
	}
	
	public void mudaParaLimiteExedidoJogador() {
		try {
			jogador.mudaParaLimiteExcedido();
		} catch (ExcecaoLimite e) {}
	}
	
	public void mudaParaLimiteNaoExcedidoJogador() {
		try {
			jogador.mudaParaLimiteNaoExcedido();
		} catch (ExcecaoLimite e) {}
	}
	
	public void mudaParaLimiteExcedidoComputador() {
		try {
			computador.mudaParaLimiteExcedido();
		} catch (ExcecaoLimite e) {}
	}
	
	public void mudaParaLimiteNaoExcedidoComputador() {
		try {
			computador.mudaParaLimiteNaoExcedido();
		} catch (ExcecaoLimite e) {}
	}
	
	public void setAlvoBattle(CardMonstro cardAlvo) {
		this.battle.setCardAlvo(cardAlvo);
	}
	
	public void setAtacanteBattle(CardMonstro cardAtacante) {
		this.battle.setCardAtacante(cardAtacante);
	}
	
	public void refreshInterfaceGrafica() {
		ig.refresh();
	}
	
	public int getVidaJogador() {
		return pontosVidaJogador; 
	}
	
	public void setVidaJogador(int pontosPerdidos) {
		this.pontosVidaJogador = pontosVidaJogador - pontosPerdidos;
		ig.atualizaVidaJogador();
		pontuacao.aumentaDanoTomado(pontosPerdidos);
		if(this.pontosVidaJogador <= 0) {
			pontuacao.aumentaNumDerrotas();
			iu.imprimeString("Fim de Jogo \n\nVocê perdeu!");
			ig.terminaJogo();
		}
	}
	
	public int getVidaComputador() {
		return pontosVidaComputador;
	}
	
	public void setVidaComputador(int pontosPerdidos) {
		this.pontosVidaComputador = pontosVidaComputador - pontosPerdidos;
		ig.atualizaVidaComputador();
		pontuacao.aumentaDanoCausado(pontosPerdidos);
		if(this.pontosVidaComputador <= 0) {
			pontuacao.aumentaNumVitorias();
			iu.imprimeString("Fim de Jogo \n\nVocê venceu!");
			ig.terminaJogo();
		}
	}
	
	public void setInicioJogo() {
		this.turno = new TurnoJogador(this);
		this.fase = new FasePrincipal1(this);
	}
	
	public void resetAtaqueCards() {
		if(cardsMonstrosJogador.size() > 0) {
			for(int i = 0; i < 6; i++) {
				if(this.cardsMonstrosJogador.get(i) != null) {
					try {
						((CardMonstro) this.cardsMonstrosJogador.get(i)).mudaParaAtaqueNaoRealizado();
					} catch (ExcecaoAtaque e) {}
				}
			}
		}
		
		if(cardsMonstrosComputador.size() > 0) {
			for(int i = 0; i < 6; i++) {
				if(this.cardsMonstrosComputador.get(i) != null) {
					try {
						((CardMonstro) this.cardsMonstrosComputador.get(i)).mudaParaAtaqueNaoRealizado();
					} catch (ExcecaoAtaque e) {}
				}
			}
		}
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
	
	public void addCardAoDeckFusao(List<CardMonstroFusao> deckFusaoJogador) {
		this.deckFusaoJogador = deckFusaoJogador;
	}
	
	public void addCardMaoJogador() {
		int indice = this.getDeckJogador().size() - 1;
		this.maoJogador.add(this.getDeckJogador().get(indice));
		this.removeCardDeckJogador(indice);
		pontuacao.aumentaNumCartasCompradas();
	}
	
	public void addCardMaoCPU() {
		int indice = this.getDeckJogador().size() - 1;
		this.maoComputador.add(this.getDeckCPU().get(indice));
		this.removeCardDeckComputador(indice);
	}
	
	public void addCardMaoJogadorNaInterfaceGrafica() {
		ig.apagaMaoJogador();
		int x = 1045;
		if(this.getMaoJogador().size() < 8)
			for(int i = 0; i < this.getMaoJogador().size(); i++) {
				ig.criaBotaoCardMaoJogador(x, 670, this.getMaoJogador().get(i), i);
				x -= 140;
			}
		ig.atualizaPilhas();
	}
	
	public void addCardMaoComputadorNaInterfaceGrafica() {
		ig.apagaMaoComputador();
		int x = 1045;
		if(this.getMaoComputador().size() < 8)
			for(int i = 0; i < this.getMaoComputador().size(); i++) {
				ig.criaBotaoCardMaoComputador(x, -60, this.getMaoComputador().get(i), i);
				x -= 140;
				ig.refresh();
			}
	}
	
	public int retornaPosicaoCardNaMaoJogador(String nomeCard) {
		for(int i = 0; i < this.maoJogador.size(); i++) {
			if(this.maoJogador.get(i).getNome().equals(nomeCard))
				return i;
		}
		return -1;
	}
	
	public int retornaPosicaoCardMonstroNoCampoJogador(String nomeCard) {
		for(int i = 0; i < 6; i++) {
			if(this.cardsMonstrosJogador.get(i) != null)
				if(this.cardsMonstrosJogador.get(i).getNome().equals(nomeCard))
					return i;
		}
		return -1;
	}
	
	public int retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(String nomeCard) {
		for(int i = 0; i < 6; i++) {
			if(this.cardsMagiaEArmadilhaJogador.get(i) != null)
				if(this.cardsMagiaEArmadilhaJogador.get(i).getNome().equals(nomeCard))
					return i;
		}
		return -1;
	}
	
	public int retornaPosicaoCardNaMaoComputador(String nomeCard){
		for(int i = 0; i < this.maoComputador.size(); i++) {
			if(this.maoComputador.get(i).getNome().equals(nomeCard))
				return i;
		}
		return -1;
	}
	
	public int retornaPosicaoCardMonstroNoCampoComputador(String nomeCard) {
		for(int i = 0; i < 6; i++) {
			if(this.cardsMonstrosComputador.get(i) != null)
				if(this.cardsMonstrosComputador.get(i).getNome().equals(nomeCard))
					return i;
		}
		return -1;
	}
	
	public int retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(String nomeCard) {
		for(int i = 0; i < 6; i++) {
			if(this.cardsMagiaEArmadilhaComputador.get(i) != null)
				if(this.cardsMagiaEArmadilhaComputador.get(i).getNome().equals(nomeCard))
					return i;
		}
		return -1;
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
	
	public void removeCardDeckComputador(int indice) {
		this.deckComputador.remove(indice);
	}
	
	public void mudaInvocacao(Invocacao invocacao) {
		this.invocacao = invocacao;
	}
	
	public Invocacao getInvocacao() {
		return this.invocacao;
	}
	
	public void mudaParaMonstroInvocado() throws ExcecaoInvocacao {
		invocacao.mudaParaMonstroInvocado();
	}
	
	public void mudaParaMonstroNaoInvocado() throws ExcecaoInvocacao {
		invocacao.mudaParaMonstroNaoInvocado();
	}

	
	public void mudaParaFasePrincipal1() throws ExcecaoFase {
		fase.mudaParaFasePrincipal1();
		pontuacao.aumentaNumRodadas();
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
			ig.removeCardMonstroJogador(i);
			pontuacao.aumentaNumCartasPerdidas();
		}
	}
	
	public void removeTodosOsCardsMonstrosNoCampoDoComputador() {
		for(int i = 0; i < this.cardsMonstrosComputador.size(); i++) {
			this.cardsMonstrosComputador.remove(i);
			ig.removeCardMonstroComputador(i);
		}
	}
	
	public Map<Integer, Card> getCardsMonstrosDoCampoDoJogador() {
		return this.cardsMonstrosJogador;
	}
	
	public Map<Integer, Card> getCardsMonstrosDoCampoDoComputador() {
		return this.cardsMonstrosComputador;
	}
	
	public List<CardMonstroFusao> getDeckFusaoJogador() {
		return this.deckFusaoJogador;
	}
	
	public List<CardMonstroFusao> getDeckFusaoComputador() {
		return this.deckFusaoComputador;
	}
	
	public void removeCardMonstroComputador(int indice) {
		if(cardsMonstrosComputador.get(indice) != null) {
			this.cardsMonstrosComputador.remove(indice);
			ig.removeCardMonstroComputador(indice);
		}
	}
	
	public void removeCardMonstroJogador(int indice) {
		if(cardsMonstrosJogador.get(indice) != null) {
			this.cardsMonstrosJogador.remove(indice);
			ig.removeCardMonstroJogador(indice);
			pontuacao.aumentaNumCartasPerdidas();
		}
	}
	
	public void removeCardMagiaEArmadilhaJogador(int indice) {
		this.cardsMagiaEArmadilhaJogador.remove(indice);
		pontuacao.aumentaNumCartasPerdidas();
	}
	
	public void removeCardMagiaEArmadilhaComputador(int indice) {
		this.cardsMagiaEArmadilhaComputador.remove(indice);
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
		pontuacao.aumentaNumCartasPerdidas();
	}
	
	public void adicionaCardDaMaoDoJogadorAoCampo(int indice, int xMao, int yMao, Card card) {
		for(int i = 0; i < 5; i++) {
			if(card instanceof CardMonstro) {
				if(this.cardsMonstrosJogador.get(i) == null) {
					coordenadasCardMonstroJogador(indice, xMao, yMao, card, i);
					break;
				}
			}
			
			if(card instanceof CardMagia || card instanceof CardArmadilha) {
				if(this.cardsMagiaEArmadilhaJogador.get(i) == null) {
					coordenadasCardMagiaOuArmadilhaJogador(indice, xMao, yMao, i);
					break;
				}
			}
		}
	}

	private void coordenadasCardMagiaOuArmadilhaJogador(int indice, int xMao, int yMao, int i) {
		this.cardsMagiaEArmadilhaJogador.put(i, this.maoJogador.get(indice));
		ig.criaBotaoCardMagiaEArmadilhaJogador(485 + (i*140), 520, this.cardsMagiaEArmadilhaJogador.get(i), xMao, yMao);
		this.maoJogador.remove(indice);
		pontuacao.aumentaNumCartasJogadas();
	}

	private void coordenadasCardMonstroJogador(int indice, int xMao, int yMao, Card card, int i) {
		this.cardsMonstrosJogador.put(i, this.maoJogador.get(indice));
		
		if(((CardMonstro) card).getPosicao() instanceof PosicaoAtaque)
			ig.criaBotaoCardMonstroAtaqueJogador(485 + (i*140), 380, this.cardsMonstrosJogador.get(i), xMao, yMao);
		
		if(((CardMonstro) card).getPosicao() instanceof PosicaoDefesa)
			ig.criaBotaoCardMonstroDefesaJogador(460 + (i*140), 400, this.cardsMonstrosJogador.get(i), xMao, yMao);
		
		this.maoJogador.remove(indice);
		pontuacao.aumentaNumCartasJogadas();
	}
	
	public void adicionaCardDaMaoDoComputadorAoCampo(int indice, int xMao, int yMao, Card card) {
		for(int i = 0; i < 5; i++) {
			if(card instanceof CardMonstro) {
				if(this.cardsMonstrosComputador.get(i) == null) {
					coordenadasCardMonstroComputador(indice, xMao, yMao, card, i);
					break;
				}
			}
			
			if(card instanceof CardMagia || card instanceof CardArmadilha) {
				if(this.cardsMagiaEArmadilhaComputador.get(i) == null) {
					coordenadasCardMagiaOuArmadilhaComputador(indice, xMao, yMao, i);
					break;
				}
			}
		}
	}

	private void coordenadasCardMagiaOuArmadilhaComputador(int indice, int xMao, int yMao, int i) {
		this.cardsMagiaEArmadilhaComputador.put(i, this.maoComputador.get(indice));
		ig.criaBotaoCardMagiaEArmadilhaComputador(485 + (i*140), 90, this.cardsMagiaEArmadilhaComputador.get(i), xMao, yMao);
		this.maoComputador.remove(indice);
	}

	private void coordenadasCardMonstroComputador(int indice, int xMao, int yMao, Card card, int i) {
		this.cardsMonstrosComputador.put(i, this.maoComputador.get(indice));
		
		if(((CardMonstro) card).getPosicao() instanceof PosicaoAtaque)
			ig.criaBotaoCardMonstroAtaqueComputador(485 + (i*140), 230, this.cardsMonstrosComputador.get(i), xMao, yMao);
		
		if(((CardMonstro) card).getPosicao() instanceof PosicaoDefesa)
			ig.criaBotaoCardMonstroDefesaComputador(460 + (i*140), 250, this.cardsMonstrosComputador.get(i), xMao, yMao);
		
		this.maoComputador.remove(indice);
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

	public void setCardDisabledJogador(Card card) {
		int i = this.retornaPosicaoCardMonstroNoCampoJogador(card.getNome());
		if(ig.getListaButtonsCardsMonstrosJogador().get(i) != null)
			ig.getListaButtonsCardsMonstrosJogador().get(i).setEnabled(false);
	}
	
	public void setCardEnabledJogador() {
		for(int k = 0; k < this.cardsMonstrosJogador.size(); k++) {
			if(ig.getListaButtonsCardsMonstrosJogador().get(k) != null)
				ig.getListaButtonsCardsMonstrosJogador().get(k).setEnabled(true);
		}
	}
	
	public void setCardDisabledComputador(Card card) {
		int i = this.retornaPosicaoCardMonstroNoCampoComputador(card.getNome());
		if(ig.getListaButtonsCardsMonstrosComputador().get(i) != null)
			ig.getListaButtonsCardsMonstrosComputador().get(i).setEnabled(false);
	}
	
	public void setCardEnabledComputador() {
		for(int k = 0; k < this.cardsMonstrosComputador.size(); k++) {
			if(ig.getListaButtonsCardsMonstrosComputador().get(k) != null)
				ig.getListaButtonsCardsMonstrosComputador().get(k).setEnabled(true);
		}
	}
	
	public void destroiCardJogador(CardMonstro card) {
		int posicao = this.retornaPosicaoCardMonstroNoCampoJogador(card.getNome());
		this.removeCardMonstroJogador(posicao);
	}
	
	
	public void destroiCardComputador(CardMonstro card) {
		int posicao = this.retornaPosicaoCardMonstroNoCampoComputador(card.getNome());
		this.removeCardMonstroComputador(posicao);
	}
	
	public void destroiCardMagiaEArmadilhaJogador(Card card) {
		int posicao = this.retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(card.getNome());
		this.removeCardMagiaEArmadilhaJogador(posicao);
		ig.removeCardMagiaEArmadilhaJogador(posicao);
	}
	
	public void destroiCardMagiaEArmadilhaComputador(Card card) {
		int posicao = this.retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(card.getNome());
		this.removeCardMagiaEArmadilhaComputador(posicao);
		ig.removeCardMagiaEArmadilhaComputador(posicao);
	}
	
	public String retornaEstatisticas() {
		return "Vitórias: " + pontuacao.getNumVitorias() + "\n"
				+ "Derrotas: " + pontuacao.getNumDerrotdas() + "\n\n"
				+ "Dano Causado: " + pontuacao.getDanoCausado() + "\n"
				+ "Dano Tomado: " + pontuacao.getDanoTomado() + "\n\n" 
				+ "Cartas Jogadas: " + pontuacao.getNumCartasJogadas() + "\n"
				+ "Cartas Perdidas: " + pontuacao.getNumCartasPerdidas() + "\n"
				+ "Cartas Compradas: " + pontuacao.getNumCartasCompradas() + "\n\n"
				+ "Número de Rodadas Jogadas: " + pontuacao.getNumRodadas();
	}
	
	public void salvaArquivo(){
		serializacao.salvaArquivo(pontuacao);
	}

}
