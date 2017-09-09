package modelo;

import excecoes.ExcecaoLimite;
import interfaces.Limite;

public abstract class Player {
	
	public abstract void mudaLimite(Limite limite);
	
	public abstract Limite getLimite();
	
	public abstract void mudaParaLimiteExcedido() throws ExcecaoLimite;
	
	public abstract void mudaParaLimiteNaoExcedido() throws ExcecaoLimite;

}
