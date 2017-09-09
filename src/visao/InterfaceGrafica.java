package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excecoes.ExcecaoFase;
import modelo.CampoDeBatalha;
import modelo.Card;
import modelo.CardMonstro;
import modelo.estados.FaseBatalha;
import modelo.estados.FasePrincipal1;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;

public class InterfaceGrafica extends JFrame {
	
	private JButton botaoCard, botaoFaseCompra, botaoFaseApoio, botaoFasePrincipal1, botaoFaseBatalha, botaoFasePrincipal2, botaoFaseFinal, compraCard, botaoTeste, botaoApagaTeste;
	private JButton botaoCardMonstroAtaque, botaoCardMonstroDefesa, botaoCardMagiaEArmadilha;
	private JLabel labelCard, verso, versoDefesa, turno, fase, numCartasJogador, numCartasComputador;//, descricaoCard;
	private JLabel descricaoCard, labelCardMonstro;
	private ImageIcon imageCard, versoCard, versoCardDefesa, cardAtaque, cardDefesa;
	private CampoDeBatalha campoDeBatalha;
	private Card card;
	private JButton cardMao, botaoRefresh;
	private JLabel background, exodia;
	private JPanel panelCard;
	private List<JPanel> listaPaineisCardsMao;
	private JanelaPosicaoCard janelaPosicaoCard;
	
	public InterfaceGrafica(CampoDeBatalha campoDeBatalha) {
		super("Yu-Gi-Oh!");
		setLayout(null);
		
		listaPaineisCardsMao = new ArrayList<>();
		labelCard = new JLabel();
		descricaoCard = new JLabel();
		labelCardMonstro = new JLabel();
		
		this.campoDeBatalha = campoDeBatalha;
		
		criaBotaoFaseCompra();
		criaBotaoFaseApoio();
		criaBotaoFasePrincipal1();
		criaBotaoFaseBatalha();
		criaBotaoFasePrincipal2();
		criaBotaoTerminarJogada();
		
		criaBotaoRefresh();
		
		//criaBotaoCompraCard();
		criaLabelNumCartasJogador();
		criaLabelNumCartasComputador();
		
		criaLabelTurno();
		criaLabelFase();
		
		criaPilhaDeck(1170, 500);
		criaDecksJogador();		
		criaDecksComputador();
		
		criaBotaoCompraCard();
		
		criaJanela();
	}
	
