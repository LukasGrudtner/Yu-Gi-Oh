package modelo.estados;

import javax.swing.JOptionPane;

import modelo.CampoDeBatalha;
import excecoes.ExcecaoTurno;
import excecoes.ExcecaoTurnoComputador;
import interfaces.Turno;

public class TurnoComputador implements Turno {
	
	CampoDeBatalha campoDeBatalha;
	
	public TurnoComputador(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	@Override
	public void turnoJogador() {
		this.campoDeBatalha.mudaTurno(new TurnoJogador(this.campoDeBatalha));
	}

	@Override
	public void turnoComputador() throws ExcecaoTurnoComputador {
		throw new ExcecaoTurnoComputador();
	}

}
