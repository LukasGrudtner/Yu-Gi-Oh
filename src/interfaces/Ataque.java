package interfaces;

import excecoes.ExcecaoAtaque;

public interface Ataque {
	
	public void mudaParaAtaqueRealizado() throws ExcecaoAtaque;
	
	public void mudaParaAtaqueNaoRealizado() throws ExcecaoAtaque;

}
