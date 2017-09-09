package modelo.estados.estadosCard;

import excecoes.ExcecaoPosicaoAtaque;
import interfaces.Posicao;
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
		((CardMonstro) this.cardMonstro).mudaPosicao(new PosicaoDefesa(this.cardMonstro));
	}

}
