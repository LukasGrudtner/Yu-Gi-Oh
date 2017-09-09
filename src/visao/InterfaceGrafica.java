package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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

import excecoes.ExcecaoAtaque;
import excecoes.ExcecaoFase;
import modelo.CampoDeBatalha;
import modelo.Card;
import modelo.CardArmadilha;
import modelo.CardMagia;
import modelo.CardMonstro;
import modelo.CardMonstroFusao;
import modelo.EfeitoCardsMagia;
import modelo.estados.FaseBatalha;
import modelo.estados.FasePrincipal1;
import modelo.estados.FasePrincipal2;
import modelo.estados.LimiteExcedido;
import modelo.estados.LimiteNaoExcedido;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import modelo.estados.estadosCard.FaceParaBaixo;
import modelo.estados.estadosCard.estadosCardMonstro.AtaqueNaoRealizado;
import modelo.estados.estadosInvocacao.MonstroNaoInvocado;

public class InterfaceGrafica extends JFrame {
	
	private JButton botaoFaseCompra, botaoFaseApoio, botaoFasePrincipal1, botaoFaseBatalha, botaoFasePrincipal2, botaoFaseFinal, botaoMenu, botaoTeste, botaoApagaTeste;
	private JButton botaoCardMonstroAtaque, botaoCardMonstroDefesa, botaoCardMagiaEArmadilha, botaoIniciar, botaoVoltarParaOJogo, botaoEstatisticas;
	private JLabel labelCard, verso, versoDefesa, turno, fase;
	private JLabel descricaoCard, labelCardMonstro;
	private ImageIcon versoCard, cardAtaque;
	private CampoDeBatalha campoDeBatalha;
	private Card card;
	private JButton cardMao, botaoRefresh, botaoDeckFusao;
	private JLabel background, exodia;
	private JPanel panelCardJogador, panelCardComputador, painelJanela, painelInicial, painelCardMonstroJogador, painelCardMonstroComputador, painelCardMagiaEArmadilhaJogador, painelCardMagiaEArmadilhaComputador;
	private PilhaJogador pilhaJogador;
	private PilhaComputador pilhaComputador;
	private List<JPanel> listaPaineisCardsMaoJogador, listaPaineisCardsMaoComputador;
	private Map<Integer, JPanel> listaPaineisCardsMonstrosJogador, listaPaineisCardsMonstrosComputador, listaPaineisCardsMagiaEArmadilhaJogador, listaPaineisCardsMagiaEArmadilhaComputador;
	private JanelaPosicaoCard janelaPosicaoCard;
	private JanelaDescartarCard janelaDescartarCard;
	private BackgroundSound b;
	private JLabel versoCemiterioJ, versoCemiterioC, imagemFundo;
	private JLabel vidaJogador, vidaComputador;
	private Map<Integer, JButton> listaButtonsCardsMonstrosJogador, listaButtonsCardsMonstrosComputador;
	private JButton botaoCardFusao;
	private JPanel painelDeckFusao;
	private Counter counterJogador, counterComputador;
	private int posicaoX = 20;
	private int draw5Cards = 0;
	private boolean ativaBotaoDeckFusao = false;
	
