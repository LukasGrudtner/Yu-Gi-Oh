package visao;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JPanel {
	
	private JLabel counter1, counter2, counter3, counter4;
	
	public Counter(int x, int y) {
		criaCounters();
		criaPainel(x, y);
	}
	
	private void criaCounters() {
		counter1 = new JLabel();
		counter1.setSize(100, 1000);
		counter1.setLocation(0, -800);
		counter1.setVisible(true);
		counter1.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "Numbers.png"));
		add(counter1);
		
		counter2 = new JLabel();
		counter2.setSize(100, 1000);
		counter2.setLocation(80, 0);
		counter2.setVisible(true);
		counter2.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "Numbers.png"));
		add(counter2);
		
		counter3 = new JLabel();
		counter3.setSize(100, 1000);
		counter3.setLocation(160, 0);
		counter3.setVisible(true);
		counter3.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "Numbers.png"));
		add(counter3);
		
		counter4 = new JLabel();
		counter4.setSize(100, 1000);
		counter4.setLocation(240, 0);
		counter4.setVisible(true);
		counter4.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "Numbers.png"));
		add(counter4);
	}
	
	private void criaPainel(int x, int y) {
		setSize(400, 100);
		setLocation(x, y);
		setVisible(true);
		setOpaque(false);
		setLayout(null);
	}
	
	public void startCounter(int lifePoints) {
		PlaySound p = new PlaySound();
		p.playSound("resources" + File.separator + "LifeSounds.wav");
		
		if(lifePoints < 0)
			lifePoints = 0;
		
		String LP = Integer.toString(lifePoints);
		if(LP.length() == 1)
			LP = "000" + LP;
		if(LP.length() == 2)
			LP = "00" + LP;
		if(LP.length() == 3)
			LP = "0" + LP;
		
		String array[] = new String[LP.length()];
		array = LP.split("");
		
		new LifePoints(Integer.parseInt(array[0]), counter1);
		new LifePoints(Integer.parseInt(array[1]), counter2);
		new LifePoints(Integer.parseInt(array[2]), counter3);
		new LifePoints(Integer.parseInt(array[3]), counter4);
	}
	
	

}
