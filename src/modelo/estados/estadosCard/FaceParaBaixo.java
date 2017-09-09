package modelo.estados.estadosCard;

import excecoes.ExcecaoFaceParaBaixo;
import interfaces.Face;
import modelo.Card;

public class FaceParaBaixo implements Face {
	
	private Card card;
	
	public FaceParaBaixo(Card card) {
		this.card = card;
	}

	@Override
	public void mudaFaceParaBaixo() throws ExcecaoFaceParaBaixo {
		throw new ExcecaoFaceParaBaixo();
	}

	@Override
	public void mudaFaceParaCima() {
		this.card.mudaFace(new FaceParaCima(this.card));
	}

}