	public InterfaceGrafica(CampoDeBatalha campoDeBatalha) {
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
		labelCardMonstro = new JLabel();
		botaoDeckFusao = new JButton();
		background = new JLabel();
		imagemFundo = new JLabel();
		
		
		botaoFasePrincipal1 = new JButton("Main 1");
		botaoFaseBatalha = new JButton("Battle");
		botaoFasePrincipal2 = new JButton("Main 2");
		botaoFaseFinal = new JButton("Finish");
		
		this.campoDeBatalha = campoDeBatalha;
		
//		criaBotaoFaseCompra();
//		criaBotaoFaseApoio();
//		criaBotaoFasePrincipal1();
		criaBotaoFaseBatalha();
		criaBotaoFasePrincipal2();
		criaBotaoTerminarJogada();
		
//		criaBotaoRefresh();
		
		criaLabelTurno();
		criaLabelFase();
		
		criaPilhas();	
		criaDecksComputador();
		
		criaBotaoVoltar();
		criaPainelInicial();
		criaBotaoIniciarJogo();
		criaBotaoEstatisticas();
		setBackgroundPainelInicial();
		
//		criaLabelVidaJogador();
//		criaLabelVidaComputador();
		
		criaCounters();

		criaJanela();
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
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro && ((CardMonstro) card).getAtaque() instanceof AtaqueNaoRealizado) {
					campoDeBatalha.setCardDisabledJogador(card);
					campoDeBatalha.setAtacanteBattle((CardMonstro) card); 
				}
			}

			private void efeitoCardMonstroAtaqueJogadorNoTurnoComputador(Card card) {
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					campoDeBatalha.setAlvoBattle((CardMonstro) card); 
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
		listaPaineisCardsMonstrosJogador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), painelCardMonstroJogador);
		listaButtonsCardsMonstrosJogador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), botaoCardMonstroAtaque);
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
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + "Verso2.png"));
		else
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroDefesa.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro) {
					campoDeBatalha.setAlvoBattle((CardMonstro) card);
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
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		listaPaineisCardsMonstrosJogador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoJogador(card.getNome()), painelCardMonstroJogador);
		
		new Movimento(x, y, painelCardMonstroJogador);
		criaBackground();
	}
	
	public void criaBotaoCardMagiaEArmadilhaJogador(int x, int y, Card card, int xMao, int yMao) {
		painelCardMagiaEArmadilhaJogador = new JPanel();
		botaoCardMagiaEArmadilha = new JButton();
		botaoCardMagiaEArmadilha.setSize(92, 134);
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		else
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardMagiaEArmadilha.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2)) {
					new EfeitoCardsMagia(campoDeBatalha, card.getNome());
					campoDeBatalha.destroiCardMagiaEArmadilhaJogador(card);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		
		listaPaineisCardsMagiaEArmadilhaJogador.put(campoDeBatalha.retornaPosicaoCardMagiaEArmadilhaNoCampoJogador(card.getNome()), painelCardMagiaEArmadilhaJogador);
		new Movimento(x, y, painelCardMagiaEArmadilhaJogador);
		criaBackground();
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
				campoDeBatalha.setCardEnabledComputador();
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					campoDeBatalha.setAlvoBattle((CardMonstro) card); 
				}
				
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro && ((CardMonstro) card).getAtaque() instanceof AtaqueNaoRealizado) {
					campoDeBatalha.setCardDisabledComputador(card);
					campoDeBatalha.setAtacanteBattle((CardMonstro) card); 
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		
		listaPaineisCardsMonstrosComputador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), painelCardMonstroComputador);
		listaButtonsCardsMonstrosComputador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), botaoCardMonstroAtaque);
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
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + "Verso2.png"));
		else
			botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroDefesa.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getFase() instanceof FaseBatalha && card instanceof CardMonstro) {
					PlaySound p = new PlaySound();
					p.playSound("resources" + File.separator + "CardDestruction.wav");
					campoDeBatalha.setAlvoBattle((CardMonstro) card); 
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		
		listaPaineisCardsMonstrosComputador.put(campoDeBatalha.retornaPosicaoCardMonstroNoCampoComputador(card.getNome()), painelCardMonstroComputador);
		new Movimento(x, y, painelCardMonstroComputador);
		criaBackground();
	}
	
	public void criaBotaoCardMagiaEArmadilhaComputador(int x, int y, Card card, int xMao, int yMao) {
		painelCardMagiaEArmadilhaComputador = new JPanel();
		botaoCardMagiaEArmadilha = new JButton();
		
		botaoCardMagiaEArmadilha.setSize(92, 134);
		if(card.getFace() instanceof FaceParaBaixo)
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		else
			botaoCardMagiaEArmadilha.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardMagiaEArmadilha.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2)) {

					new EfeitoCardsMagia(campoDeBatalha, card.getNome());
					campoDeBatalha.destroiCardMagiaEArmadilhaComputador(card);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		
		listaPaineisCardsMagiaEArmadilhaComputador.put(campoDeBatalha.retornaPosicaoCardMagiaEArmadilhaNoCampoComputador(card.getNome()), painelCardMagiaEArmadilhaComputador);
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
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + this.card.getNome() + ".png");
		cardMao = new JButton();
		cardMao.setSize(92, 134);
		cardMao.setIcon(versoCard);
		cardMao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaDescartarCard.dispose();
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2) && card instanceof CardMonstro && campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado && (campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size() < 5 || campoDeBatalha.getJogador().getLimite() instanceof LimiteExcedido)) {
					for(int i = 0; i < listaPaineisCardsMaoJogador.size(); i++) {
						listaPaineisCardsMaoJogador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoJogador.get(i));
					}
					
					//new JanelaPosicaoCard(x - 25, y - 75, campoDeBatalha, card);
					atualizaJanelaPosicaoCard(x, y, campoDeBatalha, card);
					
						
					campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
					campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimite();
				}
				
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2) && (card instanceof CardMagia || card instanceof CardArmadilha)) {
					janelaPosicaoCard.dispose();
					verificaLimite();
					
					for(int i = 0; i < listaPaineisCardsMaoJogador.size(); i++) {
						listaPaineisCardsMaoJogador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoJogador.get(i));
					}
					//new JanelaDescartarCard(x, y - 40, campoDeBatalha, card);
					atualizaJanelaDescartarCard(x, y, campoDeBatalha, card);
					campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
					verificaLimite();
				}
				verificaLimite();
			}

			

			
		});
		
		cardMao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				PlaySound p = new PlaySound();
