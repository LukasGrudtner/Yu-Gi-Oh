package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import excecoes.ExcecaoFase;
import modelo.CampoDeBatalha;
import modelo.estados.FasePrincipal1;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;

public class InterfaceGrafica extends JFrame {
	
	private JButton botaoFaseCompra, botaoFaseApoio, botaoFasePrincipal1, botaoFaseBatalha, botaoFasePrincipal2, botaoFaseFinal, compraCard;
	private JLabel card, verso, turno, fase, numCartasJogador, numCartasComputador;
	private ImageIcon imageCard, versoCard;
	private CampoDeBatalha campoDeBatalha;

	public InterfaceGrafica(CampoDeBatalha campoDeBatalha) {
		super("Yu-Gi-Oh!");
		setLayout(null);
		
		this.campoDeBatalha = campoDeBatalha;
		
		criaBotaoFaseCompra();
		criaBotaoFaseApoio();
		criaBotaoFasePrincipal1();
		criaBotaoFaseBatalha();
		criaBotaoFasePrincipal2();
		criaBotaoTerminarJogada();
		criaBotaoCompraCard();
		criaLabelNumCartasJogador();
		criaLabelNumCartasComputador();
		
		criaLabelTurno();
		criaLabelFase();
		
		//criaImagemCard();
		//Deck de cards
//		criaVersoCard(1050, 670);
//		criaVersoCard(950, 670);
//		criaVersoCard(850, 670);  // cards da mão do jogador
//		criaVersoCard(750, 670);
//		criaVersoCard(650, 670);
		
		criaVersoCard(1050, 520);
		criaVersoCard(950, 520);
		criaVersoCard(850, 520);  // cards de magia e armadilha do jogador
		criaVersoCard(750, 520);
		criaVersoCard(650, 520);
		
		criaVersoCard(1050, 380);
		criaVersoCard(950, 380);
		criaVersoCard(850, 380);  // cards de monstros do jogador
		criaVersoCard(750, 380);
		criaVersoCard(650, 380);

		criaVersoCard(1050, 230);
		criaVersoCard(950, 230);
		criaVersoCard(850, 230);  // cards de monstros computador
		criaVersoCard(750, 230);
		criaVersoCard(650, 230);
		
		criaVersoCard(1050, 90);
		criaVersoCard(950, 90);
		criaVersoCard(850, 90);  // cards magia e armadilha computador
		criaVersoCard(750, 90);
		criaVersoCard(650, 90);
	
//		criaVersoCard(1050, -60);
//		criaVersoCard(950, -60);
//		criaVersoCard(850, -60);  // cards mão computador
//		criaVersoCard(750, -60);
//		criaVersoCard(650, -60);
		
		criaVersoCard(1170, 520); // deck jogador
		criaVersoCard(1170, 380); // cemitério jogador
		criaVersoCard(530, 520); // deck fusão jogador
		
		criaVersoCard(530, 90); // deck computador
		criaVersoCard(530, 230); // cemitério computador
		criaVersoCard(1170, 90); // deck fusão computador
		
		criaJanela();
	}
	

	private void criaImagemCard() {
		imageCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "Dragão Branco de Olhos Azuis.png");
		card = new JLabel();
		card.setSize(351, 512);
		card.setIcon(imageCard);
		card.setLocation(50, 20);
		getContentPane().add(card);
	}
	
	
	private void criaVersoCard(int x, int y) {
		versoCard = new ImageIcon("resources" + File.separator + "images" + File.separator + "Verso.png");
		verso = new JLabel();
		verso.setSize(92, 136);
		verso.setIcon(versoCard);
		verso.setLocation(x, y);
		getContentPane().add(verso);
	}
	
	private void criaBotaoFaseCompra() {
		botaoFaseCompra = new JButton("Fase de Compra");
		botaoFaseCompra.setSize(140, 30);
		botaoFaseCompra.setLocation(300, 100);
		botaoFaseCompra.setVisible(true);
		botaoFaseCompra.setEnabled(false);
		getContentPane().add(botaoFaseCompra);
	}
	
	private void criaBotaoFaseApoio() {
		botaoFaseApoio = new JButton("Fase de Apoio");
		botaoFaseApoio.setSize(140, 30);
		botaoFaseApoio.setLocation(300, 140);
		botaoFaseApoio.setVisible(true);
		botaoFaseApoio.setEnabled(false);
		getContentPane().add(botaoFaseApoio);
	}
	
	private void criaBotaoFasePrincipal1() {
		botaoFasePrincipal1 = new JButton("Fase Principal 1");
		botaoFasePrincipal1.setSize(140, 30);
		botaoFasePrincipal1.setLocation(300, 180);
		botaoFasePrincipal1.setVisible(true);
		botaoFasePrincipal1.setEnabled(false);
		getContentPane().add(botaoFasePrincipal1);
	}
	
	private void criaBotaoFaseBatalha() {
		botaoFaseBatalha = new JButton("Fase de Batalha");
		botaoFaseBatalha.setSize(140, 30);
		botaoFaseBatalha.setLocation(300, 220);
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
		botaoFasePrincipal2 = new JButton("Fase Principal 2");
		botaoFasePrincipal2.setSize(140, 30);
		botaoFasePrincipal2.setLocation(300, 260);
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
	
	private void criaBotaoTerminarJogada() {
		botaoFaseFinal = new JButton("Terminar Jogada");
		botaoFaseFinal.setSize(140, 30);
		botaoFaseFinal.setLocation(300, 300);
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
				
			}
		});
		getContentPane().add(botaoFaseFinal);
		
	}
	
	// Provisório
	private void criaLabelTurno() {
		turno = new JLabel("Turno: " + campoDeBatalha.getTurno());
		turno.setSize(300, 50);
		turno.setLocation(100, 500);
		turno.setVisible(true);
		getContentPane().add(turno);
	}
	
	// Provisório
	private void criaLabelFase() {
		fase = new JLabel("Fase: " + campoDeBatalha.getFase());
		fase.setSize(300, 50);
		fase.setLocation(100, 450);
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
		getContentPane().add(compraCard);
	}
	
	private void criaLabelNumCartasJogador() {
		numCartasJogador = new JLabel("Número de Cartas do Jogador: " + campoDeBatalha.getMaoJogador().size());
		numCartasJogador.setSize(200, 40);
		numCartasJogador.setLocation(700, 670);
		numCartasJogador.setVisible(true);
		getContentPane().add(numCartasJogador);
	}
	
	private void criaLabelNumCartasComputador() {
		numCartasComputador = new JLabel("Número de Cartas do Computador: " + campoDeBatalha.getMaoComputador().size());
		numCartasComputador.setSize(220, 40);
		numCartasComputador.setLocation(700, 20);
		numCartasComputador.setVisible(true);
		getContentPane().add(numCartasComputador);
	}

	private void criaJanela() {
		setSize(1300, 1800);
		setVisible(true);
		setResizable(false);
		//setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				numCartasJogador.setText("Número de Cartas do Jogador: " + campoDeBatalha.getMaoJogador().size());
				numCartasComputador.setText("Número de Cartas do Computador: " + campoDeBatalha.getMaoComputador().size());
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
