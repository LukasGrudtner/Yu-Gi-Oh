package modelo.decks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import modelo.Card;
import modelo.CardArmadilha;
import modelo.CardMagia;
import modelo.CardMonstro;
import modelo.CardMonstroComEfeito;
import modelo.Tipo;
import modelo.tipos.Efeito;
import modelo.tipos.Fusao;
import modelo.tipos.Monstro;
import modelo.tipos.Ritual;
import modelo.tipos.armadilhas.ArmadilhaContinua;
import modelo.tipos.armadilhas.ArmadilhaNormal;
import modelo.tipos.armadilhas.ArmadilhaResposta;
import modelo.tipos.efeitos.EfeitoContinuo;
import modelo.tipos.efeitos.EfeitoGatilho;
import modelo.tipos.efeitos.EfeitoIgnicao;
import modelo.tipos.efeitos.EfeitoRapido;
import modelo.tipos.efeitos.EfeitoVirar;
import modelo.tipos.efeitos.SemEfeito;
import modelo.tipos.magias.MagiaCampo;
import modelo.tipos.magias.MagiaContinua;
import modelo.tipos.magias.MagiaEquipamento;
import modelo.tipos.magias.MagiaNormal;
import modelo.tipos.magias.MagiaRapida;
import modelo.tipos.magias.MagiaRitual;
import modelo.tipos.monstros.Anjo;
import modelo.tipos.monstros.Besta;
import modelo.tipos.monstros.BestaGuerreira;
import modelo.tipos.monstros.Demonio;
import modelo.tipos.monstros.Dinossauro;
import modelo.tipos.monstros.Dragao;
import modelo.tipos.monstros.Guerreiro;
import modelo.tipos.monstros.Insecto;
import modelo.tipos.monstros.Mago;
import modelo.tipos.monstros.Peixe;
import modelo.tipos.monstros.Rocha;
import modelo.tipos.monstros.Zumbi;

public class YugiMuto {
	
	private CardMonstro ansatsu;
	private CardMonstro baraoDaEspadaDemoniaca;
	private CardMonstroComEfeito barreiraIlusoria;
	private CardMonstro bauDeTesourosDevoradorDeHomens;
	private CardMonstro castorGuerreiro;
	private CardMonstro caveiraInvocada;
	private CardMonstro cemiterioDeMamutes;
	private CardMonstro diabreteSelvagem;
	private CardMonstro domaOAnjoDoSilencio;
	private CardMonstro dragaoAladoGuardiaoDaFortalezaN1;
	private CardMonstro dragaoZumbi;
	private CardMonstro elfaMistica;
	private CardMonstro elfoAnciao;
	private CardMonstro estendeGarras;
	private CardMonstro fantasmaMagico;
	private CardMonstro fantasmaSarcastico;
	private CardMonstro feiticeiroDosCondenados;
	private CardMonstro gaiaOCavaleiroImpetuoso;
	private CardMonstro guardiaoCelta;
	private CardMonstroComEfeito insectoDevoradorDeHomens;
	private CardMonstro magoNegro;
	private CardMonstro maldicaoDoDragao;
	private CardMonstroComEfeito mestreDasArmadilhas;
	private CardMonstro neoOEspadachimMagico;
	private CardMonstro oGrandeBranco;
	private CardMonstroComEfeito oMisticoImplacavel;
	private CardMonstro oPresaDePrata;
	private CardMonstro palhacoMistico;
	private CardMonstro soldadoDePedraGigante;
	private CardMagia buracoNegro;
	private CardMagia destruicaoDeCards;
	private CardMagia dianKetoMestreDaCura;
	private CardMagia espadaSombriaDaDestruicao;
	private CardMagia fissura;
	private CardMagia livroDasArtesSecretas;
	private CardMagia mudancaDeOpiniao;
	private CardMagia removerArmadilha;
	private CardMagia removerMagia;
	private CardMagia reviverMonstro;
	private CardMagia testamento;
	private CardMagia trocaDeAlmas;
	private CardMagia yami;
	private CardArmadilha armadilhaDeInversao;
	private CardArmadilha ataqueDeDoisGumes;
	private CardArmadilha buracoArmadilha;
	private CardArmadilha jarroDeCapturaDeDragoes;
	private CardArmadilha muralhasDoCastelo;
	private CardArmadilha oferendaDerradeira;
	private CardArmadilha reforcos;
	private CardArmadilha waboku;
	
