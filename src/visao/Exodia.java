package visao;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exodia extends JPanel {

	JLabel labelCardMonstro, exodia;
	ImageIcon cardAtaque;
	int y = 380;

	public void criaExodia() {
		labelCardMonstro = new JLabel();
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque"
				+ File.separator + "Perna Direita do Proibido.png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(673, 525);
		add(labelCardMonstro);

		labelCardMonstro = new JLabel();
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque"
				+ File.separator + "Braço Direito do Proibido.png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(673, 390);
		add(labelCardMonstro);

		labelCardMonstro = new JLabel();
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque"
				+ File.separator + "Exódia, o Proibido.png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(765, y);
		add(labelCardMonstro);

		labelCardMonstro = new JLabel();
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque"
				+ File.separator + "Braço Esquerdo do Proibido.png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(857, 390);
		add(labelCardMonstro);

		labelCardMonstro = new JLabel();
		cardAtaque = new ImageIcon("resources" + File.separator + "images" + File.separator + "cardsAtaque"
				+ File.separator + "Perna Esquerda do Proibido.png");
		labelCardMonstro.setSize(92, 134);
		labelCardMonstro.setIcon(cardAtaque);
		labelCardMonstro.setLocation(857, 525);
		add(labelCardMonstro);

		exodia = new JLabel();
		exodia.setSize(600, 338);
		exodia.setLocation(500, 30);
		exodia.setIcon(new ImageIcon("resources" + File.separator + "Exodia3.gif"));
		exodia.setVisible(true);
		add(exodia);

		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "Exodia3.wav");
	}

}
