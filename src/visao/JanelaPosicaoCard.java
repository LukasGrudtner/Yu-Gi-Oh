package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excecoes.ExcecaoFace;
import excecoes.ExcecaoInvocacao;
import excecoes.ExcecaoPosicao;
import modelo.CampoDeBatalha;
import modelo.Card;
import modelo.CardMonstro;
import modelo.CardMonstroSemEfeito;
import modelo.estados.LimiteExcedido;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import modelo.estados.estadosCard.FaceParaBaixo;
import modelo.estados.estadosCard.FaceParaCima;
import modelo.estados.estadosCard.PosicaoAtaque;
import modelo.estados.estadosCard.PosicaoDefesa;
import modelo.estados.estadosInvocacao.MonstroInvocado;
import modelo.estados.estadosInvocacao.MonstroNaoInvocado;

public class JanelaPosicaoCard extends JFrame {

	JButton botaoPosicaoAtaque, botaoPosicaoDefesa, botaoDescartar;
	JPanel painel;
	CampoDeBatalha campoDeBatalha;
	Card card;
	int x, y;
	int alturaJanela, alturaBotaoDescartar;

	public JanelaPosicaoCard() {
		super("Posição Card");
	}

	public void iniciaJanela(int x, int y, CampoDeBatalha campoDeBatalha, Card card) {
		this.x = x;
		this.y = y;

		this.campoDeBatalha = campoDeBatalha;
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
		if ((campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size() < 5) || (campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size() < 5)) {
						
			botaoPosicaoDefesa = new JButton("Posição de Defesa");
			botaoPosicaoDefesa.setSize(150, 30);
			botaoPosicaoDefesa.setVisible(true);
			botaoPosicaoDefesa.setLocation(0, 30);
			botaoPosicaoDefesa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (campoDeBatalha.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						PlaySound p = new PlaySound();
						p.playSound("resources" + File.separator + "setCard.wav");
						dispose();
						card.mudaFace(new FaceParaBaixo(card));
						((CardMonstro) card).mudaPosicao(new PosicaoDefesa((CardMonstro) card));
						if (campoDeBatalha.getTurno() instanceof TurnoJogador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoJogadorAoCampo(
									campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()), x + 50, y + 125,
									card);
							try {
								campoDeBatalha.mudaParaMonstroInvocado();
							} catch (ExcecaoInvocacao e) {
							}
							campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (campoDeBatalha.getTurno() instanceof TurnoComputador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoComputadorAoCampo(
									campoDeBatalha.retornaPosicaoCardNaMaoComputador(card.getNome()), x - 50, y - 125,
									card);
							campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
							try {
								campoDeBatalha.mudaParaMonstroInvocado();
							} catch (ExcecaoInvocacao e) {
							}
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
		if ((campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size() < 5) || (campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size() < 5)) {		
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
					if (campoDeBatalha.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						PlaySound p = new PlaySound();
						p.playSound("resources" + File.separator + "CardCampo.wav");
						dispose();
						card.mudaFace(new FaceParaCima(card));
						((CardMonstro) card).mudaPosicao(new PosicaoAtaque((CardMonstro) card));

						if (campoDeBatalha.getTurno() instanceof TurnoJogador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoJogadorAoCampo(
									campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()), x + 50, y + 125,
									card);
							try {
								campoDeBatalha.mudaParaMonstroInvocado();
							} catch (ExcecaoInvocacao e) {
							}
							campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (campoDeBatalha.getTurno() instanceof TurnoComputador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoComputadorAoCampo(
									campoDeBatalha.retornaPosicaoCardNaMaoComputador(card.getNome()), x - 50, y - 125,
									card);
							campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
							try {
								campoDeBatalha.mudaParaMonstroInvocado();
							} catch (ExcecaoInvocacao e) {
							}
						}
					}
				}

			});
			// getContentPane().add(botaoPosicaoAtaque);
			painel.add(botaoPosicaoAtaque);
		}
	}

	private void criaBotaoDescartarCard() {
//		yBotaoDescartar = 0;
		if (campoDeBatalha.getInvocacao() instanceof MonstroInvocado)
			dispose();
		if (campoDeBatalha.getJogador().getLimite() instanceof LimiteExcedido || campoDeBatalha.getComputador().getLimite() instanceof LimiteExcedido) {
				
			//yJanela = 30;
			botaoDescartar = new JButton("Descartar");
			botaoDescartar.setSize(150, 30);
			botaoDescartar.setVisible(true);
			botaoDescartar.setLocation(0, alturaBotaoDescartar);
			botaoDescartar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (campoDeBatalha.getInvocacao() instanceof MonstroInvocado)
						dispose();
					else {
						if (campoDeBatalha.getTurno() instanceof TurnoJogador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoJogadorAoCemiterio(
									campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()));
							campoDeBatalha.mudaParaLimiteNaoExcedidoJogador();
							campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
						}
						if (campoDeBatalha.getTurno() instanceof TurnoComputador
								&& campoDeBatalha.getInvocacao() instanceof MonstroNaoInvocado) {
							campoDeBatalha.adicionaCardDaMaoDoComputadorAoCemiterio(
									campoDeBatalha.retornaPosicaoCardNaMaoComputador(card.getNome()));
							campoDeBatalha.mudaParaLimiteNaoExcedidoComputador();
							campoDeBatalha.addCardMaoComputadorNaInterfaceGrafica();
						}

						dispose();
					}
				}

			});
			// getContentPane().add(botaoDescartar);
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
		// this.pack();
	}

}