//				p.playSound("resources" + File.separator + "SelectAlvo.wav");
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
//				getContentPane().setEnabled(false);
//				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		if(draw5Cards < 7)
			new Movimento(x, y, panelCardJogador);
		else
			panelCardJogador.setLocation(x, y);
		painelJanela.add(panelCardJogador);
		criaBackground();
	}
	
	private void atualizaJanelaDescartarCard(int x, int y, CampoDeBatalha campoDeBatalha, Card card) {
		janelaDescartarCard.dispose();
		janelaDescartarCard = new JanelaDescartarCard();
		janelaDescartarCard.iniciaJanela(x, y - 40, campoDeBatalha, card);
		criaBackground();
	}
	
	private void atualizaJanelaPosicaoCard(int x, int y, CampoDeBatalha campoDeBatalha, Card card) {
		janelaPosicaoCard.dispose();
		janelaPosicaoCard = new JanelaPosicaoCard();
		janelaPosicaoCard.iniciaJanela(x - 25, y - 75, campoDeBatalha, card);
		criaBackground();
	}
	
	private void verificaLimite() {
		if(campoDeBatalha.getMaoJogador().size() < 6)
			campoDeBatalha.mudaParaLimiteNaoExcedidoJogador();
		if(campoDeBatalha.getMaoComputador().size() < 6)
			campoDeBatalha.mudaParaLimiteNaoExcedidoComputador();
		criaBackground();
	}

	public void criaBotaoCardMaoComputador(int x, int y, Card card, int posicao) {
		panelCardComputador = new JPanel();
		this.card = card;
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png");
		cardMao = new JButton();
		cardMao.setSize(92, 134);
		cardMao.setIcon(versoCard);
		cardMao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaDescartarCard.dispose();
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2) && card instanceof CardMonstro && campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado && (campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size() < 5 || campoDeBatalha.getComputador().getLimite() instanceof LimiteExcedido)) {
					
					for(int i = 0; i < listaPaineisCardsMaoComputador.size(); i++) {
						listaPaineisCardsMaoComputador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoComputador.get(i));
					}
					
					//new JanelaPosicaoCard(x - 25, y + 165, campoDeBatalha, card);
					atualizaJanelaPosicaoCard(x, y + 250, campoDeBatalha, card);
						
					getContentPane().setEnabled(false);
					getContentPane().setEnabled(true);
					campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
					campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimite();
				}
				
				if(campoDeBatalha.getTurno() instanceof TurnoComputador && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2) && (card instanceof CardMagia || card instanceof CardArmadilha)) {
					verificaLimite();
					janelaPosicaoCard.dispose();
						
					for(int i = 0; i < listaPaineisCardsMaoComputador.size(); i++) {
						listaPaineisCardsMaoComputador.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMaoComputador.get(i));
					}
						
					//new JanelaDescartarCard(x + 2, y + 170, campoDeBatalha, card);
					atualizaJanelaDescartarCard(x + 2, y + 200, campoDeBatalha, card);
					campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
					verificaLimite();
				}
				verificaLimite();
			
			}
		});
		cardMao.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				if(arg0.isMetaDown())
