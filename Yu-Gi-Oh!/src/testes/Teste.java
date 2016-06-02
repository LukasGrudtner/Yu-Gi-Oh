package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.CampoDeBatalha;
import modelo.decks.YugiMuto;
import modelo.estados.FaseApoio;

public class Teste {
	
	private YugiMuto yugi = new YugiMuto();
	private CampoDeBatalha campoDeBatalha;
	
	@Before
	public void test() {
		yugi = new YugiMuto();
	}

	@Test
	public void testaCartasNoDeck() {
		System.out.println(yugi.toString());
	}
	
	@Test
	public void testaFasesCampoDeBatalha() {
//		campoDeBatalha.mudaFase(new FaseApoio(this.campoDeBatalha));
//		System.out.println(campoDeBatalha.getFase());
	}

}
