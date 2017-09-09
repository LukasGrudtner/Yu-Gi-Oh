package interfaces;

import excecoes.ExcecaoTurno;

public interface Turno {
	
	public void turnoJogador() throws ExcecaoTurno;
	
	public void turnoComputador() throws ExcecaoTurno;

}
