package visao;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PilhaJogador extends JPanel {
	
	JLabel pilhaCards;
	
	public PilhaJogador(int numCardsPilha) {
		atualizaPilhaJogador(numCardsPilha);
		criaPainel();
	}
	
	public void atualizaPilhaJogador(int numCardsPilha) {
		pilhaCards = new JLabel();
		pilhaCards.setSize(111, 153);
		pilhaCards.setVisible(true);
		pilhaCards.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "pilhaCards" + File.separator + "jogador" + File.separator + (numCardsPilha / 2) + ".png" ));
		this.add(pilhaCards);
	}
	
	public void criaPainel() {
		setLayout(null);
		setSize(111, 153);
		setVisible(true);
		setLocation(1170, 500);
		setOpaque(false);
	}

}
