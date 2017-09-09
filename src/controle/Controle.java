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
	private ListaCards listaCards;
	
	public Controle() {
		this.Corpo();
	}
	
	private void Corpo() {
		
		listaCards = new ListaCards();
		jogador = new Jogador(listaCards.getDeckFusao());
		computador = new Computador();
		gerenciador = new Gerenciador(jogador, computador);
		gerenciador.defineCartasJogador();
		gerenciador.defineCartasCPU();
		campoDeBatalha = new CampoDeBatalha(jogador, computador, jogador.getDeck(), jogador.getDeckFusao(), computador.getDeck(), computador.getDeckFusao());
		interfaceGrafica = new InterfaceGrafica(campoDeBatalha);
		//campoDeBatalha.setInicioJogo();
//		efeitoCardsMagia = new EfeitoCardsMagia(jogador, computador, campoDeBatalha);
		gerenciador.setCampoDeBatalha(campoDeBatalha);
		campoDeBatalha.setInterfaceGrafica(interfaceGrafica);
	}
	
	public static void main(String[] args) {
		new Controle();
	}
}
