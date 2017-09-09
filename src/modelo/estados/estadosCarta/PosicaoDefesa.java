package modelo.estados.estadosCarta;

import excecoes.ExcecaoPosicao;
import excecoes.ExcecaoPosicaoDefesa;
import interfaces.Posicao;
import modelo.Card;
import modelo.CardMonstro;

public class PosicaoDefesa implements Posicao {
	
	private CardMonstro cardMonstro;
	
	public PosicaoDefesa(CardMonstro cardMonstro) {
		this.cardMonstro = cardMonstro;
	}

	@Override
	public void mudaParaPosicaoAtaque() {
		this.cardMonstro.mudaPosicao(new PosicaoAtaque(this.cardMonstro));
	}

	@Override
	public void mudaParaPosicaoDefesa() throws ExcecaoPosicaoDefesa {
		throw new ExcecaoPosicaoDefesa();
	}

}
