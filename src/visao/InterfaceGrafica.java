package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controle.Controle;
import excecoes.ExcecaoAtaque;
import modelo.Card;
import modelo.CardArmadilha;
import modelo.CardMagia;
import modelo.CardMonstro;
import modelo.CardMonstroFusao;
import modelo.estados.estadosCard.FaceParaBaixo;
import modelo.estados.estadosCard.estadosCardMonstro.AtaqueNaoRealizado;
import modelo.estados.estadosInvocacao.MonstroNaoInvocado;

public class InterfaceGrafica extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton botaoFasePrincipal1, botaoFaseBatalha, botaoFasePrincipal2, botaoFaseFinal, botaoMenu, botaoCardMonstroAtaque, botaoCardMonstroDefesa, botaoCardMagiaEArmadilha, botaoIniciar, botaoVoltarParaOJogo, botaoEstatisticas, cardMao, botaoDeckFusao, botaoCardFusao;
	private JLabel labelCard, verso, turno, fase, descricaoCard, background, versoCemiterioJogador, versoCemiterioComputador, imagemFundo;
	private JPanel panelCardJogador, panelCardComputador, painelJanela, painelInicial, painelCardMonstroJogador, painelCardMonstroComputador, painelCardMagiaEArmadilhaJogador, painelCardMagiaEArmadilhaComputador, painelDeckFusao;
	
	private List<JPanel> listaPaineisCardsMaoJogador, listaPaineisCardsMaoComputador;
	private Map<Integer, JPanel> listaPaineisCardsMonstrosJogador, listaPaineisCardsMonstrosComputador, listaPaineisCardsMagiaEArmadilhaJogador, listaPaineisCardsMagiaEArmadilhaComputador;
	private Map<Integer, JButton> listaButtonsCardsMonstrosJogador, listaButtonsCardsMonstrosComputador;
	
	private int posicaoX = 20;
	private int draw5Cards = 0;
	private boolean ativaBotaoDeckFusao = false;
	
	private PilhaJogador pilhaJogador;
	private PilhaComputador pilhaComputador;
	private BackgroundSound somDeFundo;
	private Counter counterJogador, counterComputador;
	private Controle controle;
	private Card card;
	private JanelaPosicaoCard janelaPosicaoCard;
	private JanelaDescartarCard janelaDescartarCard;
	
	public InterfaceGrafica() {
		super("Yu-Gi-Oh!");
		setLayout(null);
		
		painelInicial = new JPanel();
		painelJanela = new JPanel();
		janelaPosicaoCard = new JanelaPosicaoCard();
		janelaDescartarCard = new JanelaDescartarCard();
		listaPaineisCardsMaoJogador = new ArrayList<>();
		listaPaineisCardsMaoComputador = new ArrayList<>();
		listaPaineisCardsMonstrosJogador = new HashMap<>();
		listaPaineisCardsMonstrosComputador = new HashMap<>();
		listaPaineisCardsMagiaEArmadilhaJogador = new HashMap<>();
		listaPaineisCardsMagiaEArmadilhaComputador = new HashMap<>();
		listaButtonsCardsMonstrosJogador = new HashMap<>();
		listaButtonsCardsMonstrosComputador = new HashMap<>();
		labelCard = new JLabel();
		descricaoCard = new JLabel();
		botaoDeckFusao = new JButton();
		background = new JLabel();
		imagemFundo = new JLabel();
			
		botaoFasePrincipal1 = new JButton("Main 1");
		botaoFaseBatalha = new JButton("Battle");
		botaoFasePrincipal2 = new JButton("Main 2");
		botaoFaseFinal = new JButton("Finish");
		
		criaBotaoFaseBatalha();
		criaBotaoFasePrincipal2();
		criaBotaoTerminarJogada();
		
		criaLabelTurno();
		criaLabelFase();
		
		criaPilhas();	
		criaDecksComputador();
		
		criaBotaoVoltar();
		criaPainelInicial();
		criaBotaoIniciarJogo();
		criaBotaoEstatisticas();
		setBackgroundPainelInicial();
		
		criaCounters();

		criaJanela();
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}
	
	private void criaCounters() {
		counterJogador = new Counter(0, 630);
		painelJanela.add(counterJogador);
		
		counterComputador = new Counter(0, 15);
		painelJanela.add(counterComputador);
		criaBackground();
	}
	
	public void criaBotaoCardMonstroAtaqueJogador(int x, int y, Card card, int xMao, int yMao) {
		try {
			((CardMonstro) card).mudaParaAtaqueRealizado();
		} catch (ExcecaoAtaque e) {}
		painelCardMonstroJogador = new JPanel();
		botaoCardMonstroAtaque = new JButton();
		botaoCardMonstroAtaque.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroAtaque.setSize(92, 134);
		botaoCardMonstroAtaque.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				efeitoCardMonstroAtaqueJogadorNoTurnoJogador(card);
				efeitoCardMonstroAtaqueJogadorNoTurnoComputador(card);
			}

			private void efeitoCardMonstroAtaqueJogadorNoTurnoJogador(Card card) {
				if(controle.verificaTurnoJogador() && controle.verificaFaseBatalha() && card instanceof CardMonstro && ((CardMonstro) card).getAtaque() instanceof AtaqueNaoRealizado) {
					controle.setCardDisabledJogador(card);
					controle.setAtacanteBattle((CardMonstro) card); 
				}
			}

			private void efeitoCardMonstroAtaqueJogadorNoTurnoComputador(Card card) {
				if(controle.verificaTurnoComputador() && controle.verificaFaseBatalha() && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					controle.setAlvoBattle((CardMonstro) card); 
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});

		painelCardMonstroJogador.add(botaoCardMonstroAtaque);

		painelCardMonstroJogador.setLayout(null);
		painelCardMonstroJogador.setSize(92, 134);
		painelCardMonstroJogador.setLocation(xMao, yMao);
		painelCardMonstroJogador.setVisible(true);
		painelJanela.add(painelCardMonstroJogador);
		listaPaineisCardsMonstrosJogador.put(controle.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), painelCardMonstroJogador);
		listaButtonsCardsMonstrosJogador.put(controle.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), botaoCardMonstroAtaque);
		new Movimento(x, y, painelCardMonstroJogador);
		criaBackground();
		
	}
	
	public void criaBotaoCardMonstroDefesaJogador(int x, int y, Card card, int xMao, int yMao) {
		try {
			((CardMonstro) card).mudaParaAtaqueRealizado();
		} catch (ExcecaoAtaque e1) {}
		
		painelCardMonstroJogador = new JPanel();
		botaoCardMonstroDefesa = new JButton();
		botaoCardMonstroDefesa.setSize(134, 92);
		
		verificaCardDefesaSeEstaComAFaceParaBaixo(card);
		botaoCardMonstroDefesa.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(controle.verificaTurnoComputador() && controle.verificaFaseBatalha() && card instanceof CardMonstro) {
					controle.setAlvoBattle((CardMonstro) card);
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});
	
		painelCardMonstroJogador.add(botaoCardMonstroDefesa);
		
		painelCardMonstroJogador.setLayout(null);
		painelCardMonstroJogador.setSize(134, 92);
		painelCardMonstroJogador.setLocation(xMao, yMao);
		painelCardMonstroJogador.setVisible(true);
		painelJanela.add(painelCardMonstroJogador);
		listaPaineisCardsMonstrosJogador.put(controle.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), painelCardMonstroJogador);
		
		new Movimento(x, y, painelCardMonstroJogador);
		criaBackground();
	}

	private void verificaCardDefesaSeEstaComAFaceParaBaixo(Card card) {
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + "Verso2.png"));
		else
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + card.getNome() + ".png"));
	}
	
	public void criaBotaoCardMagiaEArmadilhaJogador(int x, int y, Card card, int xMao, int yMao) {
		painelCardMagiaEArmadilhaJogador = new JPanel();
		botaoCardMagiaEArmadilha = new JButton();
		botaoCardMagiaEArmadilha.setSize(92, 134);
		verificaCardMagiaEArmadilhaSeEstaComAFaceParaBaixo(card);
		botaoCardMagiaEArmadilha.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
//				if(controle.getTurno() instanceof TurnoJogador && (controle.getFase() instanceof FasePrincipal1 || controle.getFase() instanceof FasePrincipal2)) {
//					new EfeitoCardsMagia(campoDeBatalha, card.getNome());
//					campoDeBatalha.destroiCardMagiaEArmadilhaJogador(card);
//				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});

		painelCardMagiaEArmadilhaJogador.add(botaoCardMagiaEArmadilha);
		painelCardMagiaEArmadilhaJogador.setLayout(null);
		painelCardMagiaEArmadilhaJogador.setSize(92, 134);
		painelCardMagiaEArmadilhaJogador.setLocation(xMao, yMao);
		painelCardMagiaEArmadilhaJogador.setVisible(true);
		painelJanela.add(painelCardMagiaEArmadilhaJogador);
		
		listaPaineisCardsMagiaEArmadilhaJogador.put(controle.retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(card.getNome()), painelCardMagiaEArmadilhaJogador);
		new Movimento(x, y, painelCardMagiaEArmadilhaJogador);
		criaBackground();
	}

	private void verificaCardMagiaEArmadilhaSeEstaComAFaceParaBaixo(Card card) {
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		else
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
	}
	
	public void criaBotaoCardMonstroAtaqueComputador(int x, int y, Card card, int xMao, int yMao) {
		try {
			((CardMonstro) card).mudaParaAtaqueRealizado();
		} catch (ExcecaoAtaque e1) {}
		
		painelCardMonstroComputador = new JPanel();
		botaoCardMonstroAtaque = new JButton();
		botaoCardMonstroAtaque.setSize(92, 134);
		botaoCardMonstroAtaque.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroAtaque.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				controle.setCardEnabledComputador();
				efeitoCardMonstroAtaqueComputadorNoTurnoDoComputador(card);
				efeitoCardMonstroAtaqueComputadorNoTurnoDoJogador(card);
			}

			private void efeitoCardMonstroAtaqueComputadorNoTurnoDoJogador(Card card) {
				if(controle.verificaTurnoComputador() && controle.verificaFaseBatalha() && card instanceof CardMonstro && ((CardMonstro) card).getAtaque() instanceof AtaqueNaoRealizado) {
					controle.setCardDisabledComputador(card);
					controle.setAtacanteBattle((CardMonstro) card); 
				}
			}

			private void efeitoCardMonstroAtaqueComputadorNoTurnoDoComputador(Card card) {
				if(controle.verificaTurnoJogador() && controle.verificaFaseBatalha() && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					controle.setAlvoBattle((CardMonstro) card); 
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});

		painelCardMonstroComputador.add(botaoCardMonstroAtaque);
		painelCardMonstroComputador.setLayout(null);
		painelCardMonstroComputador.setSize(92, 134);
		painelCardMonstroComputador.setLocation(xMao + 140, yMao + 35);
		painelCardMonstroComputador.setVisible(true);
		painelJanela.add(painelCardMonstroComputador);
		
		listaPaineisCardsMonstrosComputador.put(controle.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), painelCardMonstroComputador);
		listaButtonsCardsMonstrosComputador.put(controle.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), botaoCardMonstroAtaque);
		new Movimento(x, y, painelCardMonstroComputador);
		criaBackground();
	}
	
	public void criaBotaoCardMonstroDefesaComputador(int x, int y, Card card, int xMao, int yMao) {
		
		try {
			((CardMonstro) card).mudaParaAtaqueRealizado();
		} catch (ExcecaoAtaque e1) {}
		painelCardMonstroComputador = new JPanel();
		botaoCardMonstroDefesa = new JButton();
		
		botaoCardMonstroDefesa.setSize(134, 92);
		verificaCardDefesaSeEstaComAFaceParaBaixo(card);
		botaoCardMonstroDefesa.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(controle.verificaTurnoJogador() && controle.verificaFaseBatalha() && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					controle.setAlvoBattle((CardMonstro) card); 
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		painelCardMonstroComputador.add(botaoCardMonstroDefesa);
		painelCardMonstroComputador.setLayout(null);
		painelCardMonstroComputador.setSize(134, 92);
		painelCardMonstroComputador.setLocation(xMao, yMao);
		painelCardMonstroComputador.setVisible(true);
		painelJanela.add(painelCardMonstroComputador);
		
		listaPaineisCardsMonstrosComputador.put(controle.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), painelCardMonstroComputador);
		new Movimento(x, y, painelCardMonstroComputador);
		criaBackground();
	}
	
	public void criaBotaoCardMagiaEArmadilhaComputador(int x, int y, Card card, int xMao, int yMao) {
		painelCardMagiaEArmadilhaComputador = new JPanel();
		botaoCardMagiaEArmadilha = new JButton();
		
		botaoCardMagiaEArmadilha.setSize(92, 134);
		verificaCardMagiaEArmadilhaSeEstaComAFaceParaBaixo(card);
		botaoCardMagiaEArmadilha.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
//				if(controle.getTurno() instanceof TurnoComputador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2)) {
//
//					new EfeitoCardsMagia(campoDeBatalha, card.getNome());
//					campoDeBatalha.destroiCardMagiaEArmadilhaComputador(card);
//				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});

		painelCardMagiaEArmadilhaComputador.add(botaoCardMagiaEArmadilha);
		painelCardMagiaEArmadilhaComputador.setLayout(null);
		painelCardMagiaEArmadilhaComputador.setSize(92, 134);
		painelCardMagiaEArmadilhaComputador.setLocation(xMao -4, yMao - 130);
		painelCardMagiaEArmadilhaComputador.setVisible(true);
		painelJanela.add(painelCardMagiaEArmadilhaComputador);
		
		listaPaineisCardsMagiaEArmadilhaComputador.put(controle.retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(card.getNome()), painelCardMagiaEArmadilhaComputador);
		new Movimento(x, y, painelCardMagiaEArmadilhaComputador);
		criaBackground();
	}

	public void apagaMaoJogador() {
		for(int i = 0; i < listaPaineisCardsMaoJogador.size(); i++) {
			listaPaineisCardsMaoJogador.get(i).setVisible(false);
			getContentPane().remove(listaPaineisCardsMaoJogador.get(i));
		}
	}
	
	public void apagaMaoComputador() {
		for(int i = 0; i < listaPaineisCardsMaoComputador.size(); i++) {
			listaPaineisCardsMaoComputador.get(i).setVisible(false);
			getContentPane().remove(listaPaineisCardsMaoComputador.get(i));
		}
	}
	
	public void removeCardMagiaEArmadilhaJogador(int indice) {
		this.listaPaineisCardsMagiaEArmadilhaJogador.get(indice).setVisible(false);
		painelJanela.remove(this.listaPaineisCardsMagiaEArmadilhaJogador.get(indice));
		this.listaButtonsCardsMonstrosJogador.remove(indice);
	}
	
	public void removeCardMagiaEArmadilhaComputador(int indice) {
		this.listaPaineisCardsMagiaEArmadilhaComputador.get(indice).setVisible(false);
		painelJanela.remove(this.listaPaineisCardsMagiaEArmadilhaComputador.get(indice));
		this.listaButtonsCardsMonstrosComputador.remove(indice);
	}
	
	public void removeCardMonstroJogador(int indice) {
		this.listaPaineisCardsMonstrosJogador.get(indice).setVisible(false);
		painelJanela.remove(this.listaPaineisCardsMonstrosJogador.get(indice));
		this.listaPaineisCardsMonstrosJogador.remove(indice);
	}
	
	public void removeCardMonstroComputador(int indice) {
		this.listaPaineisCardsMonstrosComputador.get(indice).setVisible(false);
		painelJanela.remove(this.listaPaineisCardsMonstrosComputador.get(indice));
		this.listaPaineisCardsMonstrosComputador.remove(indice);
	}

	public void criaBotaoCardMaoJogador(int x, int y, Card card, int posicao) {
		draw5Cards++;
		panelCardJogador = new JPanel();
		this.card = card;
		cardMao = new JButton();
		cardMao.setSize(92, 134);
		cardMao.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + this.card.getNome() + ".png"));
		cardMao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaDescartarCard.dispose();
				
				verificaCondicaoParaInvocacaoCardMonstroJogador(x, y, card);
				verificaCondicaoParaInvocacaoCardMagiaEArmadilhaJogador(x, y, card);
				
				verificaLimiteDeCardsNaMao();
			}

			private void verificaCondicaoParaInvocacaoCardMagiaEArmadilhaJogador(int x, int y, Card card) {
				if(controle.verificaTurnoJogador() && (controle.verificaFasePrincipal1() || controle.verificaFasePrincipal2()) && (card instanceof CardMagia || card instanceof CardArmadilha)) {
					janelaPosicaoCard.dispose();
					verificaLimiteDeCardsNaMao();
					
					for(int i = 0; i < listaPaineisCardsMaoJogador.size(); i++) {
						listaPaineisCardsMaoJogador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoJogador.get(i));
					}
					
					atualizaJanelaDescartarCard(x, y, controle, card);
					controle.addCardMaoJogadorNaInterfaceGrafica();
					verificaLimiteDeCardsNaMao();
				}
			}

			private void verificaCondicaoParaInvocacaoCardMonstroJogador(int x, int y, Card card) {
				if(controle.verificaTurnoJogador() && (controle.verificaFasePrincipal1() || controle.verificaFasePrincipal2()) && card instanceof CardMonstro && controle.getInvocacao() instanceof MonstroNaoInvocado && (controle.getNumCardsMonstrosDoCampoDoJogador() < 5 || controle.verificaSeLimiteDoJogadorFoiExcedido())) {
					for(int i = 0; i < listaPaineisCardsMaoJogador.size(); i++) {
						listaPaineisCardsMaoJogador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoJogador.get(i));
					}
					
					atualizaJanelaPosicaoCard(x, y, controle, card);
					controle.addCardMaoJogadorNaInterfaceGrafica();
					controle.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimiteDeCardsNaMao();
				}
			}

		});
		
		cardMao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}	
		});
		panelCardJogador.setLayout(null);
		panelCardJogador.setSize(92, 134);
		panelCardJogador.setLocation(1170, 520);
		panelCardJogador.setVisible(true);
		panelCardJogador.add(cardMao);
		listaPaineisCardsMaoJogador.add(panelCardJogador);
		verificaCompraDos5CardsDoInicioDoJogoJogador(x, y);
		painelJanela.add(panelCardJogador);
		criaBackground();
	}

	private void verificaCompraDos5CardsDoInicioDoJogoJogador(int x, int y) {
		if(draw5Cards < 7)
			new Movimento(x, y, panelCardJogador);
		else
			panelCardJogador.setLocation(x, y);
	}
	
	private void atualizaJanelaDescartarCard(int x, int y, Controle controle, Card card) {
		janelaDescartarCard.dispose();
		janelaDescartarCard = new JanelaDescartarCard();
		janelaDescartarCard.iniciaJanela(x, y - 40, controle, card);
		criaBackground();
	}
	
	private void atualizaJanelaPosicaoCard(int x, int y, Controle controle, Card card) {
		janelaPosicaoCard.dispose();
		janelaPosicaoCard = new JanelaPosicaoCard();
		janelaPosicaoCard.iniciaJanela(x - 25, y - 75, controle, card);
		criaBackground();
	}
	
	private void verificaLimiteDeCardsNaMao() {
		if(controle.getNumCardsMaoJogador() < 6)
			controle.mudaParaLimiteNaoExcedidoJogador();
		if(controle.getNumCardsMaoComputador() < 6)
			controle.mudaParaLimiteNaoExcedidoComputador();
		criaBackground();
	}

	public void criaBotaoCardMaoComputador(int x, int y, Card card, int posicao) {
		panelCardComputador = new JPanel();
		this.card = card;
		cardMao = new JButton();
		cardMao.setSize(92, 134);
		cardMao.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		cardMao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaDescartarCard.dispose();
				verificaCondicaoParaInvocacaoCardMonstroComputador(x, y, card);
				verificaCondicaoParaInvocacaoCardMagiaEArmadilhaComputador(x, y, card);
				verificaLimiteDeCardsNaMao();
			
			}

			private void verificaCondicaoParaInvocacaoCardMagiaEArmadilhaComputador(int x, int y, Card card) {
				if(controle.verificaTurnoComputador() && (controle.verificaFasePrincipal1() || controle.verificaFasePrincipal2()) && (card instanceof CardMagia || card instanceof CardArmadilha)) {
					verificaLimiteDeCardsNaMao();
					janelaPosicaoCard.dispose();
						
					for(int i = 0; i < listaPaineisCardsMaoComputador.size(); i++) {
						listaPaineisCardsMaoComputador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoComputador.get(i));
					}
						
					//new JanelaDescartarCard(x + 2, y + 170, campoDeBatalha, card);
					atualizaJanelaDescartarCard(x + 2, y + 200, controle, card);
					controle.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimiteDeCardsNaMao();
				}
			}

			private void verificaCondicaoParaInvocacaoCardMonstroComputador(int x, int y, Card card) {
				if(controle.verificaTurnoComputador() && (controle.verificaFasePrincipal1() || controle.verificaFasePrincipal2()) && card instanceof CardMonstro && controle.getInvocacao() instanceof MonstroNaoInvocado && (controle.getNumCardsMonstrosDoCampoDoComputador() < 5 || controle.verificaSeLimiteDoComputadorFoiExcedido())) {
					
					for(int i = 0; i < listaPaineisCardsMaoComputador.size(); i++) {
						listaPaineisCardsMaoComputador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoComputador.get(i));
					}
					
					atualizaJanelaPosicaoCard(x, y + 250, controle, card);

					controle.addCardMaoJogadorNaInterfaceGrafica();
					controle.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimiteDeCardsNaMao();
				}
			}
		});
		cardMao.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		panelCardComputador.setLayout(null);
		panelCardComputador.setSize(92, 134);
		panelCardComputador.setLocation(350, 90);
		panelCardComputador.setVisible(true);
		panelCardComputador.add(cardMao);
		listaPaineisCardsMaoComputador.add(panelCardComputador);
		
		painelJanela.add(panelCardComputador);
		verificaCompraDos5CardsDoInicioDoJogoComputador(x, y);
		criaBackground();
		
	}

	private void verificaCompraDos5CardsDoInicioDoJogoComputador(int x, int y) {
		if(draw5Cards < 7)
			new Movimento(x, y, panelCardComputador);
		else
			panelCardComputador.setLocation(x, y);
	}

	private void criaBotaoDeckFusao() {
		botaoDeckFusao.setVisible(false);
		getContentPane().remove(botaoDeckFusao);
		
		botaoDeckFusao = new JButton();
		botaoDeckFusao.setSize(92, 134);
		botaoDeckFusao.setVisible(true);
		botaoDeckFusao.setLocation(345, 520);
		botaoDeckFusao.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		botaoDeckFusao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!ativaBotaoDeckFusao) {
					criaTodosOsCardsDoDeckFusao();
					ativaBotaoDeckFusao = true;
				}
				else {
					painelDeckFusao.setVisible(false);
					getContentPane().remove(painelDeckFusao);
					ativaBotaoDeckFusao = false;
				}
					
			}
			
		});
		painelJanela.add(botaoDeckFusao);
		criaBackground();
	}

	private void criaDecksComputador() {
		criaVersoCard(1170, 90); // deck fusão computador
	}

	void criaImagemCard(String nomeCard) {
		labelCard.setSize(176, 256);
		labelCard.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsVisualizacao" + File.separator + nomeCard + ".png"));
		labelCard.setLocation(35, 150);
		painelJanela.add(labelCard);
		criaBackground();
	}
	
	void criaDescricaoCard(Card card) {
		descricaoCard.setText("<html><font color = FFFFFF>" + card.getNome() + "<br><br>" + card.getDescricao() + "</font></html>");
		descricaoCard.setSize(275, 200);
		descricaoCard.setLocation(40, 450);
		painelJanela.add(descricaoCard);
		criaBackground();
	}
	
	private void criaVersoCard(int x, int y) {
		verso = new JLabel();
		verso.setSize(92, 134);
		verso.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		verso.setLocation(x, y);
		criaBackground();
	}
	
	private void criaPilhas() {
//		pilhaJogador = new PilhaJogador(campoDeBatalha.getDeckJogador().size());
	//	int num = controle.getDeckJogador();
		pilhaJogador = new PilhaJogador(50);
		painelJanela.add(pilhaJogador);
		
//		pilhaComputador = new PilhaComputador(campoDeBatalha.getDeckComputador().size());
		pilhaComputador = new PilhaComputador(50);
		painelJanela.add(pilhaComputador);
		
		versoCemiterioJogador = new JLabel();
		versoCemiterioJogador.setSize(92, 134);
		versoCemiterioJogador.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioJogador.setLocation(1170, 380);
		painelJanela.add(versoCemiterioJogador);
		
		versoCemiterioComputador = new JLabel();
		versoCemiterioComputador.setSize(92, 134);
		versoCemiterioComputador.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioComputador.setLocation(350, 230);
		criaBackground();
	
	}
	
	public void atualizaPilhas() {		
		pilhaJogador();
		pilhaComputador();
		
		criaBackground();
	}

	private void pilhaComputador() {
		versoCemiterioComputador.setVisible(false);
		painelJanela.remove(versoCemiterioComputador);
		
		pilhaComputador.setVisible(false);
		painelJanela.remove(pilhaComputador);
		
		pilhaComputador = new PilhaComputador(controle.getDeckComputador().size());
		painelJanela.add(pilhaComputador);
		
		versoCemiterioComputador = new JLabel();
		versoCemiterioComputador.setSize(92, 134);
		versoCemiterioComputador.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioComputador.setLocation(370, 230);
		painelJanela.add(versoCemiterioComputador);
	}

	private void pilhaJogador() {
		versoCemiterioJogador.setVisible(false);
		painelJanela.remove(versoCemiterioJogador);
		
		pilhaJogador.setVisible(false);
		painelJanela.remove(pilhaJogador);
		
		pilhaJogador = new PilhaJogador(controle.getDeckJogador());
		painelJanela.add(pilhaJogador);
		
		criaBotaoDeckFusao();

		versoCemiterioJogador = new JLabel();
		versoCemiterioJogador.setVisible(true);
		versoCemiterioJogador.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioJogador.setBounds(1170, 380, 92, 134);
		painelJanela.add(versoCemiterioJogador);
	}
	
	private void criaBotaoFaseBatalha() {
		botaoFaseBatalha = new JButton("Battle");
		botaoFaseBatalha.setSize(80, 30);;
		botaoFaseBatalha.setLocation(250, 280);
		botaoFaseBatalha.setVisible(true);
		botaoFaseBatalha.setEnabled(true);
		botaoFaseBatalha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controle.mudaParaFaseBatalha();
				String textoFase = verificaFaseString();
				fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
				botaoFasePrincipal1.setEnabled(false);
				botaoFaseBatalha.setEnabled(false);
				botaoFasePrincipal2.setEnabled(true);
				botaoFaseFinal.setEnabled(false);
			}
		});
		
		painelJanela.add(botaoFaseBatalha);
		criaBackground();
	}
	
	private void criaBotaoFasePrincipal2() {
		botaoFasePrincipal2 = new JButton("Main 2");
		botaoFasePrincipal2.setSize(80, 30);
		botaoFasePrincipal2.setLocation(250, 320);
		botaoFasePrincipal2.setVisible(true);
		botaoFasePrincipal2.setEnabled(false);
		botaoFasePrincipal2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controle.mudaParaFasePrincipal2();
				String textoFase = verificaFaseString();
				fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
				botaoFaseFinal.setEnabled(true);
				botaoFasePrincipal2.setEnabled(false);
			}
		});
		painelJanela.add(botaoFasePrincipal2);
		criaBackground();
	}

	private void criaBotaoTerminarJogada() {
		botaoFaseFinal = new JButton("Finish");
		botaoFaseFinal.setSize(80, 30);
		botaoFaseFinal.setLocation(250, 360);
		botaoFaseFinal.setVisible(true);
		botaoFaseFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				verificaLimiteDeCardsNaMao();
				
				verificaSeOLimiteFoiExcedidoJogador();
				verificaSeOLimiteFoiExcedidoComputador();
					
				verificaCondicoesParaTerminarAJogada();
				
				controle.addCardMaoJogadorNaInterfaceGrafica();
				controle.addCardMaoComputadorNaInterfaceGrafica();
			}

			private void verificaCondicoesParaTerminarAJogada() {
				if(!controle.verificaSeLimiteDoComputadorFoiExcedido() && !controle.verificaSeLimiteDoJogadorFoiExcedido() && (controle.verificaFasePrincipal1() || controle.verificaFasePrincipal2())) {
						controle.trocaTurno();
						controle.mudaParaFasePrincipal1();

						String textoFase = verificaFaseString();
						String textoTurno = verificaTurnoString();
						fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
						turno.setText("<html><font color = FFFFFF>" + textoTurno + "</font></html>");
						
						botaoFaseBatalha.setEnabled(true);
						botaoFasePrincipal2.setEnabled(false);
				}
			}

			private void verificaSeOLimiteFoiExcedidoComputador() {
				if(controle.verificaTurnoComputador()) {
					if(controle.verificaSeLimiteDoComputadorFoiExcedido())
						JOptionPane.showMessageDialog(null, "Descarte uma carta!");
				}
			}

			private void verificaSeOLimiteFoiExcedidoJogador() {
				if(controle.verificaTurnoJogador()) {
					if(controle.verificaSeLimiteDoJogadorFoiExcedido())
						JOptionPane.showMessageDialog(null, "Descarte uma carta!");
				}
			}
		});

		painelJanela.add(botaoFaseFinal);
		criaBackground();
	}
	
	private void criaLabelTurno() {
		turno = new JLabel();
		turno.setSize(300, 50);
		turno.setLocation(1160, 40);
		turno.setVisible(true);
		painelJanela.add(turno);
		criaBackground();
	}
	
	private void criaLabelFase() {
		fase = new JLabel();
		fase.setSize(300, 50);
		fase.setLocation(1160, 20);
		fase.setVisible(true);
		painelJanela.add(fase);
		criaBackground();
	}
	
	private void criaBotaoVoltar() {
		botaoMenu = new JButton("Voltar");
		botaoMenu.setSize(100, 30);
		botaoMenu.setLocation(1170, 680);
		botaoMenu.setVisible(true);
		botaoMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltaParaPainelInicial();
			}
		});
		painelJanela.add(botaoMenu);
		criaBackground();
	}

	private void criaPainelJanela() {
		painelJanela.setSize(1300, 1800);
		painelJanela.setLayout(null);
		painelJanela.setVisible(true);
		painelJanela.setOpaque(false);
		painelJanela.setLocation(0, 0);
		getContentPane().add(painelJanela);
		criaBackground();
	}

	public void voltaParaPainelInicial() {
		painelJanela.setVisible(false);
		painelInicial.remove(botaoIniciar);
		painelInicial.remove(background);
		getContentPane().remove(painelInicial);
		
		criaPainelInicial();
		criaBotaoVoltarParaOJogo();
		criaBotaoSalvar();
		criaBotaoEstatisticas();
		setBackgroundPainelInicial();
		criaBackground();
	}
	
	public void terminaJogo() {
		voltaParaPainelInicial();
		botaoVoltarParaOJogo.setVisible(false);
		painelInicial.remove(botaoVoltarParaOJogo);
		getContentPane().remove(painelJanela);
	}
	
	private void criaPainelInicial() {
		somDeFundo = new BackgroundSound();
		somDeFundo.backgroundSound("resources" + File.separator + "AudioInicial.wav");
		
		painelInicial.setSize(1300, 770);
		painelInicial.setLayout(null);
		painelInicial.setVisible(true);
		getContentPane().add(painelInicial);
	}

	private void setBackgroundPainelInicial() {
		background = new JLabel();
		background.setSize(1300, 770);
		background.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "inicio" + File.separator + "BackgroundInicio.png"));
		painelInicial.add(background);
	}
	
	private void criaBotaoIniciarJogo() {
		botaoIniciar = new JButton("Iniciar");
		botaoIniciar.setSize(100, 40);
		botaoIniciar.setVisible(true);
		botaoIniciar.setLocation(1170, 670);
		botaoIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelInicial.setVisible(false);
				criaPainelJanela();
				controle.setInicioJogo();
				controle.addCardMaoJogadorNaInterfaceGrafica();
				controle.addCardMaoComputadorNaInterfaceGrafica();
				somDeFundo.closeSound();
				criaSoundDrawCards();
			}
			
		});
		painelInicial.add(botaoIniciar);
	}
	
	private void criaBotaoSalvar() {
		botaoIniciar = new JButton("Salvar");
		botaoIniciar.setSize(100, 40);
		botaoIniciar.setVisible(true);
		botaoIniciar.setLocation(40, 600);
		botaoIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.salvaArquivo();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
			
		});
		painelInicial.add(botaoIniciar);
	}
	
	private void criaBotaoEstatisticas() {
		botaoEstatisticas = new JButton("Estatísticas");
		botaoEstatisticas.setSize(120, 40);
		botaoEstatisticas.setVisible(true);
		botaoEstatisticas.setLocation(40, 550);
		botaoEstatisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controle.retornaEstatisticas());
			}
			
		});
		painelInicial.add(botaoEstatisticas);
	}
	
	private void criaBotaoVoltarParaOJogo() {
		botaoVoltarParaOJogo = new JButton("Voltar para o Jogo");
		botaoVoltarParaOJogo.setSize(150, 40);
		botaoVoltarParaOJogo.setVisible(true);
		botaoVoltarParaOJogo.setLocation(40, 670);
		botaoVoltarParaOJogo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelInicial.setVisible(false);
				painelJanela.setVisible(true);
				somDeFundo.closeSound();
			}
			
		});
		painelInicial.add(botaoVoltarParaOJogo);
	}

	public void atualizaVidaJogador() {
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Hit.wav");
		counterJogador.startCounter(controle.getVidaJogador());
		criaBackground();
	}
	
	public void atualizaVidaComputador() {
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Hit.wav");
		counterComputador.startCounter(controle.getVidaComputador());
		criaBackground();
	}
	
	private void criaSoundDrawCards() {
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Draw5Cards.wav");
	}
	
	private String verificaTurnoString() {
				String textoTurno = "null";
				if(controle.verificaTurnoJogador())
					textoTurno = "Turno do Jogador";
				if(controle.verificaTurnoComputador())
					textoTurno = "Turno do Computador";
				return textoTurno;
	}
	
	private String verificaFaseString() {
				String textoFase = "null";
				if(controle.verificaFasePrincipal1())
					textoFase = "Fase Principal 1";
				if(controle.verificaFaseBatalha())
					textoFase = "Fase Batalha";
				if(controle.verificaFasePrincipal2())
					textoFase = "Fase Principal 2";
				return textoFase;
	}

	private void criaBackground() {
		imagemFundo.setVisible(false);
		getContentPane().remove(imagemFundo);
		imagemFundo = new JLabel();
		imagemFundo.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "Background.png"));
		imagemFundo.setSize(1300, 770);
		getContentPane().add(imagemFundo);
	}

	public Map<Integer, JButton> getListaButtonsCardsMonstrosJogador() {
		return this.listaButtonsCardsMonstrosJogador;
	}
	
	public Map<Integer, JButton> getListaButtonsCardsMonstrosComputador() {
		return this.listaButtonsCardsMonstrosComputador;
	}

	private void criaTodosOsCardsDoDeckFusao() {
		criaPainelDeckFusao();
		for(int i = 0; i < this.controle.getDeckFusaoJogador().size(); i++) {
			criaCardMonstroFusao(controle.getDeckFusaoJogador().get(i));
			posicaoX += 100;
		}
		posicaoX = 20;
		criaFundoPainel();
		criaBackground();
	}
	
	private void criaCardMonstroFusao(CardMonstroFusao card) {
		botaoCardFusao = new JButton();
		botaoCardFusao.setBounds(posicaoX, 15, 92, 134);
		botaoCardFusao.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardFusao.setVisible(true);
		botaoCardFusao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
		painelDeckFusao.add(botaoCardFusao);
		criaBackground();
	}
	
	private void criaPainelDeckFusao() {
		painelDeckFusao = new JPanel();
		painelDeckFusao.setLayout(null);
		painelDeckFusao.setLocation(500, 350);
		painelDeckFusao.setSize(430, 170);
		painelDeckFusao.setVisible(true);
		painelJanela.add(painelDeckFusao);
		criaBackground();
	}

	private void criaFundoPainel() {
		JLabel fundoPainel = new JLabel();
		fundoPainel.setSize(430, 170);
		fundoPainel.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "painel.png"));
		fundoPainel.setVisible(true);
		painelDeckFusao.add(fundoPainel);
		criaBackground();
	}
	
	private void criaJanela() {
		criaBackground();
		setUndecorated(false);
		setLayout(null);
		setSize(1300, 770);
		setVisible(true);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		criaBackground();
	}
}
