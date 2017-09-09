package modelo.estados;

import modelo.CampoDeBatalha;
import excecoes.ExcecaoTurnoJogador;
import interfaces.Turno;

public class TurnoJogador implements Turno {
	
	CampoDeBatalha campoDeBatalha;
	
	public TurnoJogador(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		campoDeBatalha.compra5CardsInicio();
	}

	@Override
	public void turnoJogador() throws ExcecaoTurnoJogador {
		throw new ExcecaoTurnoJogador();
		
	}

	@Override
	public void turnoComputador() {
		this.campoDeBatalha.mudaTurno(new TurnoComputador(this.campoDeBatalha));
	}

}