//					JOptionPane.showMessageDialog(null, "Botão Direito");
//				if(arg0.isAltDown())
//					JOptionPane.showMessageDialog(null, "Botão Esquerdo");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				PlaySound p = new PlaySound();
//				p.playSound("resources" + File.separator + "SelectCard.wav");
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
//				apagaPaineisCounter();
//				criaPaineisContador();
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
		if(draw5Cards < 7)
			new Movimento(x, y, panelCardComputador);
		else
			panelCardComputador.setLocation(x, y);
		criaBackground();
		
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
		//getContentPane().add(botaoDeckFusao);
		painelJanela.add(botaoDeckFusao);
		criaBackground();
	}

	private void criaDecksComputador() {
		//criaVersoCard(350, 90); // deck computador
	//	criaVersoCard(350, 230); // cemitério computador
		criaVersoCard(1170, 90); // deck fusão computador
	}


	void criaImagemCard(String nomeCard) {
		labelCard.setSize(176, 256);
		labelCard.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsVisualizacao" + File.separator + nomeCard + ".png"));
		labelCard.setLocation(35, 150);
		//getContentPane().add(labelCard);//, ALLBITS);
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
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png");
		verso = new JLabel();
		verso.setSize(92, 134);
		verso.setIcon(versoCard);
		verso.setLocation(x, y);
		//getContentPane().add(verso);
		//painelJanela.add(verso);
		criaBackground();
	}
	
	private void criaPilhas() {
		pilhaJogador = new PilhaJogador(campoDeBatalha.getDeckJogador().size());
		painelJanela.add(pilhaJogador);
		
		pilhaComputador = new PilhaComputador(campoDeBatalha.getDeckCPU().size());
		painelJanela.add(pilhaComputador);
		
		versoCemiterioJ = new JLabel();
		versoCemiterioJ.setSize(92, 134);
		versoCemiterioJ.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioJ.setLocation(1170, 380);
		painelJanela.add(versoCemiterioJ);
		
		versoCemiterioC = new JLabel();
		versoCemiterioC.setSize(92, 134);
		versoCemiterioC.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioC.setLocation(350, 230);
		//painelJanela.add(versoCemiterioC);
		criaBackground();
	
	}
	
	public void atualizaPilhas() {		
		versoCemiterioJ.setVisible(false);
		painelJanela.remove(versoCemiterioJ);
		versoCemiterioC.setVisible(false);
		painelJanela.remove(versoCemiterioC);
		
		pilhaJogador.setVisible(false);
		painelJanela.remove(pilhaJogador);
		pilhaJogador = new PilhaJogador(campoDeBatalha.getDeckJogador().size());
		painelJanela.add(pilhaJogador);
		
		criaBotaoDeckFusao();
		
		pilhaComputador.setVisible(false);
		painelJanela.remove(pilhaComputador);
		pilhaComputador = new PilhaComputador(campoDeBatalha.getDeckCPU().size());
		painelJanela.add(pilhaComputador);
		
		versoCemiterioJ = new JLabel();
		versoCemiterioJ.setVisible(true);
		versoCemiterioJ.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioJ.setBounds(1170, 380, 92, 134);
		painelJanela.add(versoCemiterioJ);
		
		versoCemiterioC = new JLabel();
		versoCemiterioC.setSize(92, 134);
		versoCemiterioC.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png"));
		versoCemiterioC.setLocation(370, 230);
		painelJanela.add(versoCemiterioC);
		criaBackground();
		
	}
	
	
