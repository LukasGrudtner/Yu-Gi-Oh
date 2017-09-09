package modelo.estados;

import excecoes.ExcecaoFaseBatalha;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseBatalha implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseBatalha(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFasePrincipal2() {
		this.campoDeBatalha.mudaFase(new FasePrincipal2(this.campoDeBatalha));
	}
}
