package modelo.estados.estadosCarta;

import excecoes.ExcecaoModo;
import excecoes.ExcecaoModoDefesa;
import interfaces.Modo;
import modelo.Card;
import modelo.CardMonstro;

public class ModoDefesa implements Modo {
	
	private CardMonstro cardMonstro;
	
	public ModoDefesa(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaModoAtaque() {
		this.cardMonstro.mudaModo(new ModoAtaque(this.cardMonstro));
	}

	@Override
	public void mudaParaModoDefesa() throws ExcecaoModoDefesa {
		throw new ExcecaoModoDefesa();
	}

}
