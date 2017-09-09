package controle;

import visao.InterfaceGrafica;
import excecoes.ExcecaoFase;
import modelo.CampoDeBatalha;
import modelo.Computador;
import modelo.EfeitoCardsMagia;
import modelo.Gerenciador;
import modelo.Jogador;
import modelo.decks.ListaCards;
import modelo.estados.TurnoJogador;

public class Controle {
	
	private Gerenciador gerenciador;
	private Jogador jogador;
	private Computador computador;
	private CampoDeBatalha campoDeBatalha;
	private EfeitoCardsMagia efeitoCardsMagia;
	private InterfaceGrafica interfaceGrafica;
	
	public Controle() {
		this.Corpo();
	}
	
	private void Corpo() {
		
		jogador = new Jogador();
		computador = new Computador();
		gerenciador = new Gerenciador(jogador, computador);
		gerenciador.defineCartasJogador();
		gerenciador.defineCartasCPU();
		campoDeBatalha = new CampoDeBatalha(jogador.getDeck(), jogador.getDeckFusao(), computador.getDeck(), computador.getDeckFusao());
		efeitoCardsMagia = new EfeitoCardsMagia(jogador, computador, campoDeBatalha);
		gerenciador.setCampoDeBatalha(campoDeBatalha);
		interfaceGrafica = new InterfaceGrafica(campoDeBatalha);
	}
	
	public static void main(String[] args) {
		new Controle();
	}
		
		

}
