package modelo.estados;

import java.io.File;

import javax.swing.JOptionPane;

import excecoes.ExcecaoFase;
import excecoes.ExcecaoFasePrincipal1;
import excecoes.ExcecaoInvocacao;
import excecoes.ExcecaoTurno;
import interfaces.Fase;
import modelo.CampoDeBatalha;
import visao.PlaySound;

public class FasePrincipal1 implements Fase {

	private CampoDeBatalha campoDeBatalha;

	public FasePrincipal1(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		this.compraCard();
		this.mudaParaMonstroNaoInvocado();
		this.mudaCardsMonstrosParaAtaqueNaoRelizado();
		this.verificaLimiteCardsNaMao();
		// verifica cards magia que são ativados na fase de apoio
		// permite o jogador do turno invocar 1 card monstro e cards
		// magia/armadilha
	}
	
	public void verificaLimiteCardsNaMao() {
		if(campoDeBatalha.getMaoJogador().size() == 6)
			campoDeBatalha.mudaParaLimiteExedidoJogador();
		if(campoDeBatalha.getMaoComputador().size() == 6)
			campoDeBatalha.mudaParaLimiteExcedidoComputador();
	}

	public void mudaParaMonstroNaoInvocado() {
		try {
			campoDeBatalha.mudaParaMonstroNaoInvocado();
		} catch (ExcecaoInvocacao e) {
		}
	}

	public void mudaCardsMonstrosParaAtaqueNaoRelizado() {
		campoDeBatalha.resetAtaqueCards();
	}

	public void compraCard() {

		if (campoDeBatalha.getTurno() instanceof TurnoJogador)
			if (campoDeBatalha.getMaoJogador().size() < 7){
				campoDeBatalha.addCardMaoJogador();
				PlaySound p = new PlaySound();
				p.playSound("resources" + File.separator + "DrawCard.wav");
			}

		if (campoDeBatalha.getTurno() instanceof TurnoComputador)
			if (campoDeBatalha.getMaoComputador().size() < 7) {
				campoDeBatalha.addCardMaoCPU();
				PlaySound p = new PlaySound();
				p.playSound("resources" + File.separator + "DrawCard.wav");	
			}
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
