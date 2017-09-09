package modelo;

public class EfeitoCardsMonstros {
	
	CampoDeBatalha campoDeBatalha;
	
	public void Berfomet() {
		// Quando este card for Invocado por Invocação-Normal ou Virar: você pode adicionar 1 "Gazelle the King of Mythical Beasts" do seu Deck à sua mão.
	}
	
	// arrumar
	public void BusterBlader() {
		// Este card ganha 500 de ATK para cada monstro do Tipo Dragão que seu oponente controla ou que estiver no Cemitério dele.
		for(int i = 0; i < campoDeBatalha.getCemiterioJogador().size(); i++) {
			if(campoDeBatalha.getCemiterioJogador().get(i) instanceof CardMonstro) {
			}
		}
	}
	
	public void ExodiaOProibido(){
		// Se, além deste card na sua mão, você tiver "Right Leg of the Forbidden One", "Left Leg of the Forbidden One", 
		// "Right Arm of the Forbidden One" e "Left Arm of the Forbidden One", você vence o Duelo.
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
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Braço Direito do Proibido"))
				bracoDireito = true;
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Braco Esquerdo do Proibido"))
				bracoEsquerdo = true;
			
			if(campoDeBatalha.getMaoJogador().get(i).getNome().equals("Exódia, o Proibido"))
				exodiaOProibido = true;	
		}
		
		if(pernaDireita == true && pernaEsquerda == true && bracoDireito == true && bracoEsquerdo == true && exodiaOProibido == true) {
			// termina jogo e jogador é o vencedor
		}
	}
	
	public void ForcaDeAtaqueGoblin() {
		// Se este card atacar, ele é colocado em Posição de Defesa no final da Fase de Batalha e sua posição da batalha não pode mudar 
		// até a Fase Final do seu próximo turno.
	}
	
	public void GearfriedOCavaleiroDeFerro() {
		// Quando um ou mais Cards de Equipamento forem equipados a este card: destrua os Cards de Equipamento.
	}
	
	public void InsetoDevoradorDeHomens() {
		// VIRE: Escolha 1 monstro no campo; destrua o alvo.
	}
	
	public void Kuriboh() {
		// Durante o turno do seu oponente, no cálculo de dano: você pode descartar este card; você não sofre dano de batalha desta 
		// batalha (este é um Efeito Rápido).
	}
	
	public void MagoDoTempo() {
		// Uma vez por turno: você pode lançar uma moeda e escolher cara ou coroa. Se você ganhar, destrua todos os monstros que seu 
		// oponente controla. Se você perder, destrua todos monstros que você controla e, se isso acontecer, você sofre dano igual à 
		// metade do ATK total que esses monstros destruídos tinham no campo.
	}
	
	public void MestreDasArmadilhas() {
		// VIRE: Destrói 1 Card de Armadilha no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. 
		// Se for um Card de Armadilha é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é Activado.
	}
	
	public void PequenaMagaNegra() {
		// Este card ganha 300 de ATK para cada "Dark Magician" ou "Magician of Black Chaos" no Cemitério de qualquer duelista.
	}
	
	public void Sangan() {
		// Quando este card for enviado do campo para o Cemitério: adicione 1 monstro com 1500 ou menos de ATK do seu Deck à sua mão.
	}
	
	public void TartarugaCatapulta() {
		// Uma vez por turno: você pode oferecer 1 monstro como Tributo; cause dano ao seu oponente igual à metade do ATK que o 
		// monstro oferecido como Tributo tinha no campo.
	}

}
