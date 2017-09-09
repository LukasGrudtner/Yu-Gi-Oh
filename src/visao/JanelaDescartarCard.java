package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.CampoDeBatalha;
import modelo.Card;
import modelo.estados.LimiteExcedido;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import modelo.estados.estadosCard.FaceParaBaixo;

public class JanelaDescartarCard extends JFrame {

	JButton botaoDescartar, botaoJogar;
	CampoDeBatalha campoDeBatalha;
	Card card;
	int x, y;
	int yJanela;

	public JanelaDescartarCard() {
		super("Decartar");
		// dispose();
	}

	public void iniciaJanela(int x, int y, CampoDeBatalha campoDeBatalha, Card card) {
		this.x = x;
		this.y = y;

		this.campoDeBatalha = campoDeBatalha;
		this.card = card;

		criaBotaoDescartarCard();
		criaBotaoJogarCard();
		criaJanela(x, y);
		timer();
	}

	private void timer() {
		Timer timer = new Timer(this, 5000);
		timer.start();
	}

	private void criaBotaoDescartarCard() {
		if (campoDeBatalha.getJogador().getLimite() instanceof LimiteExcedido
				|| campoDeBatalha.getComputador().getLimite() instanceof LimiteExcedido) {

			botaoDescartar = new JButton("Descartar");
			botaoDescartar.setSize(100, 30);
			botaoDescartar.setVisible(true);
			botaoDescartar.setLocation(0, 0);
			botaoDescartar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (campoDeBatalha.getTurno() instanceof TurnoJogador) {
						campoDeBatalha.adicionaCardDaMaoDoJogadorAoCemiterio(
								campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()));
						campoDeBatalha.mudaParaLimiteNaoExcedidoJogador();
						campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
					}
					if (campoDeBatalha.getTurno() instanceof TurnoComputador) {
						campoDeBatalha.adicionaCardDaMaoDoComputadorAoCemiterio(
								campoDeBatalha.retornaPosicaoCardNaMaoComputador(card.getNome()));
						campoDeBatalha.mudaParaLimiteNaoExcedidoComputador();
						campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
					}

					dispose();
				}

			});
			getContentPane().add(botaoDescartar);
		}
	}

	private void criaBotaoJogarCard() {
		botaoJogar = new JButton("Jogar");
		botaoJogar.setSize(100, 30);
		botaoJogar.setVisible(true);
		botaoJogar.setLocation(0, 30);
		botaoJogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.mudaFace(new FaceParaBaixo(card));
				if (campoDeBatalha.getTurno() instanceof TurnoJogador) {
					campoDeBatalha.adicionaCardDaMaoDoJogadorAoCampo(
							campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()), x, y, card);
					campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
				}
				if (campoDeBatalha.getTurno() instanceof TurnoComputador) {
					campoDeBatalha.adicionaCardDaMaoDoComputadorAoCampo(
							campoDeBatalha.retornaPosicaoCardNaMaoComputador(card.getNome()), x, y, card);
					campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
				}
				dispose();
			}

		});
		getContentPane().add(botaoJogar);
	}

	private void criaJanela(int x, int y) {
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(100, 60);
		setResizable(true);
		setLocation(x, y);
		// this.pack();
	}

}