	private Efeito efeitoContinuo;
	private Efeito efeitoGatilho;
	private Efeito efeitoIgnicao;
	private Efeito efeitoRapido;
	private Efeito efeitoVirar;
	private Efeito semEfeito;
	
	private Tipo armadilhaContinua;
	private Tipo armadilhaNormal;
	private Tipo armadilhaResposta;
	private Tipo magiaCampo;
	private Tipo magiaContinua;
	private Tipo magiaEquipamento;
	private Tipo magiaNormal;
	private Tipo magiaRapida;
	private Tipo magiaRitual;
	private Tipo fusao;
	private Tipo ritual;
	
	private Monstro anjo;
	private Monstro besta;
	private Monstro bestaGuerreira;
	private Monstro demonio;
	private Monstro dinossauro;
	private Monstro dragao;
	private Monstro guerreiro;
	private Monstro insecto;
	private Monstro mago;
	private Monstro peixe;
	private Monstro rocha;
	private Monstro zumbi;
	
	private List<Card> deck;
	
	public YugiMuto() {
		deck = new ArrayList<>();
		
		criaTipos();
		criaMonstros();
		criaEfeitos();
		
		criaCardMonstro();
		criaCardMagia();
		criaCardArmadilha();
	}

	private void criaMonstros() {
		anjo = new Anjo();
		besta = new Besta();
		bestaGuerreira = new BestaGuerreira();
		demonio = new Demonio();
		dinossauro = new Dinossauro();
		dragao = new Dragao();
		guerreiro = new Guerreiro();
		insecto = new Insecto();
		mago = new Mago();
		peixe = new Peixe();
		rocha = new Rocha();
		zumbi = new Zumbi();
	}

	private void criaEfeitos() {
		efeitoContinuo = new EfeitoContinuo();
		efeitoGatilho = new EfeitoGatilho();
		efeitoIgnicao = new EfeitoIgnicao();
		efeitoRapido = new EfeitoRapido();
		efeitoVirar = new EfeitoVirar();
		semEfeito = new SemEfeito();
	}
	
	private void criaTipos() {
		armadilhaContinua = new ArmadilhaContinua();
		armadilhaNormal = new ArmadilhaNormal();
		armadilhaResposta = new ArmadilhaResposta();
		
		magiaCampo = new MagiaCampo();
		magiaContinua = new MagiaContinua();
		magiaEquipamento = new MagiaEquipamento();
		magiaNormal = new MagiaNormal();
		magiaRapida = new MagiaRapida();
		magiaRitual = new MagiaRitual();
		
		fusao = new Fusao();
		ritual = new Ritual();
	}

	private void criaCardArmadilha() {
		String descricao;
		descricao = "Neste turno, você não sofre dano de batalha causado por monstros do oponente. Neste turno, seus monstros não podem ser destruídos em batalha.";
		waboku = new CardArmadilha();
		waboku.setCard("Waboku", 12607052, armadilhaNormal, descricao);
		deck.add(waboku);
		
		descricao = "O monstro alvo ganha 500 de ATK até o final deste turno.";
		reforcos = new CardArmadilha();
		reforcos.setCard("Reforços", 17814387, armadilhaNormal, descricao);
		deck.add(reforcos);
		
		descricao = "Durante sua Fase Principal ou Fase de Batalha do seu oponente: você pode pagar 500 Pontos de Vida; imediatamente após este efeito resolver, invoque por Invocação-Normar/Baixar 1 monstro.";
		oferendaDerradeira = new CardArmadilha();
		oferendaDerradeira.setCard("Oferenda Derradeira", 80604091, armadilhaContinua, descricao);
		deck.add(oferendaDerradeira);
		
		descricao = "Aumente a DEF de 1 monstro com a face para cima no campo em 500 pontos até o final deste turno.";
		muralhasDoCastelo = new CardArmadilha();
		muralhasDoCastelo.setCard("Muralhas do Castelo", 44209392, armadilhaNormal, descricao);
		deck.add(muralhasDoCastelo);
		
		descricao = "Coloque todos os monstros do Tipo Dragão com a face para cima no campo em Posição de Defesa e, além disso, eles não podem mudar suas posições de batalha.";
		jarroDeCapturaDeDragoes = new CardArmadilha();
		jarroDeCapturaDeDragoes.setCard("Jarro de Captura de Dragões", 50045299, armadilhaContinua, descricao);
		deck.add(jarroDeCapturaDeDragoes);
		
		descricao = "Até a Fase Final, todos os efeitos de adcionar ou subtrair ATK ou DEF são invertidos. (Adições agora subtraem e subtrações agora adicionam. Multiplicações e divisões, incluindo efeitos de dobrar ou diminuir pela metade, não são afetados.)";
		armadilhaDeInversao = new CardArmadilha();
		armadilhaDeInversao.setCard("Armadilha de Inversão", 77622396, armadilhaContinua, descricao);
		deck.add(armadilhaDeInversao);
		
		descricao = "Escolha e destrua 2 monstros no seu Campo e 1 monstro no Campo do seu adversário.";
		ataqueDeDoisGumes = new CardArmadilha();
		ataqueDeDoisGumes.setCard("Ataque de Dois Gumes", 83887306, armadilhaContinua, descricao);
		deck.add(ataqueDeDoisGumes);
		
		descricao = "Quando seu oponente Invocar por Invocação-Normal ou Virar 1 monstro com 1000 ou mais de ATK: escolha o monstro; destrua o alvo.";
		buracoArmadilha = new CardArmadilha();
		buracoArmadilha.setCard("Buraco Armadilha", 4206964, armadilhaContinua, descricao);
		deck.add(buracoArmadilha);
	}
	

