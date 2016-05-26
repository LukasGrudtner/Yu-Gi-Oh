package modelo.decks;

import modelo.CardMagiaEArmadilha;
import modelo.CardMonstro;

public class YugiMuto {
	
	private CardMonstro ansatsu;
	private CardMagiaEArmadilha armadilhaDeInversao;
	private CardMagiaEArmadilha ataqueDeDoisGumes;
	private CardMonstro baraoDaEspadaDemoniaca;
	private CardMonstro barreiraIlusoria;
	private CardMonstro bauDeTesourosDevoradorDeHomens;
	private CardMagiaEArmadilha buracoArmadilha;
	private CardMagiaEArmadilha buracoNegro;
	private CardMonstro castorGuerreiro;
	private CardMonstro caveiraInvocada;
	private CardMonstro cemiterioDeMamutes;
	private CardMagiaEArmadilha destruicaoDeCards;
	private CardMonstro diabreteSelvagem;
	private CardMagiaEArmadilha dianKetoMestreDaCura;
	private CardMonstro domaOAnjoDoSilencio;
	private CardMonstro dragaoAladoGuardiaoDaFortalezaN1;
	private CardMonstro dragaoZumbi;
	private CardMonstro elfaMistica;
	private CardMonstro elfoAnciao;
	private CardMagiaEArmadilha espadaSombriaDaDestruicao;
	private CardMonstro estendeGarras;
	private CardMonstro fantasmaMagico;
	private CardMonstro fantasmaSarcastico;
	private CardMonstro feiticeiroDosCondenados;
	private CardMagiaEArmadilha fissura;
	private CardMonstro gaiaOCavaleiroImpetuoso;
	private CardMonstro guardiaoCelta;
	private CardMonstro insectoDevoradorDeHomens;
	private CardMagiaEArmadilha jarroDeCapturaDeDragoes;
	private CardMagiaEArmadilha livroDasArtesSecretas;
	private CardMonstro magoNegro;
	private CardMonstro maldicaoDoDragao;
	private CardMonstro mestreDasArmadilhas;
	private CardMagiaEArmadilha mudancaDeOpiniao;
	private CardMagiaEArmadilha muralhasDoCastelo;
	private CardMonstro neoOEspadachimMagico;
	private CardMonstro oGrandeBranco;
	private CardMonstro oMisticoImplacavel;
	private CardMonstro oPresaDePrata;
	private CardMagiaEArmadilha oferendaDerradeira;
	private CardMonstro palhacoMistico;
	private CardMagiaEArmadilha reforcos;
	private CardMagiaEArmadilha removerArmadilha;
	private CardMagiaEArmadilha removerMagia;
	private CardMagiaEArmadilha reviverMonstro;
	private CardMonstro soldadoDePedraGigante;
	private CardMagiaEArmadilha testamento;
	private CardMagiaEArmadilha trocaDeAlmas;
	private CardMagiaEArmadilha waboku;
	private CardMagiaEArmadilha yami;
	
