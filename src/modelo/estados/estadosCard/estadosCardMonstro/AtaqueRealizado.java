package modelo.estados.estadosCard.estadosCardMonstro;

import excecoes.ExcecaoAtaqueRealizado;
import interfaces.Ataque;
import modelo.CardMonstro;

public class AtaqueRealizado implements Ataque {
	
	CardMonstro cardMonstro;
	
	public AtaqueRealizado(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaAtaqueRealizado() throws ExcecaoAtaqueRealizado {
		throw new ExcecaoAtaqueRealizado();
	}

	@Override
	public void mudaParaAtaqueNaoRealizado() {
		cardMonstro.mudaAtaque(new AtaqueNaoRealizado(this.cardMonstro));
	}

}
