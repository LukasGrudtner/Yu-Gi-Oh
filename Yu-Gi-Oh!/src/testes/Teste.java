package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.decks.YugiMuto;

public class Teste {
	
	private YugiMuto yugi = new YugiMuto();
	
	@Before
	public void test() {
		yugi = new YugiMuto();
	}

	@Test
	public void testaCartasNoDeck() {
		System.out.println(yugi.toString());
	}

}
