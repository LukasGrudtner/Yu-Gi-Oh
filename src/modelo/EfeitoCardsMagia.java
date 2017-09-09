package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import excecoes.ExcecaoFase;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;

public class EfeitoCardsMagia {
	
	CampoDeBatalha campoDeBatalha;
	Jogador jogador;
	Computador computador;
	
	public EfeitoCardsMagia(Jogador jogador, Computador computador, CampoDeBatalha campoDeBatalha) {
		this.jogador = jogador;
		this.computador = computador;
		this.campoDeBatalha = campoDeBatalha;
	}
	
	// Implementar um método maior que cobre todos os metodos de efeitos de magia. Ele recebe o nº do card como parâmetro, e com o switch case define
	// qual método será usado.
	
	public void AlmaLivre() {
		// Escolha até 5 cards em quaisquer cemitérios; bana-os.
		int limite = 5;
		
		do {
			for(int i = 0; i < campoDeBatalha.getCemiterioJogador().size(); i++) {
				String remove = JOptionPane.showInputDialog("Deseja remover este card?\n\n" + campoDeBatalha.getCemiterioJogador().get(i).getNome()
										+ "\n\n" + campoDeBatalha.getCemiterioJogador().get(i).getDescricao());
										
				if(remove.equalsIgnoreCase("Sim")) {
					campoDeBatalha.removeCardCemiterio(campoDeBatalha.getCemiterioJogador().get(i).getNome());
					JOptionPane.showMessageDialog(null, "Esta carta foi banida do Jogo!");
					limite--;
				}
			}
		} while(limite != 0);
	}
	
	public void ArremetidaImprudente() {
		// Escolha 1 monstro com a face para cima no campo; ele ganha 700 de ATK até a Fase Final.
	}
	
	public void BrumasMagicasDeMakiu() {
		// Escolha 1 "Summoned Skull" ou monstro do Tipo Trovão que você controla; destrua todos os monstros que seu oponente controla com DEF 
		// menor ou igual ao ATK desse monstro. Você não pode conduzir sua Fase de Batalha no turno em que ativar este card.
	}
	
	public void BuracoNegro() {
		// Destrua todos os monstros no campo.
		campoDeBatalha.removeTodosOsCardsMonstrosNoCampoDoJogador();
		campoDeBatalha.removeTodosOsCardsMonstrosNoCampoDoComputador();
	}
	
	public void CaixaMagica() {
		// Escolha 1 montro que seu oponente controla e 1 monstro que você controla, destrua o primeiro alvo e, depois, conceda o controle do 
		// segundo alvo ao seu oponente.
		
		// Concatena todos os nomes dos monstros em campo do computador em 1 string
		String monstrosComputador = "";
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size(); i++) {
			monstrosComputador += "Nome: " + campoDeBatalha.getCardsMonstrosDoCampoDoComputador().get(i).getNome() + "\n"
						+ "Ataque: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoComputador().get(i)).getATK()
						+ " | Defesa: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoComputador().get(i)).getDEF() + "\n";
		}
		
		// Pergunta ao jogador qual monstro ele deseja destruir
		String escolhaMonstroOponente = JOptionPane.showInputDialog("Escolha 1 monstro que o oponente controla: " + "\n\n" + monstrosComputador);
		
