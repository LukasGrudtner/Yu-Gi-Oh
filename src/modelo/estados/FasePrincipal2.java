package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFasePrincipal2;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FasePrincipal2 implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FasePrincipal2(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		// permite ao jogador invocar 1 card monstro(caso ele não o tenha feito na P1)
		// e invocar qnts cards magia e armadilha quiser
		// verificar efeitos que são ativados na P2
	}

	@Override
	public void mudaParaFasePrincipal1() {
		this.campoDeBatalha.mudaFase(new FasePrincipal1(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFasePrincipal2 {
		throw new ExcecaoFasePrincipal2();
	}
}
