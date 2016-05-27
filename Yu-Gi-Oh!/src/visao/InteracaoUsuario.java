package visao;

import javax.swing.JOptionPane;

public class InteracaoUsuario {
	
	public int pegaInt(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}
	
	public double pegaDouble(String msg) {
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
	}
	
	public String pegaString(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	public void imprimeString(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	

}