	private void criaCardMagia() {
		String descricao;
		descricao = "Escolha 1 monstro que seu oponente controla; neste turno, se você oferecer um monstro como Tributo, você deve oferecer esse monstro como Tributo, como se você o controlasse. Você não pode conduzir sua Fase de Batalha no turno em que ativar este efeito.";
		trocaDeAlmas = new CardMagia();
		trocaDeAlmas.setCard("Troca de Almas", 68005187, magiaNormal, descricao);
		deck.add(trocaDeAlmas);
		
		descricao = "Se um monstro no seu lado do campo foi enviado para o seu Cemitério neste turno, você pode Invocar por Invocação-Especial 1 monstro com o ATK de 1500 pontos ou menos do seu Deck uma vez durante este turno. Depois, embaralhe seu Deck.";
		testamento = new CardMagia();
		testamento.setCard("Testamento", 85602018, magiaNormal, descricao);
		deck.add(testamento);
		
		descricao = "Escolha 1 monstro no Cemitério de qualquer duelista; Invoque-o por Invocação-Especial.";
		reviverMonstro = new CardMagia();
		reviverMonstro.setCard("Reviver Monstro", 83764718, magiaNormal, descricao);
		deck.add(reviverMonstro);
		
		descricao = "Destrói 1 Card de Magia no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Magia é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é Ativado.";
		removerMagia = new CardMagia();
		removerMagia.setCard("Remover Magia", 19159413, magiaNormal, descricao);
		deck.add(removerMagia);
		
		descricao = "Selecione 1 Card de Armadilha com a face para cima no campo e destrua-o.";
		removerArmadilha = new CardMagia();
		removerArmadilha.setCard("Remover Armadilha", 51482758, magiaNormal, descricao);
		deck.add(removerArmadilha);
		
		descricao = "Escolha 1 monstro que seu oponente controla; tome o controle dele até a Fase Final.";
		mudancaDeOpiniao = new CardMagia();
		mudancaDeOpiniao.setCard("Mudança de Opinião", 4031928, magiaNormal, descricao);
		deck.add(mudancaDeOpiniao);
		
		descricao = "Um monstro do Tipo Mago equipado com este card aumenta seu ATK e DEF em 300 pontos.";
		livroDasArtesSecretas = new CardMagia();
		livroDasArtesSecretas.setCard("Livro das Artes Secretas", 91595718, magiaEquipamento, descricao);
		deck.add(livroDasArtesSecretas);
		
		descricao = "Destrua o 1 monstro com a face para cima que seu oponente controla com o menor ATK. (Em caso de empate, você pode escolher.)";
		fissura = new CardMagia();
		fissura.setCard("Fissura", 66788016, magiaNormal, descricao);
		deck.add(fissura);
		
		descricao = "Um monstro de TREVAS equipado com este card aumenta seu ATK em 400 pontos e diminui sua DEF em 200 pontos.";
		espadaSombriaDaDestruicao = new CardMagia();
		espadaSombriaDaDestruicao.setCard("Espada Sombria da Destruição", 37120512, magiaEquipamento, descricao);
		deck.add(espadaSombriaDaDestruicao);
		
		descricao = "Aumente seus Pontos de Vida em 1000 pontos.";
		dianKetoMestreDaCura = new CardMagia();
		dianKetoMestreDaCura.setCard("Dian Keto, Mestre da Cura", 84257639, magiaNormal, descricao);
		deck.add(dianKetoMestreDaCura);
		
		descricao = "Cada duelista descarta toda a sua mão e, depois, compra o mesmo número de cards que descartou.";
		destruicaoDeCards = new CardMagia();
		destruicaoDeCards.setCard("Destruição de Cards", 72892473, magiaNormal, descricao);
		deck.add(destruicaoDeCards);
		
		descricao = "Destrua todos os monstros no campo.";
		buracoNegro = new CardMagia();
		buracoNegro.setCard("Buraco Negro", 53129443, magiaNormal, descricao);
		deck.add(buracoNegro);
		
		descricao = "Aumente o ATK e DEF de todos os monstros do Tipo Demônio e Mago em 200 pontos. Diminua também o ATK e DEF de todos os monstros do Tipo Anjo em 200 pontos.";
		yami = new CardMagia();
		yami.setCard("Yami", 59197169, magiaCampo, descricao);
		deck.add(yami);
	}

