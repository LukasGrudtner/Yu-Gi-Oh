package modelo.estados.estadosInvocacao;

import excecoes.ExcecaoMonstroNaoInvocado;
import interfaces.Invocacao;
import modelo.CampoDeBatalha;

public class MonstroNaoInvocado implements Invocacao {
	
	private CampoDeBatalha campoDeBatalha;
	
	public MonstroNaoInvocado(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void mudaParaMonstroInvocado() {
		this.campoDeBatalha.mudaInvocacao(new MonstroInvocado(this.campoDeBatalha));
	}

	@Override
	public void mudaParaMonstroNaoInvocado() throws ExcecaoMonstroNaoInvocado {
		throw new ExcecaoMonstroNaoInvocado();
	}

}
