package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controle.Controle;
import modelo.Card;
import modelo.estados.estadosCard.FaceParaBaixo;

public class JanelaDescartarCard extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton botaoDescartar, botaoJogar;
	Controle controle;
	Card card;
	int x, y;
	int yJanela;

	public JanelaDescartarCard() {
		super("Decartar");
	}

	public void iniciaJanela(int x, int y, Controle controle, Card card) {
		this.x = x;
		this.y = y;

		this.controle = controle;
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
		if (controle.verificaSeLimiteDoJogadorFoiExcedido() || controle.verificaSeLimiteDoComputadorFoiExcedido()) {

			botaoDescartar = new JButton("Descartar");
			botaoDescartar.setSize(100, 30);
			botaoDescartar.setVisible(true);
			botaoDescartar.setLocation(0, 0);
			botaoDescartar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (controle.verificaTurnoJogador()) {
						controle.adicionaCardDaMaoDoJogadorAoCemiterio(controle.retornaPosicaoCardNaMaoJogador(card.getNome()));
						controle.mudaParaLimiteNaoExcedidoJogador();
						controle.addCardMaoJogadorNaInterfaceGrafica();
					}
					if (controle.verificaTurnoComputador()) {
						controle.adicionaCardDaMaoDoComputadorAoCemiterio(controle.retornaPosicaoCardNaMaoComputador(card.getNome()));
						controle.mudaParaLimiteNaoExcedidoComputador();
						controle.addCardMaoComputadorNaInterfaceGrafica();
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
				if (controle.verificaTurnoJogador()) {
					controle.adicionaCardDaMaoDoJogadorAoCampo(controle.retornaPosicaoCardNaMaoJogador(card.getNome()), x, y, card);
					controle.addCardMaoJogadorNaInterfaceGrafica();
				}
				if (controle.verificaTurnoComputador()) {
					controle.adicionaCardDaMaoDoComputadorAoCampo(controle.retornaPosicaoCardNaMaoComputador(card.getNome()), x, y, card);
					controle.addCardMaoComputadorNaInterfaceGrafica();
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
	}

}
