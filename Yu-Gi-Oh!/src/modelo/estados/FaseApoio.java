package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseApoio;
import excecoes.ExcecaoFaseCompra;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseApoio implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseApoio(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}

	@Override
	public void mudaParaFasePrincipal1() {
		this.campoDeBatalha.mudaFase(new FasePrincipal1(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseApoio {
		throw new ExcecaoFaseApoio();
	}


}
