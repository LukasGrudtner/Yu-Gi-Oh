package modelo.estados;

import excecoes.ExcecaoLimite;
import excecoes.ExcecaoLimiteExcedido;
import interfaces.Limite;
import modelo.CampoDeBatalha;
import modelo.Computador;
import modelo.Jogador;
import modelo.Player;

public class LimiteExcedido implements Limite {
	
	private Player player;
	
	public LimiteExcedido(Player player) {
		this.player = player;
	}

	@Override
	public void mudaParaLimiteExcedido() throws ExcecaoLimiteExcedido {
		throw new ExcecaoLimiteExcedido();
	}

	@Override
	public void mudaParaLimiteNaoExcedido() {
		this.player.mudaLimite(new LimiteNaoExcedido(this.player));
	}

}
