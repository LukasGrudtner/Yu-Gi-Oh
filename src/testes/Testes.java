//package testes;
//
//import static org.junit.Assert.*;
//
//import javax.swing.JOptionPane;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import excecoes.ExcecaoFase;
//import excecoes.ExcecaoTurno;
//import modelo.CampoDeBatalha;
//import modelo.CardMonstro;
//import modelo.Computador;
//import modelo.EfeitoCardsMagia;
//import modelo.Gerenciador;
//import modelo.Jogador;
//import modelo.estados.FaseBatalha;
//import modelo.estados.FasePrincipal1;
//import modelo.estados.FasePrincipal2;
//import modelo.estados.TurnoComputador;
//import modelo.estados.TurnoJogador;
//
//public class Testes {
//
//	Gerenciador gerenciador;
//	CampoDeBatalha campoDeBatalha;
//	Jogador jogador;
//	Computador computador;
//	EfeitoCardsMagia efeitoCardsMagia;
//
//	@Before
//	public void setup() {
//		jogador = new Jogador();
//		computador = new Computador();
//		gerenciador = new Gerenciador(jogador, computador);
//		gerenciador.defineCartasJogador();
//		gerenciador.defineCartasCPU();
//		campoDeBatalha = new CampoDeBatalha(jogador.getDeck(), jogador.getDeckFusao(), computador.getDeck(),
//				computador.getDeckFusao());
//		efeitoCardsMagia = new EfeitoCardsMagia(jogador, computador, campoDeBatalha);
//		gerenciador.setCampoDeBatalha(campoDeBatalha);
//	}
//
//	@Test
//	public void testNumCardsJogador() {
//		int numCardsJogador = jogador.getSizeDeck();
//		assertEquals(44, numCardsJogador);
//	}
//
//	@Test
//	public void testCompra5CardsJogador() {
//		assertEquals(6, campoDeBatalha.getMaoJogador().size());
//		assertEquals(5, campoDeBatalha.getMaoComputador().size());
//
//		campoDeBatalha.compra5CardsInicio(); // n�o ir� executar, pois j� n�o � mais o primeiro turno
//
//		assertEquals(6, campoDeBatalha.getMaoJogador().size());
//		assertEquals(5, campoDeBatalha.getMaoComputador().size());
//	}
//
//	@Test
//	public void testCompraCardFaseInicial() {
//		assertEquals(6, campoDeBatalha.getMaoJogador().size());
//		assertEquals(5, campoDeBatalha.getMaoComputador().size());
//		try {
//			campoDeBatalha.mudaParaFaseBatalha();
//			campoDeBatalha.mudaParaFasePrincipal2();
//			campoDeBatalha.trocaTurno();
//			campoDeBatalha.mudaParaFasePrincipal1();
//		} catch (ExcecaoFase e) {
//			JOptionPane.showMessageDialog(null, "Erro de exce��o de fase no teste!");
//		}
//		assertEquals(6, campoDeBatalha.getMaoComputador().size());
//		assertEquals(6, campoDeBatalha.getMaoJogador().size());
//
//		try {
//			campoDeBatalha.mudaParaFaseBatalha();
//			campoDeBatalha.mudaParaFasePrincipal2();
//			campoDeBatalha.trocaTurno();
//			campoDeBatalha.mudaParaFasePrincipal1();
//		} catch (ExcecaoFase e) {
//			JOptionPane.showMessageDialog(null, "Erro de exce��o de fase no teste!");
//		}
//
//		assertEquals(6, campoDeBatalha.getMaoComputador().size());
//		assertEquals(7, campoDeBatalha.getMaoJogador().size());
//	}
//
//	@Test
//	public void testCompraCardEMandaParaOCemiterio() {
//		campoDeBatalha.addCardMaoJogador();
//		assertEquals(7, campoDeBatalha.getMaoJogador().size());
//		campoDeBatalha.adicionaCardDaMaoDoJogadorAoCemiterio(1);
//		assertEquals(6, campoDeBatalha.getMaoJogador().size());
//		assertEquals(1, campoDeBatalha.getCemiterioJogador().size());
//
//		campoDeBatalha.addCardMaoCPU();
//		assertEquals(6, campoDeBatalha.getMaoComputador().size());
//		campoDeBatalha.adicionaCardDaMaoDoComputadorAoCemiterio(0);
//		assertEquals(5, campoDeBatalha.getMaoComputador().size());
//		assertEquals(1, campoDeBatalha.getCemiterioComputador().size());
//	}
//
//	@Test
//	public void testSeOsCardsCompradosSaoOsDoTopoDoDeck() {
//		String cardTopoDeck1 = campoDeBatalha.getDeckJogador().get(campoDeBatalha.getDeckJogador().size() - 1).getNome();
//		campoDeBatalha.addCardMaoJogador();
//		assertEquals(cardTopoDeck1, campoDeBatalha.getMaoJogador().get(campoDeBatalha.getMaoJogador().size() - 1).getNome());
//				
//		String cardTopoDeck2 = campoDeBatalha.getDeckJogador().get(campoDeBatalha.getDeckJogador().size() - 1).getNome();	
//		campoDeBatalha.addCardMaoJogador();
//		assertEquals(cardTopoDeck2, campoDeBatalha.getMaoJogador().get(campoDeBatalha.getMaoJogador().size() - 1).getNome());
//				
//		String cardTopoDeck3 = campoDeBatalha.getDeckJogador().get(campoDeBatalha.getDeckJogador().size() - 1).getNome();
//		campoDeBatalha.addCardMaoJogador();
//		assertEquals(cardTopoDeck3, campoDeBatalha.getMaoJogador().get(campoDeBatalha.getMaoJogador().size() - 1).getNome());
//				
//		assertEquals(9, campoDeBatalha.getMaoJogador().size());
//
//	}
//	
//	@Test
//	public void testAdicionaCardMonstroDaMaoDoJogadorAoCampo() {
//		campoDeBatalha.addCardMaoJogador();
//		assertEquals(null, campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(0));
//		assertEquals(7, campoDeBatalha.getMaoJogador().size());
//		
//		//Verifica se h� uma carta do tipo CardMonstro na m�o, se n�o tiver, n�o adiciona nada no campo e nem verifica
//		for(int i = 0; i < campoDeBatalha.getMaoJogador().size(); i++){
//			System.out.println("Teste 1: " + campoDeBatalha.getMaoJogador().get(i).getNome());
//			System.out.println("Teste 1: " + campoDeBatalha.getMaoJogador().get(i).getClass());
//			if(campoDeBatalha.getMaoJogador().get(i) instanceof CardMonstro) {
//				System.out.println("Teste 1: " + campoDeBatalha.getMaoJogador().get(i).getNome() + " [PASSOU]");
//				campoDeBatalha.adicionaCardMonstroDaMaoDoJogadorAoCampo(i);
//				assertEquals(1, campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size());
//				break;
//			}
//		}
//		//Verifica se h� uma segunda carta do tipo CardMonstro na m�o, se n�o tiver, n�o adiciona nada no campo e nem verifica
//		for(int i = 0; i < campoDeBatalha.getMaoJogador().size(); i++){
//			System.out.println("Teste 2: " + campoDeBatalha.getMaoJogador().get(i).getNome());
//			System.out.println("Teste 2: " + campoDeBatalha.getMaoJogador().get(i).getClass());
//			if(campoDeBatalha.getMaoJogador().get(i) instanceof CardMonstro) {
//				System.out.println("Teste 2: " + campoDeBatalha.getMaoJogador().get(i).getNome() + " [PASSOU]");
//				campoDeBatalha.adicionaCardMonstroDaMaoDoJogadorAoCampo(i);
//				assertEquals(2, campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size());
//				break;
//			}
//		}
//		
//	}
//
//	@Test
//	public void testTrocaDeFases() throws ExcecaoFase {
//		// Fase Principal 1 -> Fase de Batalha -> Fase Principal 2 -> Fase Principal 1 -> ...
//
//		campoDeBatalha.mudaParaFaseBatalha();
//		boolean testFBatalha = false;
//		if (campoDeBatalha.getFase() instanceof FaseBatalha)
//			testFBatalha = true;
//		assertEquals(testFBatalha, true);
//
//		campoDeBatalha.mudaParaFasePrincipal2();
//		boolean testFPrincipal2 = false;
//		if (campoDeBatalha.getFase() instanceof FasePrincipal2)
//			testFPrincipal2 = true;
//		assertEquals(testFPrincipal2, true);
//		
//		campoDeBatalha.mudaParaFasePrincipal1();
//		boolean testFPrincipal1 = false;
//		if (campoDeBatalha.getFase() instanceof FasePrincipal1)
//			testFPrincipal1 = true;
//		assertEquals(testFPrincipal1, true);
//		
//	}
//	
//	@Test
//	public void testTrocaDeTurnos() throws ExcecaoTurno {
//		// Turno Jogador -> Turno Computador -> Turno Jogador -> ...
//		campoDeBatalha.mudaParaTurnoComputador();
//		boolean testTComputador = false;
//		if (campoDeBatalha.getTurno() instanceof TurnoComputador)
//			testTComputador = true;
//		assertEquals(testTComputador, true);
//		
//		campoDeBatalha.mudaParaTurnoJogador();
//		boolean testTJogador = false;
//		if (campoDeBatalha.getTurno() instanceof TurnoJogador)
//			testTJogador = true;
//		assertEquals(testTJogador, true);
//	}
//	
//	@Test
//	public void testTurnoJogadorDianKeto() throws ExcecaoTurno {
//		assertEquals(8000, jogador.getPontosDeVida());
//		efeitoCardsMagia.DianKetoMestreDaCura();
//		assertEquals(9000, jogador.getPontosDeVida());
//	}
//	
//	// Teste Efeito dos Cards Monstros
//	@Test
//	public void testTurnoComputadorDianKeto() throws ExcecaoTurno {
//		campoDeBatalha.mudaParaTurnoComputador();
//		assertEquals(8000, computador.getPontosDeVida());
//		efeitoCardsMagia.DianKetoMestreDaCura();
//		assertEquals(9000, computador.getPontosDeVida());
//	}
//
//	@Test
//	public void testPoteDaGanancia() {
//		efeitoCardsMagia.PoteDaGanancia();
//		assertEquals(8, campoDeBatalha.getMaoJogador().size());
//	}
//	
//	
//
//}