//	private void criaBotaoFaseCompra() {
//		botaoFaseCompra = new JButton("Draw");
//		botaoFaseCompra.setSize(80, 30);
//		botaoFaseCompra.setLocation(250, 260);
//		botaoFaseCompra.setVisible(true);
//		botaoFaseCompra.setEnabled(false);
//		//getContentPane().add(botaoFaseCompra);
//		painelJanela.add(botaoFaseCompra);
//		criaBackground();
//	}
	
//	private void criaBotaoFaseApoio() {
//		botaoFaseApoio = new JButton("Standby");
//		botaoFaseApoio.setSize(80, 30);
//		botaoFaseApoio.setLocation(250, 300);
//		botaoFaseApoio.setVisible(true);
//		botaoFaseApoio.setEnabled(false);
//		//getContentPane().add(botaoFaseApoio);
//		painelJanela.add(botaoFaseApoio);
//		criaBackground();
//	}
	
//	private void criaBotaoFasePrincipal1() {
//		botaoFasePrincipal1.setSize(80, 30);
//		botaoFasePrincipal1.setLocation(250, 340);
//		botaoFasePrincipal1.setVisible(true);
//		botaoFasePrincipal1.setEnabled(false);
//		painelJanela.add(botaoFasePrincipal1);
//		criaBackground();
//	}
	
	private void criaBotaoFaseBatalha() {
		botaoFaseBatalha = new JButton("Battle");
		botaoFaseBatalha.setSize(80, 30);;
		botaoFaseBatalha.setLocation(250, 280);
		botaoFaseBatalha.setVisible(true);
		botaoFaseBatalha.setEnabled(true);
		botaoFaseBatalha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					campoDeBatalha.mudaParaFaseBatalha();
					String textoFase = verificaFaseString();
					fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
					botaoFasePrincipal1.setEnabled(false);
					botaoFaseBatalha.setEnabled(false);
					botaoFasePrincipal2.setEnabled(true);
					botaoFaseFinal.setEnabled(false);
				} catch (ExcecaoFase e) {
					e.printStackTrace();
				}
				
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
				try {
					campoDeBatalha.mudaParaFasePrincipal2();
					String textoFase = verificaFaseString();
					fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
					botaoFaseFinal.setEnabled(true);
					botaoFasePrincipal2.setEnabled(false);
				} catch (ExcecaoFase e) {}
			}
		});
		painelJanela.add(botaoFasePrincipal2);
		criaBackground();
	}
	
	public void refresh() {
		getContentPane().setEnabled(false);
		getContentPane().setEnabled(true);
		criaBackground();
	}
	
//	public void criaBotaoRefresh() {
//		botaoRefresh = new JButton("Exódia");
//		botaoRefresh.setSize(80, 30);
//		botaoRefresh.setLocation(250, 500);
//		botaoRefresh.setVisible(true);
//		botaoRefresh.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				//new JanelaExodia();
//				criaExodia();
//				
//				getContentPane().setEnabled(false);
//				getContentPane().setEnabled(true);
//			}
//
//			
//			
//		});
//		//getContentPane().add(botaoRefresh);
//		painelJanela.add(botaoRefresh);
//		criaBackground();
//	}
	
	private void criaBotaoTerminarJogada() {
		botaoFaseFinal = new JButton("Finish");
		botaoFaseFinal.setSize(80, 30);
		botaoFaseFinal.setLocation(250, 360);
		botaoFaseFinal.setVisible(true);
		botaoFaseFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				verificaLimite();
				if(campoDeBatalha.getTurno() instanceof TurnoJogador) {
					if(campoDeBatalha.getJogador().getLimite() instanceof LimiteExcedido)
						JOptionPane.showMessageDialog(null, "Descarte uma carta!");
				}
				if(campoDeBatalha.getTurno() instanceof TurnoComputador) {
					if(campoDeBatalha.getComputador().getLimite() instanceof LimiteExcedido)
						JOptionPane.showMessageDialog(null, "Descarte uma carta!");
				}
					
				if(campoDeBatalha.getComputador().getLimite() instanceof LimiteNaoExcedido && campoDeBatalha.getJogador().getLimite() instanceof LimiteNaoExcedido && (campoDeBatalha.getFase() instanceof FasePrincipal1 || campoDeBatalha.getFase() instanceof FasePrincipal2)) {
						try {
							campoDeBatalha.trocaTurno();
							campoDeBatalha.mudaParaFasePrincipal1();
		
							String textoFase = verificaFaseString();
							String textoTurno = verificaTurnoString();
							fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
							turno.setText("<html><font color = FFFFFF>" + textoTurno + "</font></html>");
							
							botaoFaseBatalha.setEnabled(true);
							botaoFasePrincipal2.setEnabled(false);
						} catch (ExcecaoFase e) {}
				}
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
				campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
			}
		});

		painelJanela.add(botaoFaseFinal);
		criaBackground();
	}
	
	// Provisório
