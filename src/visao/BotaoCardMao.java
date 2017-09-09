package visao;

import javax.swing.JButton;

public class BotaoCardMao extends JButton {

	private static final long serialVersionUID = 1L;
	int posicaoCardMao;
	
	public BotaoCardMao(int posicaoCardMao) {
		this.posicaoCardMao = posicaoCardMao;
	}
	
	public int getPosicao(){
		return this.posicaoCardMao;
	}

}
