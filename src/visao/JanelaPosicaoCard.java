package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.CampoDeBatalha;
import modelo.Card;

public class JanelaPosicaoCard extends JFrame {
	
	JButton botaoPosicaoAtaque, botaoPosicaoDefesa;
	CampoDeBatalha campoDeBatalha;
	Card card;
	
	public JanelaPosicaoCard(int x, int y, CampoDeBatalha campoDeBatalha, Card card) {
		super("Posição Card");
		
		this.campoDeBatalha = campoDeBatalha;
		this.card = card;
		
		criaBotaoPosicaoAtaque(card);		
		criaBotaoPosicaoDefesa(card);
		criaJanela(x, y);
	}

	private void criaBotaoPosicaoDefesa(final Card card) {
		botaoPosicaoDefesa = new JButton("Posição de Defesa");
		botaoPosicaoDefesa.setSize(150, 30);
		botaoPosicaoDefesa.setVisible(true);
		botaoPosicaoDefesa.setLocation(20, 20);
		botaoPosicaoDefesa.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				campoDeBatalha.adicionaCardMonstroDaMaoDoJogadorAoCampoPosicaoDefesa(campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()));
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
			}
			
		});
		getContentPane().add(botaoPosicaoDefesa);
	}

	private void criaBotaoPosicaoAtaque(final Card card) {
		botaoPosicaoAtaque = new JButton("Posição de Ataque");
		botaoPosicaoAtaque.setSize(150, 30);
		botaoPosicaoAtaque.setVisible(true);
		botaoPosicaoAtaque.setLocation(20, 60);
		botaoPosicaoAtaque.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				campoDeBatalha.adicionaCardMonstroDaMaoDoJogadorAoCampoPosicaoAtaque(campoDeBatalha.retornaPosicaoCardNaMaoJogador(card.getNome()));
				dispose();
				campoDeBatalha.addCardMaoJogadorNaInterfaceGrafica();
				campoDeBatalha.refreshInterfaceGrafica();
			}
			
		});
		getContentPane().add(botaoPosicaoAtaque);
	}

	private void criaJanela(int x, int y) {
		setLayout(null);
		setVisible(true);
		setSize(200, 150);
		setResizable(false);
		setLocation(x, y);
	}

}
