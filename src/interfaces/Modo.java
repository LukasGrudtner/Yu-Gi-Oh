package interfaces;

import excecoes.ExcecaoModo;

public interface Modo {
	
	public void mudaParaModoAtaque() throws ExcecaoModo;
	
	public void mudaParaModoDefesa() throws ExcecaoModo;

}
