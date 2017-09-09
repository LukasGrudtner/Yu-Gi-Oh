package modelo.estados.estadosCard;

import excecoes.ExcecaoFace;
import excecoes.ExcecaoFaceParaCima;
import interfaces.Face;
import modelo.Card;

public class FaceParaCima implements Face {
	
	private Card card;
	
	public FaceParaCima(Card card) {
		this.card = card;
	}

	@Override
	public void mudaFaceParaBaixo() throws ExcecaoFaceParaCima {
		throw new ExcecaoFaceParaCima();
	}

	@Override
	public void mudaFaceParaCima() throws ExcecaoFaceParaCima {
		throw new ExcecaoFaceParaCima();
	}

}
