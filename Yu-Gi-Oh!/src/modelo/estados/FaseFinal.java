package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseFinal;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseFinal implements Fase {
	
	CampoDeBatalha campoDeBatalha;
	
	public FaseFinal(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseFinal {
		throw new ExcecaoFaseFinal();
	}

}
