package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseBatalha;
import interfaces.Fase;
import modelo.CampoDeBatalha;
import modelo.estados.estadosBatalha.FaseBatalhaEtapaInicial;

public class FaseBatalha implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseBatalha(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}
	
	public void mudaParaFaseBatalhaEtapaInicial() {
		this.campoDeBatalha.mudaFase(new FaseBatalhaEtapaInicial(this.campoDeBatalha));
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}
	
	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}


}
