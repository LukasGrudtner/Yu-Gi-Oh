package modelo.estados.estadosBatalha;


import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseBatalha;
import excecoes.excecoesBatalha.ExcecaoFaseBatalhaEtapaInicial;
import interfaces.Fase;
import modelo.CampoDeBatalha;
import modelo.estados.FaseBatalha;

public class FaseBatalhaEtapaInicial implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseBatalhaEtapaInicial(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaFaseCompra() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseApoio() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaInicial() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaBatalha() {
		this.campoDeBatalha.mudaFase(new FaseBatalhaEtapaBatalha(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalhaEtapaDano() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseBatalhaEtapaFinal() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}

	@Override
	public void mudaParaFaseFinal() throws ExcecaoFaseBatalhaEtapaInicial {
		throw new ExcecaoFaseBatalhaEtapaInicial();
	}


}
