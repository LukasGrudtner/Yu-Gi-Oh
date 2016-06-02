package modelo.estados.estadosBatalha;

import excecoes.ExcecaoFase;
import excecoes.excecoesBatalha.ExcecaoFaseBatalhaEtapaBatalha;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseBatalhaEtapaBatalha implements Fase {
	
	CampoDeBatalha campoDeBatalha;
	
	public FaseBatalhaEtapaBatalha(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() {
		this.campoDeBatalha.mudaFase(new FaseBatalhaEtapaDano(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseBatalhaEtapaBatalha {
		throw new ExcecaoFaseBatalhaEtapaBatalha();
	}

}
