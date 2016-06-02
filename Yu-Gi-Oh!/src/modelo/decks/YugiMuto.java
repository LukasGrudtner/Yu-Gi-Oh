package modelo.decks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Card;
import modelo.CardArmadilha;
import modelo.CardMagia;
import modelo.CardMonstro;
import modelo.CardMonstro.AtributoCard;
import modelo.CardMonstro.TipoCard;
import modelo.CardMonstroComEfeito;
import modelo.CardMonstroFusao;
import modelo.CardMonstroRitual;
import modelo.CardMonstroSemEfeito;
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

public class YugiMuto {
	
	private CardArmadilha cardArmadilha;
	private CardMagia cardMagia;
	private CardMonstroSemEfeito cardMonstroSemEfeito;
	private CardMonstroComEfeito cardMonstroComEfeito;
	private CardMonstroRitual cardMonstroRitual;
	
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
	
	private List<Card> deckCards;
	private List<Card> deckCardsFusao;
	
	public YugiMuto() {
		deckCards = new ArrayList<>();
		deckCardsFusao = new ArrayList<>();
		
		criaTipos();
		criaEfeitos();
		
		criaCardMonstro();
		criaCardMagia();
		criaCardArmadilha();
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
		cardArmadilha = new CardArmadilha();
		
		descricao = "Durante sua Fase Principal ou Fase de Batalha do seu oponente: você pode pagar 500 Pontos de Vida; imediatamente após este efeito resolver, invoque por Invocação-Normar/Baixar 1 monstro.";
		cardArmadilha.setCard("Oferenda Derradeira", 80604091, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Quando seu oponente Invocar por Invocação-Normal ou Virar 1 monstro com 1000 ou mais de ATK: escolha o monstro; destrua o alvo.";
		cardArmadilha.setCard("Buraco Armadilha", 4206964, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Ative este card ao escolher 1 monstro no seu Cemitério; Invoque o alvo por Invocação-Especial com a face para cima em Posição de Ataque. Quando este card deixar o campo, destrua o alvo. Quando o alvo for destruído, destrua este card.";
		cardArmadilha.setCard("Chamado dos Assombrados", 97077563, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Quando um monstro do oponente declarar um ataque: escolha o monstro atacante; negue o ataque e, se isso acontecer, cause dano ao seu oponente igual ao ATK do monstro.";
		cardArmadilha.setCard("Cilindro Mágico", 62279055, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Ative esse card ao escolher 1 monstro que seu oponente controla; ele não pode atacar ou mudar sua posição de batalha. Quando esse monstro for destruído, destrua este card.";
		cardArmadilha.setCard("Círculo da Profecia", 18807108, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Quando um Card de Magia for ativado: descarte 1 card; negue a ativação e, se isso acontecer, destrua-o.";
		cardArmadilha.setCard("Bloqueador de Magia", 77414722, armadilhaResposta, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Quando um monstro do oponente declarar um ataque: destrua todos os monstros em Posição de Ataque que seu oponente controla.";
		cardArmadilha.setCard("Força Espelho", 44095762, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Seu oponente deve manter sua mão revelada. Durante cada Fase de Apoio do seu oponente, se ele tiver um Card de Magia na mão dele, ele ganha 1000 PV.";
		cardArmadilha.setCard("Olho da Verdade", 34694160, magiaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Selecione 1 Spell Card no Cemitério do seu oponente. O efeito desta carta torna-se o mesmo efeito da carta selecionada, somente até o fim da End Phase. Se o fizer, você recebe 2000 de dano.";
		cardArmadilha.setCard("Ladrão de Túmulos", 61705417, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "Durante a Fase de Batalha do seu oponente: selecione 2 Cards de Magia/Armadilha do seu Deck e 1 monstro que você controla. Invoque-os por Invocação-Especial como Monstros Normais (ATK 0/DEF 0) com a face para baixo em Posição de Defesa. Baixe o monstro selecionado se ele estava com a face para cima e embaralhe-os no campo. Os 2 cards selecionados do seu Deck são destruídos no final da Fase de Batalha e não podem permanecer no campo, exceto durante esta Fase de Batalha.";
		cardArmadilha.setCard("Cartolas Mágicas", 81210420, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
	}
	
	private void criaCardMagia() {
		String descricao;
		cardMagia = new CardMagia();
		
		descricao = "Escolha até 5 cards em qual(is)quer Cemitério(s); bana-os.";
		cardMagia.setCard("Alma Livre", 5758500, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 monstro com a face para cima no campo; ele ganha 700 de ATK até a Fase Final.";
		cardMagia.setCard("Arremetida Imprudente", 70046172, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "O monstro equipado ganha 700 de ATK e DEF. Quando este card for enviado do campo para o Cemitério: devolva-o para o topo do Deck.";
		cardMagia.setCard("Chifre do Unicórnio", 64047146, magiaEquipamento, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 monstro que seu oponente controla; destrua o alvo e, depois, conceda o controle do segundo alvo ao seu oponente.";
		cardMagia.setCard("Caixa Mágica", 2577440, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Lance um dado de 6 faces. Até a Fase Final, todos os monstros que você controla atualmente ganham ATK e DEF igual ao resultado x 100.";
		cardMagia.setCard("Dado Gracioso", 74137509, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Vire com a face para cima todos os monstros que seu oponente controla. Este card permanece no campo durante 3 turnos do seu oponente. Enquanto este card estiver no campo com a face para cima, os monstros controlados por seu oponente não podem declarar um ataque.";
		cardMagia.setCard("Espadas da Luz Reveladora", 72302403, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 'Rei Caveira' ou monstro do Tipo Trovão que você controla; destrua todos os monstros que seu oponente controla com DEF menor ou igual ao ATK desse monstro. Você não pode conduzir sua Fase de Batalha no turno em que ativar este card.";
		cardMagia.setCard("Brumas Mágicas de Makiu", 27827272, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Invoque por Invocação-Especial 1 Monstro de Fusão do seu Deck Adicional, usando monstros da sua mão ou do seu lado do campo como Matérias de Fusão.";
		cardMagia.setCard("Polimerização", 24094653, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Este card é usado para a Invocação-Ritual de 'Soldado do Lustro Negro'. Você também deve oferecer como Tributo monstros da sua mão ou campo cuja a soma dos Níveis seja igual a 8 ou mais.";
		cardMagia.setCard("Ritual do Lustro Negro", 55761792, magiaRitual, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Compre 2 cards.";
		cardMagia.setCard("Pote da Ganância", 55144522, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Quando este card for ativado: se houver Cards de Magia de Campo no campo, destrua-os. Durante a Fase de Apoio de cada duelista: o duelista do turno sofre 500 de dano.";
		cardMagia.setCard("Terra em Chamas", 24294108, magiaContinua, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 Card de Magia/Armadilha no campo; destrua o alvo.";
		cardMagia.setCard("Tufão Espacial Místico", 5318639, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Descarte 1 card; destrua todos os monstros com a face para cima que seu oponente controla.";
		cardMagia.setCard("Turbilhão de Relâmpagos", 69162969, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Se um monstro no seu lado do campo foi enviado para o seu Cemitério neste turno, você pode Invocar por Invocação-Especial 1 monstro com o ATK de 1500 pontos ou menos do seu Deck uma vez durante este turno. Depois, embaralhe seu Deck.";
		cardMagia.setCard("Testamento", 85602018, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 monstro no Cemitério de qualquer duelista; Invoque-o por Invocação-Especial.";
		cardMagia.setCard("Reviver Monstro", 83764718, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Destrói 1 Card de Magia no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Magia é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é Ativado.";
		cardMagia.setCard("Remover Magia", 19159413, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Selecione 1 Card de Armadilha com a face para cima no campo e destrua-o.";
		cardMagia.setCard("Remover Armadilha", 51482758, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Escolha 1 monstro que seu oponente controla; tome o controle dele até a Fase Final.";
		cardMagia.setCard("Mudança de Opinião", 4031928, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Destrua o 1 monstro com a face para cima que seu oponente controla com o menor ATK. (Em caso de empate, você pode escolher.)";
		cardMagia.setCard("Fissura", 66788016, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Um monstro de TREVAS equipado com este card aumenta seu ATK em 400 pontos e diminui sua DEF em 200 pontos.";
		cardMagia.setCard("Espada Sombria da Destruição", 37120512, magiaEquipamento, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Aumente seus Pontos de Vida em 1000 pontos.";
		cardMagia.setCard("Dian Keto, Mestre da Cura", 84257639, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Cada duelista descarta toda a sua mão e, depois, compra o mesmo número de cards que descartou.";
		cardMagia.setCard("Destruição de Cards", 72892473, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "Destrua todos os monstros no campo.";
		cardMagia.setCard("Buraco Negro", 53129443, magiaNormal, descricao);
		deckCards.add(cardMagia);
	}

	private void criaCardMonstro() {
		String descricao;
		cardMonstroSemEfeito = new CardMonstroSemEfeito();
		cardMonstroComEfeito = new CardMonstroComEfeito();
		cardMonstroRitual = new CardMonstroRitual();
		
		descricao = "Um gênio da lâmpada que está sempre à disposição do seu mestre.";
		cardMonstroSemEfeito.setCard("La Jinn, o Gênio Místico da Lâmpada", 4, AtributoCard.Trevas, TipoCard.Demonio, 97590747, 1800, 1000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Este card ganha 300 de ATK para cada 'Mago Negro' ou 'Mago do Caos das Trevas' no Cemitério de qualquer duelista.";
		cardMonstroComEfeito.setCard("Pequena Maga Negra", 6, AtributoCard.Trevas, TipoCard.Mago, efeitoContinuo, 38033121, 2000, 1700, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Você pode Invocar este card por Invocação-Ritual com 'Ritual de Magia Negra'.";
		cardMonstroSemEfeito.setCard("Mago do Caos das Trevas", 8, AtributoCard.Trevas, TipoCard.Mago, 30208479, 2800, 2600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Manipula os ataques inimigos com o poder da ilusão.";
		cardMonstroSemEfeito.setCard("Mago Ilusionista sem Rosto", 5, AtributoCard.Trevas, TipoCard.Mago, 28546905, 1200, 2200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Gaia, o Cavaleiro Impetuoso + Maldição do Dragão";
		cardMonstroSemEfeito.setCard("Gaia, o Matador de Dragões", 7, AtributoCard.Vento, TipoCard.Dragao, 66889139, 2600, 2100, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "Quando um ou mais Cards de Equipamento forem equipados a este card: destrua os Cards de Equipamento.";
		cardMonstroComEfeito.setCard("Gearfried, o Cavaleiro de Ferro", 4, AtributoCard.Terra, TipoCard.Guerreiro, efeitoGatilho, 423705, 1800, 1600, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "A grossa couraça desse monstro desvia a maioria dos ataques.";
		cardMonstroSemEfeito.setCard("Griffore", 4, AtributoCard.Terra, TipoCard.Besta, 53829412, 1200, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um touro monstruoso muitas vezes encontrado na floresta, ele ataca os monstros inimigos com o seu par de chifres mortíferos.";
		cardMonstroSemEfeito.setCard("Jovem Touro Guerreiro", 5, AtributoCard.Terra, TipoCard.BestaGuerreira, 18246479, 1800, 1300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Durante o turno do seu oponente, no cálculo de dano: você pode descartar este card; você não sofre dano de batalha desta batalha (este é um Efeito Rápido).";
		cardMonstroComEfeito.setCard("Kuriboh", 1, AtributoCard.Trevas, TipoCard.Demonio, efeitoRapido, 40650057, 300, 200, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "O que esta criatura falta em tamanho ele compensa em defesa quando lutando na pradaria.";
		cardMonstroSemEfeito.setCard("Castor Guerreiro", 4, AtributoCard.Terra, TipoCard.BestaGuerreira, 32452818, 1200, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um mamute que protege os túmulos do seu bando e que enfrenta ladrões de túmulos impiedosamente.";
		cardMonstroSemEfeito.setCard("Cemitério de Mamutes", 3, AtributoCard.Terra, TipoCard.Dinossauro, 40374923, 1200, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um pequeno demônio brincalhão que se esconde na escuridão, esperando para atacar um inimigo descuidado.";
		cardMonstroSemEfeito.setCard("Diabrete Selvagem", 4, AtributoCard.Trevas, TipoCard.Demonio, 41392891, 1300, 1400, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um dragão normalmente encontrado protegendo fortalezas das montanhas. O seu ataque característico é um mergulho arrebatador vindo do céu.";
		cardMonstroSemEfeito.setCard("Dragão Alado, Guardião da Fortaleza Nº1", 4, AtributoCard.Vento, TipoCard.Dragao, 87796900, 1400, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Uma elfa delicada com pouco poder de ataque, mas com uma incrível defesa proveniente de poderes místicos.";
		cardMonstroSemEfeito.setCard("Elfa Mística", 4, AtributoCard.Luz, TipoCard.Mago, 15025844, 800, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um cavaleiro cujo cavalo galopa mais rápido do que o vento. A sua carga de batalha é de uma força avassaladora.";
		cardMonstroSemEfeito.setCard("Gaia, o Cavaleiro Impetuoso", 7, AtributoCard.Trevas, TipoCard.Guerreiro, 6368038, 2300, 2100, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um elfo que aprendeu a empunhar uma espada, ele confunde os inimigos com ataques relâmpagos.";
		cardMonstroSemEfeito.setCard("Guardião Celta", 4, AtributoCard.Terra, TipoCard.Guerreiro, 91152256, 1400, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "O mago definitivo em termos de ataque e defesa.";
		cardMonstroSemEfeito.setCard("Mago Negro", 7, AtributoCard.Trevas, TipoCard.Mago, 46986414, 2500, 2100, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um dragão perverso que se apoia nas forças das trevas para executar um poderoso ataque.";
		cardMonstroSemEfeito.setCard("Maldição do Dragão", 5, AtributoCard.Trevas, TipoCard.Dragao, 28279543, 2000, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "VIRE: Destrói 1 Card de Armadilha no Campo. Se o alvo deste card está com a face para baixo, vire a face para cima. Se for um Card de Armadilha é destruído. Se não, coloque-o novamente com a face para baixo. O card virado não é ATIVADO.";
		cardMonstroComEfeito.setCard("Mestre das Armadilhas", 3, AtributoCard.Terra, TipoCard.Guerreiro, efeitoVirar, 46461247, 500, 1100, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "Um guerreiro gigante feito de pedra. Um soco desta criatura faz com que a terra estremça.";
		cardMonstroSemEfeito.setCard("Soldado de Pedra Gigante", 3, AtributoCard.Terra, TipoCard.Rocha, 13039848, 1300, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Uma perna direita, proibida e selada por magia. Qualquer um que romper este selo obterá poder infinito.";
		cardMonstroSemEfeito.setCard("Perna Direita do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 8124921, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Uma perna esquerda, proibida e selada por magia. Qualquer um que romper este selo obterá poder infinito.";
		cardMonstroSemEfeito.setCard("Perna Esquerda do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 44519536, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "'Maga Negra' + 'Buster Blader'. Deve ser Invocado por Invocação-Fusão e não pode ser Invocado por Invocação-Especial de outras formas. Durante o turno de qualquer duelista, quando um Card de Magia for ativado: você pode descartar 1 card; negue a ativação e, se isso acontecer, destrua-o. Este card deve estar face para cima no campo para ativar e resolver este efeito. Este card ganha 500 de ATK para cada monstro do Tipo Dragão no campo ou Cemitério de qualquer duelista.";
		cardMonstroComEfeito.setCard("Paladino Negro", 8, AtributoCard.Trevas, TipoCard.Mago, efeitoContinuo, 98502113, 2900, 2400, descricao);
		deckCardsFusao.add(cardMonstroComEfeito);
		
		descricao = "Um demônio com poderes das trevas para confundir os inimigos. Entre os monstros do tipo demônio, é dos mais fortes.";
		cardMonstroSemEfeito.setCard("Rei Caveira", 6, AtributoCard.Trevas, TipoCard.Demonio, 70781052, 2500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Você pode Invocar este card por Invocação-Especial com 'Ritual do Lustro Negro'.";
		cardMonstroRitual.setCard("Soldado do Lustro Negro", 8, AtributoCard.Terra, TipoCard.Guerreiro, 5405694, 3000, 2500, descricao);
		deckCards.add(cardMonstroRitual);
		
		descricao = "Dragão Branco de Olhos Azuis + Dragão Branco de Olhos Azuis + Dragão Branco de Olhos Azuis";
		cardMonstroSemEfeito.setCard("Supremo Dragão Branco de Olhos Azuis", 12, AtributoCard.Luz, TipoCard.Dragao, 23995346, 4500, 3800, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "Uma vez por turno: você pode oferecer 1 monstro como Tributo; cause dano ao seu oponente igual à metade do ATK que o monstro oferecido como Tributo tinha no campo.";
		cardMonstroSemEfeito.setCard("Tartaruga Catapulta", 5, AtributoCard.Agua, TipoCard.Aqua, 95727991, 1000, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Muito mais do que um filhote, este dragão é dotado de poderes ainda não revelados.";
		cardMonstroSemEfeito.setCard("Bebê Dragão", 3, AtributoCard.Vento, TipoCard.Dragao, 88819587, 1200, 700, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Quando este card for Invocado por Invocação-Normal ou Virar: você pode adicionar 1 'Gazelle, o Rei das Bestas Místicas' do seu Deck à sua mão.";
		cardMonstroSemEfeito.setCard("Berfomet", 4, AtributoCard.Terra, TipoCard.Besta, 5818798, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Alfa, Beta e Gama se juntam em um para formar um monstro poderoso.";
		cardMonstroSemEfeito.setCard("Beta, o Guerreiro Imã", 4, AtributoCard.Terra, TipoCard.Rocha, 39256679, 1700, 1600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um braço direito, proibido e selado por magia. Qualquer um que romper este selo obterá poder infinito.";
		cardMonstroSemEfeito.setCard("Braço Direito do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 70903634, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um braço esquerdo, proibido e selado por magia. Qualquer um que romper este selo obterá poder infinito.";
		cardMonstroSemEfeito.setCard("Braço Esquerdo do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 7902349, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Este card ganha 500 de ATK para cada monstro do Tipo Dragão que seu oponente controla ou que estiver no Cemitério dele.";
		cardMonstroComEfeito.setCard("Buster Blader", 7, AtributoCard.Terra, TipoCard.Guerreiro, efeitoContinuo, 78193831, 2600, 2300, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "Este lendário dragão é uma poderosa máquina de destruição. Praticamente invencível, muito poucos enfrentaram essa magnifica criatura e viveram para contar a história.";
		cardMonstroSemEfeito.setCard("Dragão Branco de Olhos Azuis", 8, AtributoCard.Luz, TipoCard.Dragao, 89631139, 3000, 2500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		deckCards.add(cardMonstroSemEfeito);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Rei Caveira + Dragão Negro de Olhos Vermelhos";
		cardMonstroSemEfeito.setCard("Dragão Caveira Negro", 9, AtributoCard.Trevas, TipoCard.Dragao, 11901678, 3200, 2500, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "Um dragão malégno que cospe fogo. As suas chamas maléficas corrompem as almas de suas vítimas.";
		cardMonstroSemEfeito.setCard("Dragão Koumori", 4, AtributoCard.Trevas, TipoCard.Dragao, 67724379, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um dragão feroz com um ataque letal.";
		cardMonstroSemEfeito.setCard("Dragão Negro de Olhos Vermelhos", 7, AtributoCard.Trevas, TipoCard.Dragao, 74677422, 2400, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Um espadachim habilidoso que é metade serpente, metade humano. O golpe de sua espada é tão rápido como o som!";
		cardMonstroSemEfeito.setCard("Espada do Jacaré", 4, AtributoCard.Terra, TipoCard.Besta, 64428736, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Se, além deste card na sua mão, você tiver 'Perna Direita do Proibido', 'Perna Esquerda do Proibido', 'Braço Direito do Proibido' e 'Braço Esquerdo do Proibido', você vence o Duelo.";
		cardMonstroSemEfeito.setCard("Exódia, O Proibido", 3, AtributoCard.Trevas, TipoCard.Mago, 33396948, 1000, 1000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Se este card atacar, ele é colocado em Posição de Defesa no final da Fase de Batalha e sua posição da batalha não pode mudar até a Fase Final do seu próximo turno.";
		cardMonstroComEfeito.setCard("Força de Ataque Goblin", 4, AtributoCard.Terra, TipoCard.Guerreiro, efeitoGatilho, 78658564, 2300, 0, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "Um tubarão branco gigante com dentes afiados como lâminas.";
		cardMonstroSemEfeito.setCard("O Grande Branco", 4, AtributoCard.Agua, TipoCard.Peixe, 13429800, 1600, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Com um machado em cada mão, este monstro causa grandes estragos.";
		cardMonstroSemEfeito.setCard("Imperador Cruel", 5, AtributoCard.Terra, TipoCard.BestaGuerreira, 26378150, 1800, 1600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "VIRE: Escolha 1 monstro no campo; destrua o alvo.";
		cardMonstroComEfeito.setCard("Inseto Devorador de Homens", 2, AtributoCard.Terra, TipoCard.Inseto, efeitoVirar, 54652250, 450, 600, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "Uma vez por turno: você pode lançar uma moeda e escolher cara ou coroa. Se você ganhar, destrua todos os monstros que seu oponente controla. Se você perder, destrua todos monstros que você controla e, se isso acontecer, você sofre dano igual à metade do ATK total que esses monstros destruídos tinham no campo.";
		cardMonstroComEfeito.setCard("Mago do Tempo", 2, AtributoCard.Luz, TipoCard.Mago, efeitoGatilho, 71625222, 500, 400, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "Um lobo da neve que, embora agrade aos olhos, é absolutamente feroz em batalha.";
		cardMonstroSemEfeito.setCard("Presas de Prata", 3, AtributoCard.Terra, TipoCard.Besta, 90357090, 1200, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "Quando este card for enviado do campo para o Cemitério: adicione 1 monstro com 1500 ou menos de ATK do seu Deck à sua mão.";
		cardMonstroComEfeito.setCard("Sangan", 3, AtributoCard.Trevas, TipoCard.Demonio, efeitoGatilho, 26202165, 1000, 600, descricao);
		deckCards.add(cardMonstroComEfeito);
	}

	public List<Card> getDeck() {
		return deckCards;
	}
	
	public List<Card> embaralhaERetornaDeck() {
		List<Card> deckEmbaralhado = new ArrayList<>();
		Random gerador = new Random();
		
		for(int i = 0; i < deckCards.size(); i++) {
			int k = gerador.nextInt(deckCards.size());
			deckEmbaralhado.add(deckCards.get(k));
			deckCards.remove(k);
		}
		
		return deckEmbaralhado;
	}
	
	public String toString() {
		String concatena = "";
		for(int i = 0; i < deckCards.size(); i++) {
			concatena += "\n\nNome: " + deckCards.get(i).nome +
						 "\nDescrição: " + deckCards.get(i).descricao;
		}
		return concatena;
	}
}