//	private void criaExodia() {
//		painelJanela.setVisible(false);
//		int y = 380;
//		
//		labelCardMonstro = new JLabel();
//		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Perna Direita do Proibido.png");
//		labelCardMonstro.setSize(92, 134);
//		labelCardMonstro.setIcon(cardAtaque);
//		labelCardMonstro.setLocation(673, 525);
//		getContentPane().add(labelCardMonstro);
//		
//		labelCardMonstro = new JLabel();
//		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Braço Direito do Proibido.png");
//		labelCardMonstro.setSize(92, 134);
//		labelCardMonstro.setIcon(cardAtaque);
//		labelCardMonstro.setLocation(673, 390);
//		getContentPane().add(labelCardMonstro);
//		
//		labelCardMonstro = new JLabel();
//		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Exódia, o Proibido.png");
//		labelCardMonstro.setSize(92, 134);
//		labelCardMonstro.setIcon(cardAtaque);
//		labelCardMonstro.setLocation(765, y);
//		getContentPane().add(labelCardMonstro);
//		
//		labelCardMonstro = new JLabel();
//		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Braço Esquerdo do Proibido.png");
//		labelCardMonstro.setSize(92, 134);
//		labelCardMonstro.setIcon(cardAtaque);
//		labelCardMonstro.setLocation(857, 390);
//		getContentPane().add(labelCardMonstro);
//		
//		labelCardMonstro = new JLabel();
//		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Perna Esquerda do Proibido.png");
//		labelCardMonstro.setSize(92, 134);
//		labelCardMonstro.setIcon(cardAtaque);
//		labelCardMonstro.setLocation(857, 525);
//		getContentPane().add(labelCardMonstro);
//		
//		exodia = new JLabel();
//		exodia.setSize(600, 338);
//		exodia.setLocation(500, 30);
//		exodia.setIcon(new ImageIcon("resources" + File.separator + "Exodia3.gif"));
//		exodia.setVisible(true);
//		getContentPane().add(exodia);
//		
//		PlaySound p = new PlaySound();
//		p.playSound("resources" + File.separator + "Exodia3.wav");
//		criaBackground();
//	}
	
	private void criaLabelTurno() {
		turno = new JLabel("Turno: " + campoDeBatalha.getTurno());
		turno.setSize(300, 50);
		turno.setLocation(1160, 40);
		turno.setVisible(true);
		//getContentPane().add(turno);
		painelJanela.add(turno);
		criaBackground();
	}
	
	private void criaLabelFase() {
		String textoFase = verificaFaseString();
	
		fase = new JLabel("<html><font color = FFFFFF>" + textoFase + "</font></html>");
		fase.setSize(300, 50);
		fase.setLocation(1160, 20);
		fase.setVisible(true);
		//getContentPane().add(fase);
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

		//getContentPane().add(compraCard);
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
		b = new BackgroundSound();
		b.backgroundSound("resources" + File.separator + "AudioInicial.wav");
		
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
				campoDeBatalha.setInicioJogo();
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
				campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
				b.closeSound();
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
				campoDeBatalha.salvaArquivo();
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
				JOptionPane.showMessageDialog(null, campoDeBatalha.retornaEstatisticas());
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
				b.closeSound();
				//painelJanela.setVisible(true);
			}
			
		});
		painelInicial.add(botaoVoltarParaOJogo);
	}

	
