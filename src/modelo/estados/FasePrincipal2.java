package modelo.estados;

import excecoes.ExcecaoFasePrincipal2;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FasePrincipal2 implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FasePrincipal2(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFasePrincipal1() {
		this.campoDeBatalha.mudaFase(new FasePrincipal1(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}
}
