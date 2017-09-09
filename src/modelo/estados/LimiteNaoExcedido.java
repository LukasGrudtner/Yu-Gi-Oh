package modelo.estados;

import excecoes.ExcecaoLimiteNaoExcedido;
import interfaces.Limite;
import modelo.Player;

public class LimiteNaoExcedido implements Limite {
	
private Player player;
	
	public LimiteNaoExcedido(Player player) {
		this.player = player;
	}
	
	@Override
	public void mudaParaLimiteExcedido() {
		this.player.mudaLimite(new LimiteExcedido(this.player));
	}

	@Override
	public void mudaParaLimiteNaoExcedido() throws ExcecaoLimiteNaoExcedido {
		throw new ExcecaoLimiteNaoExcedido();
	}
}
