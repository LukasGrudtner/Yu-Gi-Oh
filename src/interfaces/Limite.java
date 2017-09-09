package interfaces;

import excecoes.ExcecaoLimite;

public interface Limite {
	
	public void mudaParaLimiteExcedido() throws ExcecaoLimite;
	
	public void mudaParaLimiteNaoExcedido() throws ExcecaoLimite;

}
