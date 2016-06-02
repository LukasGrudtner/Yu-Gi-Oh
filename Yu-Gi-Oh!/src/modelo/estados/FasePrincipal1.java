package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFasePrincipal1;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FasePrincipal1 implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FasePrincipal1(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}

	@Override
	public void mudaParaFaseBatalha() {
		this.campoDeBatalha.mudaFase(new FaseBatalha(this.campoDeBatalha));
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}


}
