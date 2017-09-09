package visao;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PilhaComputador extends JPanel {
	
	JLabel pilhaCards;
	
	public PilhaComputador(int numCardsPilha) {
		atualizaPilhaComputador(numCardsPilha);
		criaPainel();
	}
	
	public void atualizaPilhaComputador(int numCardsPilha) {
		pilhaCards = new JLabel();
		pilhaCards.setSize(111, 153);
		pilhaCards.setVisible(true);
		pilhaCards.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "pilhaCards" + File.separator + "computador" + File.separator + (numCardsPilha/2) + ".png"));
		this.add(pilhaCards);
	}
	
	public void criaPainel() {
		setLayout(null);
		setSize(111, 153);
		setVisible(true);
		setLocation(350, 90);
		setOpaque(false);
	}
	

}
