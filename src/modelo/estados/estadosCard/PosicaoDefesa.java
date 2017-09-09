package modelo.estados.estadosCard;

import excecoes.ExcecaoPosicaoDefesa;
import interfaces.Posicao;
import modelo.CardMonstro;

public class PosicaoDefesa implements Posicao {
	
	private CardMonstro cardMonstro;
	
	public PosicaoDefesa(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaPosicaoAtaque() {
		((CardMonstro) this.cardMonstro).mudaPosicao(new PosicaoAtaque(this.cardMonstro));
	}

	@Override
	public void mudaParaPosicaoDefesa() throws ExcecaoPosicaoDefesa {
		throw new ExcecaoPosicaoDefesa();
	}

}
