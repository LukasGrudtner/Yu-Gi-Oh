package interfaces;

import excecoes.ExcecaoPosicao;

public interface Posicao {
	
	public void mudaParaPosicaoAtaque() throws ExcecaoPosicao;
	
	public void mudaParaPosicaoDefesa() throws ExcecaoPosicao;

}
