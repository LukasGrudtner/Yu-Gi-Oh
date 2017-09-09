package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.Controle;
import modelo.Card;
import modelo.CardMonstro;
import modelo.estados.LimiteExcedido;
import modelo.estados.estadosCard.FaceParaBaixo;
import modelo.estados.estadosCard.FaceParaCima;
import modelo.estados.estadosCard.PosicaoAtaque;
import modelo.estados.estadosCard.PosicaoDefesa;
import modelo.estados.estadosInvocacao.MonstroInvocado;
import modelo.estados.estadosInvocacao.MonstroNaoInvocado;

public class JanelaPosicaoCard extends JFrame {

	JButton botaoPosicaoAtaque, botaoPosicaoDefesa, botaoDescartar;
	JPanel painel;
	Controle controle;
	Card card;
	int x, y;
	int alturaJanela, alturaBotaoDescartar;

	public JanelaPosicaoCard() {
		super("Posição Card");
	}

	public void iniciaJanela(int x, int y, Controle controle, Card card) {
		this.x = x;
		this.y = y;

		this.controle = controle;
		this.card = card;
		painel = new JPanel();

		criaBotaoPosicaoAtaque(card);
		criaBotaoPosicaoDefesa(card);
		criaBotaoDescartarCard();
		criaPainel();
		criaJanela();
		timer();
	}

	private void criaBotaoPosicaoDefesa(Card card) {
		if ((controle.verificaTurnoJogador() && controle.getNumCardsMonstrosDoCampoDoJogador() < 5) || (controle.verificaTurnoComputador() && controle.getNumCardsMonstrosDoCampoDoComputador() < 5)) {
						
			botaoPosicaoDefesa = new JButton("Posição de Defesa");
			botaoPosicaoDefesa.setSize(150, 30);
			botaoPosicaoDefesa.setVisible(true);
			botaoPosicaoDefesa.setLocation(0, 30);
			botaoPosicaoDefesa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (controle.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						PlaySound p = new PlaySound();
						p.playSound("resources" + File.separator + "setCard.wav");
						dispose();
						card.mudaFace(new FaceParaBaixo(card));
						((CardMonstro) card).mudaPosicao(new PosicaoDefesa((CardMonstro) card));
						if (controle.verificaTurnoJogador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoJogadorAoCampo(controle.retornaPosicaoCardNaMaoJogador(card.getNome()), x + 50, y + 125,card);
							controle.mudaParaMonstroInvocado();
							controle.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (controle.verificaTurnoComputador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoComputadorAoCampo(controle.retornaPosicaoCardNaMaoComputador(card.getNome()), x - 50, y - 125, card);
							controle.addCardMaoComputadorNaInterfaceGrafica();
							controle.mudaParaMonstroInvocado();
						}
					}
				}

			});
			// getContentPane().add(botaoPosicaoDefesa);
			painel.add(botaoPosicaoDefesa);
		}
	}

	private void criaBotaoPosicaoAtaque(Card card) {
//		y = y + 60;
		alturaBotaoDescartar = 0;
		alturaJanela = 30;
		if ((controle.verificaTurnoJogador() && controle.getNumCardsMonstrosDoCampoDoJogador() < 5) || (controle.verificaTurnoComputador() && controle.getNumCardsMonstrosDoCampoDoComputador() < 5)) {		
			//botaoDescartar.setLocation(botaoDescartar.getX(), 60);
			alturaJanela = 90;
//			y = y - 60;
			alturaBotaoDescartar = 60;
			botaoPosicaoAtaque = new JButton("Posição de Ataque");
			botaoPosicaoAtaque.setSize(150, 30);
			botaoPosicaoAtaque.setVisible(true);
			botaoPosicaoAtaque.setLocation(0, 0);
			botaoPosicaoAtaque.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (controle.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						PlaySound p = new PlaySound();
						p.playSound("resources" + File.separator + "CardCampo.wav");
						dispose();
						card.mudaFace(new FaceParaCima(card));
						((CardMonstro) card).mudaPosicao(new PosicaoAtaque((CardMonstro) card));

						if (controle.verificaTurnoJogador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoJogadorAoCampo(controle.retornaPosicaoCardNaMaoJogador(card.getNome()), x + 50, y + 125, card);
							controle.mudaParaMonstroInvocado();
							controle.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (controle.verificaTurnoComputador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoComputadorAoCampo(controle.retornaPosicaoCardNaMaoComputador(card.getNome()), x - 50, y - 125, card);
							controle.addCardMaoComputadorNaInterfaceGrafica();
							controle.mudaParaMonstroInvocado();
						}
					}
				}

			});
			painel.add(botaoPosicaoAtaque);
		}
	}

	private void criaBotaoDescartarCard() {
		if (controle.getInvocacao() instanceof MonstroInvocado)
			dispose();
		if (controle.getJogador().getLimite() instanceof LimiteExcedido || controle.getComputador().getLimite() instanceof LimiteExcedido) {
				
			botaoDescartar = new JButton("Descartar");
			botaoDescartar.setSize(150, 30);
			botaoDescartar.setVisible(true);
			botaoDescartar.setLocation(0, alturaBotaoDescartar);
			botaoDescartar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (controle.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						if (controle.verificaTurnoJogador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoJogadorAoCemiterio(controle.retornaPosicaoCardNaMaoJogador(card.getNome()));
							controle.mudaParaLimiteNaoExcedidoJogador();
							controle.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (controle.verificaTurnoComputador() && controle.getInvocacao() instanceof MonstroNaoInvocado) {
							controle.adicionaCardDaMaoDoComputadorAoCemiterio(controle.retornaPosicaoCardNaMaoComputador(card.getNome()));
							controle.mudaParaLimiteNaoExcedidoComputador();
							controle.addCardMaoComputadorNaInterfaceGrafica();
						}

						dispose();
					}
				}

			});
			painel.add(botaoDescartar);
		}
	}

	private void timer() {
		Timer timer = new Timer(this, 5000);
		timer.start();
	}

	private void criaPainel() {
		painel.setLayout(null);
		painel.setVisible(true);
		painel.setSize(150, alturaJanela);
		getContentPane().add(painel);
	}

	private void criaJanela() {
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
		setSize(150, alturaJanela);
		setResizable(true);
		setLocation(x, y);
	}

}
