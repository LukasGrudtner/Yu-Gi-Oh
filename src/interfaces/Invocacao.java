package interfaces;

import excecoes.ExcecaoInvocacao;

public interface Invocacao {
	
	public void mudaParaMonstroInvocado() throws ExcecaoInvocacao;
	
	public void mudaParaMonstroNaoInvocado() throws ExcecaoInvocacao;

}
