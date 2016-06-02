package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseCompra;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseCompra implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseCompra(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
		
	}

	@Override
	public void mudaParaFaseApoio() {
		this.campoDeBatalha.mudaFase(new FaseApoio(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}
	
	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseCompra {
		throw new ExcecaoFaseCompra();
	}


}
