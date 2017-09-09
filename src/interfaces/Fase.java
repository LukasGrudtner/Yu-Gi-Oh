package interfaces;

import excecoes.ExcecaoFase;

public interface Fase {
	
	
	public void mudaParaFasePrincipal1() throws ExcecaoFase;
	
	public void mudaParaFaseBatalha() throws ExcecaoFase;
	
	public void mudaParaFasePrincipal2() throws ExcecaoFase;

}
