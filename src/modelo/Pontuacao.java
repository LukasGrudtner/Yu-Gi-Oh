package modelo;

import java.io.Serializable;

public class Pontuacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int vitorias, derrotas, danoTomado, danoCausado, cartasJogadas, cartasPerdidas, cartasCompradas, numRodadas;
	
	public void aumentaNumVitorias() {
		this.vitorias++;
	}
	
	public void aumentaNumDerrotas() {
		this.derrotas++;
	}
	
	public void aumentaDanoTomado(int dano) {
		this.danoTomado += dano;
	}
	
	public void aumentaDanoCausado(int dano) {
		this.danoCausado += dano;
	}
	
	public void aumentaNumCartasJogadas() {
		this.cartasJogadas++;
	}
	
	public void aumentaNumCartasPerdidas() {
		this.cartasPerdidas++;
	}
	
	public void aumentaNumCartasCompradas() {
		this.cartasCompradas++;
	}
	
	public void aumentaNumRodadas(){
		this.numRodadas++;
	}
	
	public int getNumVitorias() {
		return this.vitorias;
	}
	
	public int getNumDerrotdas() {
		return this.derrotas;
	}
	
	public int getDanoTomado() {
		return this.danoTomado;
	}
	
	public int getDanoCausado() {
		return this.danoCausado;
	}
	
	public int getNumCartasJogadas() {
		return this.cartasJogadas;
	}
	
	public int getNumCartasPerdidas() {
		return this.cartasPerdidas;
	}
	
	public int getNumCartasCompradas() {
		return this.cartasCompradas;
	}
	
	public int getNumRodadas() {
		return this.numRodadas;
	}
}