	public void criaBotaoCardMonstroAtaque(int x, int y, final Card card) { // tirar o final
		botaoCardMonstroAtaque = new JButton();
		
		botaoCardMonstroAtaque.setSize(92, 134);
		botaoCardMonstroAtaque.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroAtaque.setLocation(x, y);
		botaoCardMonstroAtaque.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(campoDeBatalha.getFase() instanceof FaseBatalha) {
					JOptionPane.showMessageDialog(null, "Escolha o alvo!");
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
		getContentPane().add(botaoCardMonstroAtaque);
		
	}
	
	public void criaBotaoCardMonstroDefesa(int x, int y, final Card card) { // tirar o final
		botaoCardMonstroDefesa = new JButton();
		botaoCardMonstroDefesa.setSize(136, 92);
		botaoCardMonstroDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + card.getNome() + ".png"));
		botaoCardMonstroDefesa.setLocation(x, y);
		botaoCardMonstroDefesa.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		getContentPane().add(botaoCardMonstroDefesa);
	}
	
	public void criaBotaoApagaTeste() {
		botaoApagaTeste = new JButton();
		botaoApagaTeste.setSize(140, 90);
		botaoApagaTeste.setLocation(800, 300);
		botaoApagaTeste.setVisible(true);
		botaoApagaTeste.addActionListener(new ActionListener() {

			int click = 0;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				click++;
				if(click == 1)
					setBotaoTeste(false);
				if(click == 2)
					setBotaoTeste(true);
				if(click == 3)
					setBotaoTeste(false);
				if(click == 4)
					setBotaoTeste(true);
			}
			
		});
		getContentPane().add(botaoApagaTeste);
	}
	
	public void setBotaoTeste(boolean visible) {
		botaoTeste.setSize(140, 90);
		botaoTeste.setLocation(600, 300);
		botaoTeste.setVisible(visible);
		getContentPane().add(botaoTeste);
	}

	public void apagaMaoJogador() {
		for(int i = 0; i < listaPaineisCardsMao.size(); i++) {
			listaPaineisCardsMao.get(i).setVisible(false);
			getContentPane().remove(listaPaineisCardsMao.get(i));
		}
	}
	
	public void criaBotaoCardMao(final int x, final int y, final Card card, int posicao) {
		panelCard = new JPanel();
		
		this.card = card;
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + this.card.getNome() + ".png");
		cardMao = new JButton();
		cardMao.setSize(92, 136);
		cardMao.setIcon(versoCard);
		cardMao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getFase() instanceof FasePrincipal1 && card instanceof CardMonstro) {
//					listaPaineisCardsMao.get(posicao).setVisible(false);
//					getContentPane().remove(listaPaineisCardsMao.get(posicao));
					for(int i = 0; i < listaPaineisCardsMao.size(); i++) {
						listaPaineisCardsMao.get(i).setVisible(false);
						getContentPane().remove(listaPaineisCardsMao.get(i));
					}
					
					new JanelaPosicaoCard(x + 100, y, campoDeBatalha, card);
						
					//campoDeBatalha.adicionaCardMonstroDaMaoDoJogadorAoCampo(campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()));
					getContentPane().setEnabled(false);
					getContentPane().setEnabled(true);
					campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
					//criaBackground();
				}
			}
		});
		
		cardMao.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				criaImagemCard(card.getNome());
				criaDescricaoCard(card);
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panelCard.setLayout(null);
		panelCard.setSize(92, 136);
		panelCard.setLocation(x, y);
		panelCard.setVisible(true);
		panelCard.add(cardMao);
		listaPaineisCardsMao.add(panelCard);
		getContentPane().add(panelCard);
	}

	private void criaDecksJogador() {
		//criaVersoCard(1170, 520); // deck jogador
		criaVersoCard(1170, 380); // cemitério jogador
		criaVersoCard(350, 520); // deck fusão jogador
	}

	private void criaDecksComputador() {
		criaVersoCard(350, 90); // deck computador
		criaVersoCard(350, 230); // cemitério computador
		criaVersoCard(1170, 90); // deck fusão computador
	}
	
	private void criaVersoCardDefesa(int x, int y) {
		versoDefesa = new JLabel();
		versoDefesa.setSize(136, 92);
		versoDefesa.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cards" + File.separator + "Verso3.png"));
		versoDefesa.setLocation(x, y);
		getContentPane().add(versoDefesa);
	}

	private void criaImagemCard(String nomeCard) {
		labelCard.setSize(176, 256);
		labelCard.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsVisualizacao" + File.separator + nomeCard + ".png"));
		labelCard.setLocation(35, 150);
		getContentPane().add(labelCard);//, ALLBITS);
	}
	
	private void criaDescricaoCard(Card card) {
		descricaoCard.setText(card.getDescricao());
		descricaoCard.setSize(275, 200);
		descricaoCard.setLocation(40, 500);
		getContentPane().add(descricaoCard);
	}
	
	
	private void criaVersoCard(int x, int y) {
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Verso2.png");
		verso = new JLabel();
		verso.setSize(92, 134);
		verso.setIcon(versoCard);
		verso.setLocation(x, y);
		getContentPane().add(verso);
	}
	
	private void criaPilhaDeck(int x, int y) {
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "teste" + File.separator + "Deck20.png");
		verso = new JLabel();
		verso.setSize(111, 153);
		verso.setIcon(versoCard);
		verso.setLocation(x, y);
		getContentPane().add(verso);
	}
	
	private void criaCardAtaque(int x, int y, String nomeCard) {
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + nomeCard + ".png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(x, y);
		getContentPane().add(labelCardMonstro);
	}
	
	private void criaCardDefesa(int x, int y, String nomeCard) {
		cardDefesa = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsDefesa" + File.separator + nomeCard + ".png");
		labelCardMonstro.setSize(134, 92);
		labelCardMonstro.setIcon(cardDefesa);
		labelCardMonstro.setLocation(x, y);
		getContentPane().add(labelCardMonstro);
	}
	
	private void criaBotaoFaseCompra() {
		botaoFaseCompra = new JButton("Draw");
		botaoFaseCompra.setSize(80, 30);
		botaoFaseCompra.setLocation(250, 260);
		botaoFaseCompra.setVisible(true);
		botaoFaseCompra.setEnabled(false);
		getContentPane().add(botaoFaseCompra);
	}
	
	private void criaBotaoFaseApoio() {
		botaoFaseApoio = new JButton("Standby");
		botaoFaseApoio.setSize(80, 30);
		botaoFaseApoio.setLocation(250, 300);
		botaoFaseApoio.setVisible(true);
		botaoFaseApoio.setEnabled(false);
		getContentPane().add(botaoFaseApoio);
	}
	
	private void criaBotaoFasePrincipal1() {
		botaoFasePrincipal1 = new JButton("Main 1");
		botaoFasePrincipal1.setSize(80, 30);
		botaoFasePrincipal1.setLocation(250, 340);
		botaoFasePrincipal1.setVisible(true);
		botaoFasePrincipal1.setEnabled(false);
		getContentPane().add(botaoFasePrincipal1);
	}
	
	private void criaBotaoFaseBatalha() {
		botaoFaseBatalha = new JButton("Battle");
		botaoFaseBatalha.setSize(80, 30);
		botaoFaseBatalha.setLocation(250, 380);
		botaoFaseBatalha.setVisible(true);
		botaoFaseBatalha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					campoDeBatalha.mudaParaFaseBatalha();
					fase.setText("Fase: " + campoDeBatalha.getFase());
				} catch (ExcecaoFase e) {
					e.printStackTrace();
				}
				
			}
		});
		getContentPane().add(botaoFaseBatalha);
	}
	
	private void criaBotaoFasePrincipal2() {
		botaoFasePrincipal2 = new JButton("Main 2");
		botaoFasePrincipal2.setSize(80, 30);
		botaoFasePrincipal2.setLocation(250, 420);
		botaoFasePrincipal2.setVisible(true);
		botaoFasePrincipal2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					campoDeBatalha.mudaParaFasePrincipal2();
					fase.setText("Fase: " + campoDeBatalha.getFase());
				} catch (ExcecaoFase e) {
					e.printStackTrace();
				}
				
			}
		});
		getContentPane().add(botaoFasePrincipal2);
	}
	
	public void refresh() {
		getContentPane().setEnabled(false);
		getContentPane().setEnabled(true);
	}
	
	public void criaBotaoRefresh() {
		botaoRefresh = new JButton("Exódia");
		botaoRefresh.setSize(80, 30);
		botaoRefresh.setLocation(250, 500);
		botaoRefresh.setVisible(true);
		botaoRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new JanelaExodia();
				int y = 380;
				
				labelCardMonstro = new JLabel();
				cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Perna Direita do Proibido.png");
				labelCardMonstro.setSize(92, 134);
				labelCardMonstro.setIcon(cardAtaque);
				labelCardMonstro.setLocation(673, 525);
				getContentPane().add(labelCardMonstro);
				
				labelCardMonstro = new JLabel();
				cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Braço Direito do Proibido.png");
				labelCardMonstro.setSize(92, 134);
				labelCardMonstro.setIcon(cardAtaque);
				labelCardMonstro.setLocation(673, 390);
				getContentPane().add(labelCardMonstro);
				
				labelCardMonstro = new JLabel();
				cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Exódia, o Proibido.png");
				labelCardMonstro.setSize(92, 134);
				labelCardMonstro.setIcon(cardAtaque);
				labelCardMonstro.setLocation(765, y);
				getContentPane().add(labelCardMonstro);
				
				labelCardMonstro = new JLabel();
				cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Braço Esquerdo do Proibido.png");
				labelCardMonstro.setSize(92, 134);
				labelCardMonstro.setIcon(cardAtaque);
				labelCardMonstro.setLocation(857, 390);
				getContentPane().add(labelCardMonstro);
				
				labelCardMonstro = new JLabel();
				cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque" + File.separator + "Perna Esquerda do Proibido.png");
				labelCardMonstro.setSize(92, 134);
				labelCardMonstro.setIcon(cardAtaque);
				labelCardMonstro.setLocation(857, 525);
				getContentPane().add(labelCardMonstro);
				
				exodia = new JLabel();
				exodia.setSize(600, 338);
				exodia.setLocation(500, 30);
				exodia.setIcon(new ImageIcon("resources" + File.separator + "Exodia3.gif"));
				exodia.setVisible(true);
				getContentPane().add(exodia);
				
				PlaySound p = new PlaySound();
				p.playSound("resources" + File.separator + "Exodia3.wav");
				
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}
			
		});
		getContentPane().add(botaoRefresh);
	}
	
	private void criaBotaoTerminarJogada() {
		botaoFaseFinal = new JButton("Finish");
		botaoFaseFinal.setSize(80, 30);
		botaoFaseFinal.setLocation(250, 460);
		botaoFaseFinal.setVisible(true);
		botaoFaseFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					campoDeBatalha.trocaTurno();
					campoDeBatalha.mudaParaFasePrincipal1();
					fase.setText("Fase: " + campoDeBatalha.getFase());
					turno.setText("Turno: " + campoDeBatalha.getTurno());
				} catch (ExcecaoFase e) {
					e.printStackTrace();
				}
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
			}
		});
		botaoFaseFinal.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		getContentPane().add(botaoFaseFinal);
		
	}
	
	// Provisório
	private void criaLabelTurno() {
		turno = new JLabel("Turno: " + campoDeBatalha.getTurno());
		turno.setSize(300, 50);
		turno.setLocation(40, 80);
		turno.setVisible(true);
		getContentPane().add(turno);
	}
	
	// Provisório
	private void criaLabelFase() {
		fase = new JLabel("Fase: " + campoDeBatalha.getFase());
		fase.setSize(300, 50);
		fase.setLocation(40, 50);
		fase.setVisible(true);
		getContentPane().add(fase);
	}
	
	// Provisório
	private void criaBotaoCompraCard() {
		compraCard = new JButton("Comprar card");
		compraCard.setSize(120, 40);
		compraCard.setLocation(1150, 660);
		compraCard.setVisible(true);
		compraCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(campoDeBatalha.getFase() instanceof FasePrincipal1) {
					if(campoDeBatalha.getTurno() instanceof TurnoJogador)
						campoDeBatalha.addCardMaoJogador();
					if(campoDeBatalha.getTurno() instanceof TurnoComputador)
						campoDeBatalha.addCardMaoCPU();
				}
				numCartasJogador.setText("Número de Cartas do Jogador: " + campoDeBatalha.getMaoJogador().size());
				numCartasComputador.setText("Número de Cartas do Computador: " + campoDeBatalha.getMaoComputador().size());
			}
			
		});
		compraCard.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setEnabled(false);
				getContentPane().setEnabled(true);
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});
		getContentPane().add(compraCard);
	}
	
	private void criaLabelNumCartasJogador() {
		numCartasJogador = new JLabel("Número de Cartas do Jogador: " + campoDeBatalha.getMaoJogador().size());
		numCartasJogador.setSize(2000, 2000);
		numCartasJogador.setLocation(0, 0);
		numCartasJogador.setVisible(true);
		getContentPane().add(numCartasJogador);
	}
	
	private void criaLabelNumCartasComputador() {
		numCartasComputador = new JLabel("Número de Cartas do Computador: " + campoDeBatalha.getMaoComputador().size());
		numCartasComputador.setSize(220, 40);
		numCartasComputador.setLocation(700, 0);
		numCartasComputador.setVisible(true);
		getContentPane().add(numCartasComputador);
	}
	
	
	private void criaBackground() {
		background = new JLabel();
		background.setSize(1300, 1800);
		background.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "background.png"));
		getContentPane().add(background);
	}

	private void criaJanela() {
		setSize(1300, 1800);
		setVisible(true);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(new Color(100, 2, 4));
		
		getContentPane().addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				numCartasJogador.setText("Número de Cartas do Jogador: " + campoDeBatalha.getMaoJogador().size());
				numCartasComputador.setText("Número de Cartas do Computador: " + campoDeBatalha.getMaoComputador().size());
				setEnabled(false);
				setEnabled(true);
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
			
		});
	}

}