	public YugiMuto() {
		ansatsu = new CardMonstro();
		ansatsu.setCard("Ansatsu", 5, "Terra", 48365709, 1700, 1200, "Um guerreiro silencioso e mortal especializado em assassínios.");
		
		armadilhaDeInversao = new CardMagiaEArmadilha();
		armadilhaDeInversao.setCard("Armadilha de Inversão", 77622396, "Normal", "Até a Fase Final, todos os efeitos de adcionar ou subtrair ATK ou DEF são invertidos. (Adições agora subtraem e subtrações agora adicionam. Multiplicações e divisões, incluindo efeitos de dobrar ou diminuir pela metade, não são afetados.)");
		
		ataqueDeDoisGumes = new CardMagiaEArmadilha();
		ataqueDeDoisGumes.setCard("Ataque de Dois Gumes", 83887306, "Normal", "Escolha e destrua 2 monstros no seu Campo e 1 monstro no Campo do seu adversário.");
		//card de Armadilha
		baraoDaEspadaDemoniaca = new CardMonstro();
		baraoDaEspadaDemoniaca.setCard("Barão da Espada Demoníaca", 4, "Trevas", 86325596, 1550, 800, "Um aristocrata que empunha uma espada possuída por um demônio, que se alimenta dos fracos.");
		
		barreiraIlusoria = new CardMonstro();
		barreiraIlusoria.setCard("Barreira Ilusória", 4, "Trevas", 13945284, 1000, 1850, "Se este card for atacado por um monstro, depois do cálculo de dano: devolva esse monstro para a mão.");
		
		bauDeTesourosDevoradorDeHomens = new CardMonstro();
		bauDeTesourosDevoradorDeHomens.setCard("Baú de Tesouros, Devorador de Homens", 4, "Trevas", 13723605, 1600, 1000, "Um monstro disfarçado de baú de tesouro e conhecido por atacar os aventureiros descuidados.");
		
		buracoArmadilha = new CardMagiaEArmadilha();
		buracoArmadilha.setCard("Buraco Armadilha", 4206964, "Normal", "Quando seu oponente Invocar por Invocação-Normal ou Virar 1 monstro com 1000 ou mais de ATK: escolha o monstro; destrua o alvo.");
		
		buracoNegro = new CardMagiaEArmadilha();
		buracoNegro.setCard("Buraco Negro", 53129443, "Normal", "Destrua todos os monstros no campo.");
		
		castorGuerreiro = new CardMonstro();
		castorGuerreiro.setCard("Castor Guerreiro", 4, "Terra", 32452818, 1200, 1500, "O que esta criatura falta em tamanho ele compensa em defesa quando lutando na pradaria.");
		
		caveiraInvocada = new CardMonstro();
		caveiraInvocada.setCard("Caveira Invocada", 6, "Trevas", 70781052, 2500, 1200, "Um demônio com poderes das trevas para confundir os inimigos. Entre os monstros do tipo demônio, é dos mais fortes.");
		
		cemiterioDeMamutes = new CardMonstro();
		cemiterioDeMamutes.setCard("Cemitério de Mamutes", 3, "Terra", 40374923, 1200, 800, "Um mamute que protege os túmulos do seu bando e que enfrenta ladrões de túmulos impiedosamente.");
		
		destruicaoDeCards = new CardMagiaEArmadilha();
		destruicaoDeCards.setCard("Destruição de Cards", 72892473, "Normal", "Cada duelista descarta toda a sua mão e, depois, compra o mesmo número de cards que descartou.");
		
		diabreteSelvagem = new CardMonstro();
		diabreteSelvagem.setCard("Diabrete Selvagem", 4, "Trevas", 41392891, 1300, 1400, "Um pequeno demônio brincalhão que se esconde na escuridão, esperando para atacar um inimigo descuidado.");
		
		dianKetoMestreDaCura = new CardMagiaEArmadilha();
		dianKetoMestreDaCura.setCard("Dian Keto, Mestre da Cura", 84257639, "Normal", "Aumente seus Pontos de Vida em 1000 pontos.");
		
		domaOAnjoDoSilencio = new CardMonstro();
		domaOAnjoDoSilencio.setCard("Doma, O Anjo do Silêncio", 5, "Trevas", 16972957, 1600, 1400, "Este anjo governa a morte e administra-a quando necessário.");
		
		dragaoAladoGuardiaoDaFortalezaN1 = new CardMonstro();
		dragaoAladoGuardiaoDaFortalezaN1.setCard("Dragão Alado, Guardião da Fortaleza Nº1", 4, "Vento", 87796900, 1400, 1200, "Um dragão normalmente encontrado protegendo fortalezas das montanhas. O seu ataque característico é um mergulho arrebatador vindo do céu.");
		
		dragaoZumbi = new CardMonstro();
		dragaoZumbi.setCard("Dragão Zumbi", 3, "Trevas", 66672569, 1600, 0, "Um dragão renascido por feitiçaria. O Seu hálito é altamete corrosivo.");
		
		elfaMistica = new CardMonstro();
		elfaMistica.setCard("Elfa Mística", 4, "Luz", 15025844, 800, 2000, "Uma elfa delicada com pouco poder de ataque, mas com uma incrível defesa proveniente de poderes místicos.");
		
		elfoAnciao = new CardMonstro();
		elfoAnciao.setCard("Elfo Ancião", 4, "Luz", 93221206, 1450, 1200, "Rumores dizem que este elfo vive há milhares de anos. Ele lidera um exército de espíritos contra seus inimigos.");
		
		espadaSombriaDaDestruicao = new CardMagiaEArmadilha();
		espadaSombriaDaDestruicao.setCard("Espada Sombria da Destruição", 37120512, "Equipamento", "Um monstro de TREVAS equipado com este card aumenta seu ATK em 400 pontos e diminui sua DEF em 200 pontos.");
		
		estendeGarras = new CardMonstro();
		estendeGarras.setCard("Estende Garras", 3, "Trevas", 41248256, 1000, 800, "Braços que esticam e garras afiadas com lâminas fazem deste monstro um oponente formidável.");
		
		fantasmaMagico = new CardMonstro();
		fantasmaMagico.setCard("Fantasma Mágico", 4, "Trevas", 46474915, 1300, 1400, "Esta criatura lança uma mágica de terror de confusão logo antes de atacar seus inimigos.");
		
		fantasmaSarcastico = new CardMonstro();
		fantasmaSarcastico.setCard("Fantasma Sarcástico", 4, "Trevas", 36304921, 1400, 1300, "Vestido com um smoking preto como a noite, esta criatura preside à morte.");
		
		feiticeiroDosCondenados = new CardMonstro();
		feiticeiroDosCondenados.setCard("Feiticeiro dos Condenados", 4, "Trevas", 49218300, 1450, 1200, "Um escravo das artes das trevas, este feiticeiro é um mestre nas magias letais.");
		
		fissura = new CardMagiaEArmadilha();
		fissura.setCard("Fissura", 66788016, "Normal", "Destrua o 1 monstro com a face para cima que seu oponente controla com o menor ATK. (Em caso de empate, você pode escolher.)");
		
		gaiaOCavaleiroImpetuoso = new CardMonstro();
		gaiaOCavaleiroImpetuoso.setCard("Gaia, o Cavaleiro Impetuoso", 7, "Terra", 6368038, 2300, 2100, "Um cavaleiro cujo cavalo galopa mais rápido do que o vento. A sua carga de batalha é de uma força avassaladora.");
		
		guardiaoCelta = new CardMonstro();
		guardiaoCelta.setCard("Guardião Celta", 4, "Terra", 91152256, 1400, 1200, "Um elfo que aprendeu a empunhar uma espada, ele confunse os inimigos com ataques relâmpagos.");
		
		insectoDevoradorDeHomens = new CardMonstro();
		insectoDevoradorDeHomens.setCard("Insecto Devorador de Homens", 2, "Terra", 54652250, 450, 600, "VIRE: Escolha 1 monstro no campo; destrua o alvo.");
		
		jarroDeCapturaDeDragoes = new CardMagiaEArmadilha();
		jarroDeCapturaDeDragoes.setCard("Jarro de Captura de Dragões", 50045299, "Contínuo", "Coloque todos os monstros do Tipo Dragão com a face para cima no campo em Posição de Defesa e, além disso, eles não podem mudar suas posições de batalha.");
		
		livroDasArtesSecretas = new CardMagiaEArmadilha();
		livroDasArtesSecretas.setCard("Livro das Artes Secretas", 91595718, "Equipamento", "Um monstro do Tipo Mago equipado com este card aumenta seu ATK e DEF em 300 pontos.");
		
		magoNegro = new CardMonstro();
		magoNegro.setCard("Mago Negro", 7, "Trevas", 46986414, 2500, 2100, "O mago definitivo em termos de ataque e defesa.");
		
		maldicaoDoDragao = new CardMonstro();
		maldicaoDoDragao.setCard("Maldição do Dragão", 5, "Trevas", 28279543, 2000, 1500, "Um dragão perverso que se apoia nas forças das trevas para executar um poderoso ataque.");
		
		mestreDasArmadilhas = new CardMonstro();
		mestreDasArmadilhas.setCard("Mestre das Armadilhas", 3, "Terra", 46461247, 500, 1100, "VIRE: Destrói 1 Card de Armadilha no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Armadilha é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é ATIVADO.");
		
		mudancaDeOpiniao = new CardMagiaEArmadilha();
		mudancaDeOpiniao.setCard("Mudança de Opinião", 4031928, "Normal", "Escolha 1 monstro que seu oponente controla; tome o controle dele até a Fase Final.");
		
		muralhasDoCastelo = new CardMagiaEArmadilha();
		muralhasDoCastelo.setCard("Muralhas do Castelo", 44209392, "Normal", "Aumente a DEF de 1 monstro com a face para cima no campo em 500 pontos até o final deste turno.");
		
		neoOEspadachimMagico = new CardMonstro();
		neoOEspadachimMagico.setCard("Neo, o Espadachim Mágico", 4, "Luz", 50930991, 1700, 1100, "Um viajante dimensinal que além de praticar as artes mágicas, também é um mestre com a espada e artes marciais.");
		
		oferendaDerradeira = new CardMagiaEArmadilha();
		oferendaDerradeira.setCard("Oferenda Derradeira", 80604091, "Contínuo", "Durante sua Fase Principal ou Fase de Batalha do seu oponente: você pode pagar 500 Pontos de Vida; imediatamente após este efeito resolver, invoque por Invocação-Normar/Baixar 1 monstro.");
		
		oGrandeBranco = new CardMonstro();
		oGrandeBranco.setCard("O Grande Branco", 4, "Água", 13429800, 1600, 800, "Um tubarão branco gigante com dentes afiados como lâminas.");
		
		oMisticoImplacavel = new CardMonstro();
		oMisticoImplacavel.setCard("O Místico Implacável", 4, "Luz", 87557188, 1500, 1200, "VIRE: Todos os cards no Campo com a face para baixo são virados com a face para cima e depois devolvidos à sua posição original. Os efeitos dos cards não são Ativados quando os cards são virados para cima.");
		
		oPresaDePrata = new CardMonstro();
		oPresaDePrata.setCard("O Presa de Prata", 3, "Terra", 90357090, 1200, 800, "Um lobo da neve que, embora agrade aos olhos, é absolutamente feroz em batalha.");
		
		palhacoMistico = new CardMonstro();
		palhacoMistico.setCard("Palhaço Místico", 4, "Trevas", 47060154, 1500, 1000, "Nada pode parar o ataque enlouquecido desta poderosa criatura.");
		
		reforcos = new CardMagiaEArmadilha();
		reforcos.setCard("Reforços", 17814387, "Normal", "O monstro alvo ganha 500 de ATK até o final deste turno.");
		
		removerArmadilha = new CardMagiaEArmadilha();
		removerArmadilha.setCard("Remover Armadilha", 51482758, "Normal", "Selecione 1 Card de Armadilha com a face para cima no campo e destrua-o.");
		
		removerMagia = new CardMagiaEArmadilha();
		removerMagia.setCard("Remover Magia", 19159413, "Normal", "Destrói 1 Card de Magia no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Magia é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é Ativado.");
		
		reviverMonstro = new CardMagiaEArmadilha();
		reviverMonstro.setCard("Reviver Monstro", 83764718, "Normal", "Escolha 1 monstro no Cemitério de qualquer duelista; Invoque-o por Invocação-Especial.");
		
		soldadoDePedraGigante = new CardMonstro();
		soldadoDePedraGigante.setCard("Soldado de Pedra Gigante", 3, "Terra", 13039848, 1300, 2000, "Um guerreiro gigante feito de pedra. Um soco desta criatura faz com que a terra estremça.");
		
		testamento = new CardMagiaEArmadilha();
		testamento.setCard("Testamento", 85602018, "Normal", "Se um monstro no seu lado do campo foi enviado para o seu Cemitério neste turno, você pode Invocar por Invocação-Especial 1 monstro com o ATK de 1500 pontos ou menos do seu Deck uma vez durante este turno. Depois, embaralhe seu Deck.");
		
		trocaDeAlmas = new CardMagiaEArmadilha();
		trocaDeAlmas.setCard("Troca de Almas", 68005187, "Normal", "Escolha 1 monstro que seu oponente controla; neste turno, se você oferecer um monstro como Tributo, você deve oferecer esse monstro como Tributo, como se você o controlasse. Você não pode conduzir sua Fase de Batalha no turno em que ativar este efeito.");
		
		waboku = new CardMagiaEArmadilha();
		waboku.setCard("Waboku", 12607052, "Normal", "Neste turno, você não sofre dano de batalha causado por monstros do oponente. Neste turno, seus monstros não podem ser destruídos em batalha.");
		
		yami = new CardMagiaEArmadilha();
		yami.setCard("Yami", 59197169, "Campo", "Aumente o ATK e DEF de todos os monstros do Tipo Demônio e Mago em 200 pontos. Diminua também o ATK e DEF de todos os monstros do Tipo Anjo em 200 pontos.");
	}
}
