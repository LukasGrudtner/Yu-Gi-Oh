package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teste extends JFrame {
	
	private JButton botao, botao1;
	private JPanel painel, painel1;
	private JLabel background;
	private List<JPanel> listaPaineis;
	
	public Teste() {
		super("TESTE");
		botao = new JButton("Apaga");
		painel = new JPanel();
		
		listaPaineis = new ArrayList<>();
		listaPaineis.add(painel);
		
		setBotao();
		setPanel();
		
		botao = new JButton("Apaga 2");
		painel = new JPanel();
		listaPaineis.add(painel);
		setBotao();
		
		painel.setLayout(null);
		painel.setVisible(true);
		painel.setSize(200, 200);
		painel.setLocation(300, 0);
		getContentPane().add(painel);
		
		background = new JLabel();
		background.setSize(1300, 1800);
		background.setLocation(0, 0);
		background.setIcon(new ImageIcon("resources" + File.separator + "images" + File.separator + "background.png"));
		getContentPane().add(background);
		
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 1800);
		
	}

	private void setBotao() {
		botao.setSize(100, 50);
		botao.setLocation(10, 10);
		botao.setVisible(true);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				listaPaineis.get(0).setVisible(false);
				getContentPane().remove(listaPaineis.get(0));
			}
			
		});
		painel.add(botao);
	}

	private void setPanel() {
		painel.setLayout(null);
		painel.setVisible(true);
		painel.setSize(200, 200);
		painel.setLocation(0, 0);
		getContentPane().add(painel);
	}
	
	public static void main(String[] args) {
		new Teste();
	}

}
