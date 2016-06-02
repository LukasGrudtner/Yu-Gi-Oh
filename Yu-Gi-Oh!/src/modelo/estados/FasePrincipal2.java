package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFasePrincipal2;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FasePrincipal2 implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FasePrincipal2(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFaseFinal() {
		this.campoDeBatalha.mudaFase(new FaseFinal(this.campoDeBatalha));
	}

}
