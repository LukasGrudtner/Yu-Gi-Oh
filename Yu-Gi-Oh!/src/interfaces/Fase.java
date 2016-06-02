package interfaces;

import excecoes.ExcecaoFase;

public interface Fase {
	
	public void mudaParaFaseCompra() throws ExcecaoFase;
	
	public void mudaParaFaseApoio() throws ExcecaoFase;
	
	public void mudaParaFasePrincipal1() throws ExcecaoFase;
	
	public void mudaParaFaseBatalha() throws ExcecaoFase;
	
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFase;
	
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFase;
	
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFase;
	
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFase;
	
	public void mudaParaFasePrincipal2() throws ExcecaoFase;
	
	public void mudaParaFaseFinal() throws ExcecaoFase;

}
