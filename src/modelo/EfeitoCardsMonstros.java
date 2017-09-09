package modelo;

public class EfeitoCardsMonstros {
	
	CampoDeBatalha campoDeBatalha;
	
	public void Berfomet() {
		// Quando este card for Invocado por Invoca��o-Normal ou Virar: voc� pode adicionar 1 "Gazelle the King of Mythical Beasts" do seu Deck � sua m�o.
	}
	
	// arrumar
	public void BusterBlader() {
		// Este card ganha 500 de ATK para cada monstro do Tipo Drag�o que seu oponente controla ou que estiver no Cemit�rio dele.
		for(int i = 0; i < campoDeBatalha.getCemiterioJogador().size(); i++) {
			if(campoDeBatalha.getCemiterioJogador().get(i) instanceof CardMonstro) {
			}
		}
	}
	
	public void ExodiaOProibido(){
		// Se, al�m deste card na sua m�o, voc� tiver "Right Leg of the Forbidden One", "Left Leg of the Forbidden One", 
		// "Right Arm of the Forbidden One" e "Left Arm of the Forbidden One", voc� vence o Duelo.
		boolean pernaDireita = false;
		boolean pernaEsquerda = false;
		boolean bracoDireito = false;
		boolean bracoEsquerdo = false;
		boolean exodiaOProibido = false;
		
		for(int i = 0; i < campoDeBatalha.getMaoJogador().size(); i++) {
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Perna Direita do Proibido"))
				pernaDireita = true;
		
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Perna Esquerda do Proibido"))
				pernaEsquerda = true;
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Bra�o Direito do Proibido"))
				bracoDireito = true;
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Braco Esquerdo do Proibido"))
				bracoEsquerdo = true;
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Ex�dia, o Proibido"))
				exodiaOProibido = true;	
		}
		
		if(pernaDireita == true && pernaEsquerda == true && bracoDireito == true && bracoEsquerdo == true && exodiaOProibido == true) {
			// termina jogo e jogador � o vencedor
		}
	}
	
	public void ForcaDeAtaqueGoblin() {
		// Se este card atacar, ele � colocado em Posi��o de Defesa no final da Fase de Batalha e sua posi��o da batalha n�o pode mudar 
		// at� a Fase Final do seu pr�ximo turno.
	}
	
	public void GearfriedOCavaleiroDeFerro() {
		// Quando um ou mais Cards de Equipamento forem equipados a este card: destrua os Cards de Equipamento.
	}
	
	public void InsetoDevoradorDeHomens() {
		// VIRE: Escolha 1 monstro no campo; destrua o alvo.
	}
	
	public void Kuriboh() {
		// Durante o turno do seu oponente, no c�lculo de dano: voc� pode descartar este card; voc� n�o sofre dano de batalha desta 
		// batalha (este � um Efeito R�pido).
	}
	
	public void MagoDoTempo() {
		// Uma vez por turno: voc� pode lan�ar uma moeda e escolher cara ou coroa. Se voc� ganhar, destrua todos os monstros que seu 
		// oponente controla. Se voc� perder, destrua todos monstros que voc� controla e, se isso acontecer, voc� sofre dano igual � 
		// metade do ATK total que esses monstros destru�dos tinham no campo.
	}
	
	public void MestreDasArmadilhas() {
		// VIRE: Destr�i 1 Card de Armadilha no Campo. Se o alvo deste card est� com a face para baixo, vire a face para cima. 
		// Se for um Card de Armadilha � destru�do. Se n�o, coloque-o novamente com a face para baixo. O card virado n�o � Activado.
	}
	
	public void PequenaMagaNegra() {
		// Este card ganha 300 de ATK para cada "Dark Magician" ou "Magician of Black Chaos" no Cemit�rio de qualquer duelista.
	}
	
	public void Sangan() {
		// Quando este card for enviado do campo para o Cemit�rio: adicione 1 monstro com 1500 ou menos de ATK do seu Deck � sua m�o.
	}
	
	public void TartarugaCatapulta() {
		// Uma vez por turno: voc� pode oferecer 1 monstro como Tributo; cause dano ao seu oponente igual � metade do ATK que o 
		// monstro oferecido como Tributo tinha no campo.
	}

}