		// Concatena todos os nomes dos monstros em campo do jogador em 1 string
		String monstrosJogador = "";
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size(); i++) {
			monstrosJogador += "Nome: " + campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i).getNome() + "\n"
							+ "Ataque: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getATK()
							+ " | Defesa: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getDEF() + "\n";
		}
		
		// Pergunta ao jogador qual monstro ele deseja conceder o controle
		String escolhaMonstroJogador = JOptionPane.showInputDialog("Escolha 1 monstro seu para conceder ao oponente: " + "\n\n" + monstrosJogador);
		
		// Destroi o monstro em campo do computador
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size(); i++) {
			if(campoDeBatalha.getCardsMonstrosDoCampoDoComputador().get(i).getNome().equals(escolhaMonstroOponente))
				campoDeBatalha.removeCardMonstroComputador(i);
		}
		
		// Adiciona este card aos monstros em campo do computador e apaga este card dos monstros em campo do jogador
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size(); i++) {
			if(campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i).getNome().equals(escolhaMonstroJogador)) {
				campoDeBatalha.adicionaCardMonstroDoJogadorAosCardsMonstrosDoComputadorNoCampo(i);
				campoDeBatalha.removeCardMonstroJogador(i);
			}
		}
		
				
	}
	
	public void ChifreDoUnicornio() {
		// O monstro equipado ganha 700 de ATK e DEF. Quando este card for enviado do campo para o Cemitério: devolva-o para o topo do Deck.
		
		// Concatena todos os nomes dos monstros em campo do jogador em 1 string
		String monstrosJogador = "";
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size(); i++) {
			monstrosJogador += "Nome: " + campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i).getNome() + "\n"
							+ "Ataque: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getATK()
							+ " | Defesa: " + ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getDEF() + "\n";
		}
		
		String escolhaMonstroJogador = JOptionPane.showInputDialog("Escolha 1 monstro seu para ganhar 700 de atk e 700 de def: " + "\n\n" + monstrosJogador);
		
		// Seta o ATK e DEF da carta escolhida no ATK/DEF atual + 700
		for(int i = 0; i < campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size(); i++) {
			if(campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i).getNome().equals(escolhaMonstroJogador)) {
				int ATKAtual = ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getATK();
				int DEFAtual = ((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).getDEF();
				
				((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).setATK(ATKAtual + 700);
				((CardMonstro) campoDeBatalha.getCardsMonstrosDoCampoDoJogador().get(i)).setDEF(DEFAtual + 700); 
			}
		}
		
		
	}
	
	public void DadoGracioso() {
		// Lance um dado de 6 faces. Até a Fase Final, todos os monstros que você controla atualmente ganham ATK e DEF igual ao resultado x 100.
	}
	
	public void DestruicaoDeCards() {
		// Cada duelista descarta toda a sua mão e, depois, compra o mesmo número de cards que descartou.
		int maoJogador = campoDeBatalha.getMaoJogador().size();
		for(int i = 0; i < maoJogador; i++) {
			campoDeBatalha.adicionaCardDaMaoDoJogadorAoCemiterio(i);
		}
		for(int i = 0; i < maoJogador; i++) {
			campoDeBatalha.addCardMaoJogador();
		}
		
		int maoComputador = campoDeBatalha.getMaoComputador().size();
		for(int i = 0; i < maoComputador; i++) {
			campoDeBatalha.adicionaCardDaMaoDoComputadorAoCemiterio(i);
		}
		for(int i = 0; i < maoComputador; i++) {
			campoDeBatalha.addCardMaoCPU();
		}
	}
	
	public void DianKetoMestreDaCura() {

		// Aumente seus Pontos de Vida em 1000 pontos.
		if(campoDeBatalha.getTurno() instanceof TurnoJogador)
			jogador.setPontosDeVida(jogador.getPontosDeVida() + 1000);
		//if(campoDeBatalha.getTurno().getClass() == TurnoJogador.class)	
		if(campoDeBatalha.getTurno() instanceof TurnoComputador)
			computador.setPontosDeVida(computador.getPontosDeVida() + 1000);
		//if(campoDeBatalha.getTurno().getClass() == TurnoComputador.class)
	}
	
	public void EspadaSombriaDaDestruicao() {
		// Um monstro de TREVAS equipado com este card aumenta seu ATK em 400 pontos e diminui sua DEF em 200 pontos.
	}
	
	public void EspadasDaLuzReveladora() {
		// Vire com a face para cima todos os monstros que seu oponente controla. Este card permanece no campo durante 3 turnos do seu oponente. 
		// Enquanto este card estiver no campo com a face para cima, os monstros controlados por seu oponente não podem declarar um ataque.
	}
	
	public void Fissura() {
		// Destrua o 1 monstro com a face para cima que seu oponente controla com o menor ATK. (Em caso de empate, você pode escolher.)
	}
	
	public void MudancaDeOpiniao() {
		// Escolha 1 monstro que seu oponente controla; tome o controle dele até a Fase Final.
	}
	
	public void Polimerizacao() {
		// Invoque por Invocação-Especial 1 Monstro de Fusão do seu Deck Adicional, usando monstros da sua mão ou do seu lado do campo como Matérias de Fusão.
	}
	
	public void PoteDaGanancia() {
		// Compre 2 cards.
		if(campoDeBatalha.getTurno() instanceof TurnoJogador){
			campoDeBatalha.addCardMaoJogador();
			campoDeBatalha.addCardMaoJogador();
		}
		
		if(campoDeBatalha.getTurno() instanceof TurnoComputador) {
			campoDeBatalha.addCardMaoCPU();
			campoDeBatalha.addCardMaoCPU();
		}
	}
	
	public void RemoverArmadilha() {
		// Destrói 1 Card de Armadilha que está no Campo com a face para cima.
	}
	
	public void RemoverMagia() {
		// Destrói 1 Card de Magia no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Magia é destruído. 
		// Se não, coloque-o novamente com a face para baixo. O card virado não é Activado.
	}
	
	public void ReviverMonstro() {
		// Escolha 1 monstro no Cemitério de qualquer duelista; Invoque-o por Invocação-Especial.
	}
	
	public void RitualDoLustroNegro() {
		// Este card é usado para a Invocação-Ritual de "Black Luster Soldier". Você também deve oferecer como Tributo monstros da sua mão ou campo 
		// cuja a soma dos Níveis seja igual a 8 ou mais.
	}
	
	public void Testamento() {
		// Se um monstro no seu lado do campo foi enviado para o seu Cemitério neste turno, você pode Invocar por Invocação-Especial 1 monstro com o 
		// ATK de 1500 pontos ou menos do seu Deck uma vez durante este turno. Depois, embaralhe seu Deck.
	}
	
	public void TufaoEspacialMistico() {
		// Escolha 1 Card de Magia/Armadilha no campo; destrua o alvo.
	}
	
	public void TurbilhaoDeRelampagos() {
		// Descarte 1 card; destrua todos os monstros com a face para cima que seu oponente controla.
	}
}
