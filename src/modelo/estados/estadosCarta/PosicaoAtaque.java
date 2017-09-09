package modelo.estados.estadosCarta;

import excecoes.ExcecaoPosicao;
import excecoes.ExcecaoPosicaoAtaque;
import interfaces.Posicao;
import modelo.Card;
import modelo.CardMonstro;

public class PosicaoAtaque implements Posicao {
	
	private CardMonstro cardMonstro;
	
	public PosicaoAtaque(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaPosicaoAtaque() throws ExcecaoPosicaoAtaque {
		throw new ExcecaoPosicaoAtaque();
	}

	@Override
	public void mudaParaPosicaoDefesa() {
		this.cardMonstro.mudaPosicao(new PosicaoDefesa(this.cardMonstro));
	}

}
