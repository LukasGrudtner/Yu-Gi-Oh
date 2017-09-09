package modelo.estados;

import javax.swing.JOptionPane;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFasePrincipal1;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import modelo.CampoDeBatalha;

public class FasePrincipal1 implements Fase {

	private CampoDeBatalha campoDeBatalha;

	public FasePrincipal1(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		this.compraCard();
		//verifica cards magia que são ativados na fase de apoio
		//permite o jogador do turno invocar 1 card monstro e cards magia/armadilha
	}

	public void compraCard() {

		if (campoDeBatalha.getTurno() instanceof TurnoJogador)
			campoDeBatalha.addCardMaoJogador();

		if (campoDeBatalha.getTurno() instanceof TurnoComputador)
			campoDeBatalha.addCardMaoCPU();
	}

	@Override
	public void mudaParaFasePrincipal1() {
		this.campoDeBatalha.mudaFase(new FasePrincipal1(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFaseBatalha() {
		this.campoDeBatalha.mudaFase(new FaseBatalha(this.campoDeBatalha));
	}

	@Override
	public void mudaParaFasePrincipal2() throws ExcecaoFasePrincipal1 {
		throw new ExcecaoFasePrincipal1();
	}
}
