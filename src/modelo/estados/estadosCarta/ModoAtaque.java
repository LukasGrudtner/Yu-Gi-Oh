package modelo.estados.estadosCarta;

import excecoes.ExcecaoModo;
import excecoes.ExcecaoModoAtaque;
import interfaces.Modo;
import modelo.Card;
import modelo.CardMonstro;

public class ModoAtaque implements Modo {
	
	private CardMonstro cardMonstro;
	
	public ModoAtaque(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaModoAtaque() throws ExcecaoModoAtaque {
		throw new ExcecaoModoAtaque();
	}

	@Override
	public void mudaParaModoDefesa() {
		this.cardMonstro.mudaModo(new ModoDefesa(this.cardMonstro));
	}

}
