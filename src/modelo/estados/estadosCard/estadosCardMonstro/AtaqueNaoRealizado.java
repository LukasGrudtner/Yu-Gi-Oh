package modelo.estados.estadosCard.estadosCardMonstro;

import excecoes.ExcecaoAtaque;
import excecoes.ExcecaoAtaqueNaoRealizado;
import interfaces.Ataque;
import modelo.CardMonstro;

public class AtaqueNaoRealizado implements Ataque {
	
	CardMonstro cardMonstro;
	
	public AtaqueNaoRealizado(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaAtaqueRealizado() {
		cardMonstro.mudaAtaque(new AtaqueRealizado(this.cardMonstro));
	}

	@Override
	public void mudaParaAtaqueNaoRealizado() {
		cardMonstro.mudaAtaque(new AtaqueNaoRealizado(this.cardMonstro));
	}

}
