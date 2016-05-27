package modelo;

import java.util.Random;

import visao.InteracaoUsuario;

public class Gerenciador {
	
	InteracaoUsuario iu = new InteracaoUsuario();
	
	public void defineQuemJogaPrimeiro() {
		Random gerador = new Random();
		int sorteio = gerador.nextInt(2);
		int moeda = iu.pegaInt("Cara ou coroa?" + "\n\n0.Cara\n1.Coroa");
		if(sorteio == moeda)
			iu.imprimeString("Você joga primeiro!");
		else
			iu.imprimeString("O computador joga primeiro.");
	}

}
