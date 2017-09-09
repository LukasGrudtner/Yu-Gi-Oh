package modelo.estados.estadosInvocacao;

import excecoes.ExcecaoInvocacao;
import excecoes.ExcecaoMonstroInvocado;
import interfaces.Invocacao;
import modelo.CampoDeBatalha;

public class MonstroInvocado implements Invocacao {
	
	private CampoDeBatalha campoDeBatalha;

	public MonstroInvocado(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}
	@Override
	public void mudaParaMonstroInvocado() throws ExcecaoMonstroInvocado {
		throw new ExcecaoMonstroInvocado();
	}

	@Override
	public void mudaParaMonstroNaoInvocado() {
		this.campoDeBatalha.mudaInvocacao(new MonstroNaoInvocado(this.campoDeBatalha));
	}

}