	private void criaCardMonstro() {
		String descricao;
		descricao = "Um guerreiro silencioso e mortal especializado em assassínios.";
		ansatsu = new CardMonstro();
		ansatsu.setCard("Ansatsu", 5, "Terra", guerreiro, 48365709, 1700, 1200, descricao);
		deck.add(ansatsu);
		
		descricao = "Um aristocrata que empunha uma espada possuída por um demônio, que se alimenta dos fracos.";
		baraoDaEspadaDemoniaca = new CardMonstro();
		baraoDaEspadaDemoniaca.setCard("Barão da Espada Demoníaca", 4, "Trevas", demonio, 86325596, 1550, 800, descricao);
		deck.add(baraoDaEspadaDemoniaca);
		
		descricao = "Se este card for atacado por um monstro, depois do cálculo de dano: devolva esse monstro para a mão.";
		barreiraIlusoria = new CardMonstroComEfeito();
		barreiraIlusoria.setCard("Barreira Ilusória", 4, "Trevas", demonio, efeitoGatilho, 13945284, 1000, 1850, descricao);
		deck.add(barreiraIlusoria);
		
		descricao = "Um monstro disfarçado de baú de tesouro e conhecido por atacar os aventureiros descuidados.";
		bauDeTesourosDevoradorDeHomens = new CardMonstro();
		bauDeTesourosDevoradorDeHomens.setCard("Baú de Tesouros, Devorador de Homens", 4, "Trevas", demonio, 13723605, 1600, 1000, descricao);
		deck.add(bauDeTesourosDevoradorDeHomens);
		
		descricao = "O que esta criatura falta em tamanho ele compensa em defesa quando lutando na pradaria.";
		castorGuerreiro = new CardMonstro();
		castorGuerreiro.setCard("Castor Guerreiro", 4, "Terra", bestaGuerreira, 32452818, 1200, 1500, descricao);
		deck.add(castorGuerreiro);
		
		descricao = "Um demônio com poderes das trevas para confundir os inimigos. Entre os monstros do tipo demônio, é dos mais fortes.";
		caveiraInvocada = new CardMonstro();
		caveiraInvocada.setCard("Caveira Invocada", 6, "Trevas", demonio, 70781052, 2500, 1200, descricao);
		deck.add(caveiraInvocada);
		
		descricao = "Um mamute que protege os túmulos do seu bando e que enfrenta ladrões de túmulos impiedosamente.";
		cemiterioDeMamutes = new CardMonstro();
		cemiterioDeMamutes.setCard("Cemitério de Mamutes", 3, "Terra", dinossauro, 40374923, 1200, 800, descricao);
		deck.add(cemiterioDeMamutes);
		
		descricao = "Um pequeno demônio brincalhão que se esconde na escuridão, esperando para atacar um inimigo descuidado.";
		diabreteSelvagem = new CardMonstro();
		diabreteSelvagem.setCard("Diabrete Selvagem", 4, "Trevas", demonio, 41392891, 1300, 1400, descricao);
		deck.add(diabreteSelvagem);
		
		descricao = "Este anjo governa a morte e administra-a quando necessário.";
		domaOAnjoDoSilencio = new CardMonstro();
		domaOAnjoDoSilencio.setCard("Doma, O Anjo do Silêncio", 5, "Trevas", anjo, 16972957, 1600, 1400, descricao);
		deck.add(domaOAnjoDoSilencio);
		
		descricao = "Um dragão normalmente encontrado protegendo fortalezas das montanhas. O seu ataque característico é um mergulho arrebatador vindo do céu.";
		dragaoAladoGuardiaoDaFortalezaN1 = new CardMonstro();
		dragaoAladoGuardiaoDaFortalezaN1.setCard("Dragão Alado, Guardião da Fortaleza Nº1", 4, "Vento", dragao, 87796900, 1400, 1200, descricao);
		deck.add(dragaoAladoGuardiaoDaFortalezaN1);
		
		descricao = "Um dragão renascido por feitiçaria. O Seu hálito é altamete corrosivo.";
		dragaoZumbi = new CardMonstro();
		dragaoZumbi.setCard("Dragão Zumbi", 3, "Trevas", zumbi, 66672569, 1600, 0, descricao);
		deck.add(dragaoZumbi);
		
		descricao = "Uma elfa delicada com pouco poder de ataque, mas com uma incrível defesa proveniente de poderes místicos.";
		elfaMistica = new CardMonstro();
		elfaMistica.setCard("Elfa Mística", 4, "Luz", mago, 15025844, 800, 2000, descricao);
		deck.add(elfaMistica);
		
		descricao = "Rumores dizem que este elfo vive há milhares de anos. Ele lidera um exército de espíritos contra seus inimigos.";
		elfoAnciao = new CardMonstro();
		elfoAnciao.setCard("Elfo Ancião", 4, "Luz", mago, 93221206, 1450, 1200, descricao);
		deck.add(elfoAnciao);
		
		descricao = "Braços que esticam e garras afiadas com lâminas fazem deste monstro um oponente formidável.";
		estendeGarras = new CardMonstro();
		estendeGarras.setCard("Estende Garras", 3, "Trevas", demonio, 41248256, 1000, 800, descricao);
		deck.add(estendeGarras);
		
		descricao = "Esta criatura lança uma mágica de terror de confusão logo antes de atacar seus inimigos.";
		fantasmaMagico = new CardMonstro();
		fantasmaMagico.setCard("Fantasma Mágico", 4, "Trevas", zumbi, 46474915, 1300, 1400, descricao);
		deck.add(fantasmaMagico);
		
		descricao = "Vestido com um smoking preto como a noite, esta criatura preside à morte.";
		fantasmaSarcastico = new CardMonstro();
		fantasmaSarcastico.setCard("Fantasma Sarcástico", 4, "Trevas", demonio, 36304921, 1400, 1300, descricao);
		deck.add(fantasmaSarcastico);
		
		descricao = "Um escravo das artes das trevas, este feiticeiro é um mestre nas magias letais.";
		feiticeiroDosCondenados = new CardMonstro();
		feiticeiroDosCondenados.setCard("Feiticeiro dos Condenados", 4, "Trevas", mago, 49218300, 1450, 1200, descricao);
		deck.add(feiticeiroDosCondenados);
		
		descricao = "Um cavaleiro cujo cavalo galopa mais rápido do que o vento. A sua carga de batalha é de uma força avassaladora.";
		gaiaOCavaleiroImpetuoso = new CardMonstro();
		gaiaOCavaleiroImpetuoso.setCard("Gaia, o Cavaleiro Impetuoso", 7, "Terra", guerreiro, 6368038, 2300, 2100, descricao);
		deck.add(gaiaOCavaleiroImpetuoso);
		
		descricao = "Um elfo que aprendeu a empunhar uma espada, ele confunde os inimigos com ataques relâmpagos.";
		guardiaoCelta = new CardMonstro();
		guardiaoCelta.setCard("Guardião Celta", 4, "Terra", guerreiro, 91152256, 1400, 1200, descricao);
		deck.add(guardiaoCelta);
		
		descricao = "VIRE: Escolha 1 monstro no campo; destrua o alvo.";
		insectoDevoradorDeHomens = new CardMonstroComEfeito();
		insectoDevoradorDeHomens.setCard("Insecto Devorador de Homens", 2, "Terra", insecto, efeitoVirar, 54652250, 450, 600, descricao);
		deck.add(insectoDevoradorDeHomens);
		
		descricao = "O mago definitivo em termos de ataque e defesa.";
		magoNegro = new CardMonstro();
		magoNegro.setCard("Mago Negro", 7, "Trevas", mago, 46986414, 2500, 2100, descricao);
		deck.add(magoNegro);
		
		descricao = "Um dragão perverso que se apoia nas forças das trevas para executar um poderoso ataque.";
		maldicaoDoDragao = new CardMonstro();
		maldicaoDoDragao.setCard("Maldição do Dragão", 5, "Trevas", dragao, 28279543, 2000, 1500, descricao);
		deck.add(maldicaoDoDragao);
		
		descricao = "VIRE: Destrói 1 Card de Armadilha no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Armadilha é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é ATIVADO.";
		mestreDasArmadilhas = new CardMonstroComEfeito();
		mestreDasArmadilhas.setCard("Mestre das Armadilhas", 3, "Terra", guerreiro, efeitoVirar, 46461247, 500, 1100, descricao);
		deck.add(mestreDasArmadilhas);
		
		descricao = "Um viajante dimensional que além de praticar as artes mágicas, também é um mestre com a espada e artes marciais.";
		neoOEspadachimMagico = new CardMonstro();
		neoOEspadachimMagico.setCard("Neo, o Espadachim Mágico", 4, "Luz", mago, 50930991, 1700, 1100, descricao);
		deck.add(neoOEspadachimMagico);
		
		descricao = "Um tubarão branco gigante com dentes afiados como lâminas.";
		oGrandeBranco = new CardMonstro();
		oGrandeBranco.setCard("O Grande Branco", 4, "Água", peixe, 13429800, 1600, 800, descricao);
		deck.add(oGrandeBranco);
		
		descricao = "VIRE: Todos os cards no Campo com a face para baixo são virados com a face para cima e depois devolvidos à sua posição original. Os efeitos dos cards não são Ativados quando os cards são virados para cima.";
		oMisticoImplacavel = new CardMonstroComEfeito();
		oMisticoImplacavel.setCard("O Místico Implacável", 4, "Luz", mago, efeitoVirar, 87557188, 1500, 1200, descricao);
		deck.add(oMisticoImplacavel);
		
		descricao = "Um lobo da neve que, embora agrade aos olhos, é absolutamente feroz em batalha.";
		oPresaDePrata = new CardMonstro();
		oPresaDePrata.setCard("O Presa de Prata", 3, "Terra", besta, 90357090, 1200, 800, descricao);
		deck.add(oPresaDePrata);
		
		descricao = "Nada pode parar o ataque enlouquecido desta poderosa criatura.";
		palhacoMistico = new CardMonstro();
		palhacoMistico.setCard("Palhaço Místico", 4, "Trevas", demonio, 47060154, 1500, 1000, descricao);
		deck.add(palhacoMistico);
		
		descricao = "Um guerreiro gigante feito de pedra. Um soco desta criatura faz com que a terra estremça.";
		soldadoDePedraGigante = new CardMonstro();
		soldadoDePedraGigante.setCard("Soldado de Pedra Gigante", 3, "Terra", rocha, 13039848, 1300, 2000, descricao);
		deck.add(soldadoDePedraGigante);
	}

	public List<Card> getDeck() {
		return deck;
	}
	
	public List<Card> embaralhaERetornaDeck() {
		List<Card> deckEmbaralhado = new ArrayList<>();
		Random gerador = new Random();
		
		for(int i = 0; i < deck.size(); i++) {
			int k = gerador.nextInt(deck.size());
			deckEmbaralhado.add(deck.get(k));
			deck.remove(k);
		}
		
		return deckEmbaralhado;
	}
	
	public String toString() {
		String concatena = "";
		for(int i = 0; i < deck.size(); i++) {
			concatena += "\n\nNome: " + deck.get(i).nome +
						 "\nDescrição: " + deck.get(i).descricao;
		}
		return concatena;
	}
}
