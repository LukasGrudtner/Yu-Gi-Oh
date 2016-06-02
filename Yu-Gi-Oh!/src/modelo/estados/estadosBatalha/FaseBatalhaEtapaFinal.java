package modelo.estados.estadosBatalha;

import excecoes.ExcecaoFase;
import excecoes.excecoesBatalha.ExcecaoFaseBatalhaEtapaFinal;
import interfaces.Fase;
import modelo.CampoDeBatalha;
import modelo.estados.FasePrincipal2;

public class FaseBatalhaEtapaFinal implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseBatalhaEtapaFinal(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}

	@Override
	public void mudaParaFasePrincipal2() {
		this.campoDeBatalha.mudaFase(new FasePrincipal2(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseBatalhaEtapaFinal {
		throw new ExcecaoFaseBatalhaEtapaFinal();
	}
	

}
