package modelo.estados;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFaseBatalha;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FaseBatalha implements Fase {
	
	private CampoDeBatalha campoDeBatalha;
	
	public FaseBatalha(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		// o jogador do turno escolhe 1 carta alvo e 1 carta fonte
		// o ataque da carta fonte é comparado com a defesa da carta alvo
		// e o dano é calculado, caso não haja cartas de monstros no campo inimigo
		// poderá atacar diretamente a vida do oponente
	}

	@Override
	public void mudaParaFasePrincipal1() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFaseBatalha() throws ExcecaoFaseBatalha {
		throw new ExcecaoFaseBatalha();
	}

	@Override
	public void mudaParaFasePrincipal2() {
		this.campoDeBatalha.mudaFase(new FasePrincipal2(this.campoDeBatalha));
	}
}