//	private void criaLabelVidaJogador() {
//		vidaJogador = new JLabel();
//		vidaJogador.setSize(100, 30);
//		vidaJogador.setLocation(250, 700);
//		vidaJogador.setText(campoDeBatalha.getVidaJogador() + "");
//		vidaJogador.setVisible(true);
//		painelJanela.add(vidaJogador);
//	}
//	
//	private void criaLabelVidaComputador() {
//		vidaComputador = new JLabel();
//		vidaComputador.setSize(100, 30);
//		vidaComputador.setLocation(300, 20);
//		vidaComputador.setText(campoDeBatalha.getVidaComputador() + "");
//		vidaComputador.setVisible(true);
//		painelJanela.add(vidaComputador);
//	}
	
	public void atualizaVidaJogador() {
//		vidaJogador.setText(campoDeBatalha.getVidaJogador() + "");
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Hit.wav");
		counterJogador.startCounter(campoDeBatalha.getVidaJogador());
//		if(campoDeBatalha.getVidaJogador() <= 0)
//			criaExodia();
		criaBackground();
	}
	
	public void atualizaVidaComputador() {
//		vidaComputador.setText(campoDeBatalha.getVidaComputador() + "");
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Hit.wav");
		counterComputador.startCounter(campoDeBatalha.getVidaComputador());
//		if(campoDeBatalha.getVidaComputador() <= 0)
//			criaExodia();
		criaBackground();
	}
	
	
	private void criaSoundDrawCards() {
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Draw5Cards.wav");
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
		
		getContentPane().addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				String textoFase = verificaFaseString();
				String textoTurno = verificaTurnoString();
				
				turno.setText("<html><font color = FFFFFF>" + textoTurno + "</font></html>");
				fase.setText("<html><font color = FFFFFF>" + textoFase + "</font></html>");
				setEnabled(false);
				setEnabled(true);

			}
			@Override
			public void mouseDragged(MouseEvent e) {

			}
			
		});
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		criaBackground();
	}
	private String verificaTurnoString() {
				String textoTurno = "null";
				if(campoDeBatalha.getTurno() instanceof TurnoJogador)
					textoTurno = "Turno do Jogador";
				if(campoDeBatalha.getTurno() instanceof TurnoComputador)
					textoTurno = "Turno do Computador";
				return textoTurno;
			}
	private String verificaFaseString() {
				String textoFase = "null";
				if(campoDeBatalha.getFase() instanceof FasePrincipal1)
					textoFase = "Fase Principal 1";
				if(campoDeBatalha.getFase() instanceof FaseBatalha)
					textoFase = "Fase Batalha";
				if(campoDeBatalha.getFase() instanceof FasePrincipal2)
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
		criaPainel();
		for(int i = 0; i < this.campoDeBatalha.getDeckFusaoJogador().size(); i++) {
			criaCard(campoDeBatalha.getDeckFusaoJogador().get(i));
			posicaoX += 100;
		}
		posicaoX = 20;
		criaFundoPainel();
		criaBackground();
	}
	
	

	private void criaCard(CardMonstroFusao card) {
		botaoCardFusao = new JButton();
		botaoCardFusao.setBounds(posicaoX, 15, 92, 134);
		botaoCardFusao.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardFusao.setVisible(true);
		botaoCardFusao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		painelDeckFusao.add(botaoCardFusao);
		criaBackground();
	}
	
	private void criaPainel() {
		painelDeckFusao = new JPanel();
		
		painelDeckFusao.setLayout(null);
		painelDeckFusao.setLocation(500, 350);
		painelDeckFusao.setSize(430, 170);
		painelDeckFusao.setVisible(true);
		//getContentPane().add(painelDeckFusao);
		painelJanela.add(painelDeckFusao);
		criaBackground();
	}

	private void criaFundoPainel() {
		JLabel fundoPainel = new JLabel();
		fundoPainel.setSize(430, 170);
		fundoPainel.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "painel.png"));
		fundoPainel.setVisible(true);
		painelDeckFusao.add(fundoPainel);
		refresh();
		criaBackground();
	}
	

}
