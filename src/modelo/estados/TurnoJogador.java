package modelo.estados;

import javax.swing.JOptionPane;

import modelo.CampoDeBatalha;
import excecoes.ExcecaoTurno;
import excecoes.ExcecaoTurnoJogador;
import interfaces.Turno;

public class TurnoJogador implements Turno {
	
	CampoDeBatalha campoDeBatalha;
	
	public TurnoJogador(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
		campoDeBatalha.compra5CardsInicio();
		System.out.println("Turno Jogador");
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
