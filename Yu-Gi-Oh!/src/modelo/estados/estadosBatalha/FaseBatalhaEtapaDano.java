package modelo.estados.estadosBatalha;

import excecoes.ExcecaoFase;
import excecoes.excecoesBatalha.ExcecaoFaseBatalhaEtapaDano;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseBatalhaEtapaDano implements Fase {
	
	CampoDeBatalha campoDeBatalha;
	
	public FaseBatalhaEtapaDano(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() {
		this.campoDeBatalha.mudaFase(new FaseBatalhaEtapaBatalha(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() {
		this.campoDeBatalha.mudaFase(new FaseBatalhaEtapaFinal(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseBatalhaEtapaDano {
		throw new ExcecaoFaseBatalhaEtapaDano();
	}

}
