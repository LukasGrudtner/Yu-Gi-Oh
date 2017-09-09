package modelo.decks;

import java.util.ArrayList;
import java.util.Collections;
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

public class ListaCards {
	
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
	
	public ListaCards() {
		deckCards = new ArrayList<>();
		deckCardsFusao = new ArrayList<>();
		
		criaTipos();
		criaEfeitos();
		
		criaCardMonstro();
		criaCardMagia();
		criaCardArmadilha();
		
		//embaralhaCards();
		
		
//		for(int i = 0; i < this.deckCards.size(); i++)
//			System.out.println(this.deckCards.get(i).getNome());
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
		
		descricao = "<html>Durante sua Fase Principal ou Fase de Batalha do seu oponente: voc� pode pagar 500 Pontos de Vida; imediatamente ap�s este efeito resolver, invoque por Invoca��o-Normar/Baixar 1 monstro.</html>";
		cardArmadilha = new CardArmadilha("Oferenda Derradeira", 80604091, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Quando seu oponente Invocar por Invoca��o-Normal ou Virar 1 monstro com 1000 ou mais de ATK: escolha o monstro; destrua o alvo.</html>";
		cardArmadilha = new CardArmadilha("Buraco Armadilha", 4206964, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Ative este card ao escolher 1 monstro no seu Cemit�rio; Invoque o alvo por Invoca��o-Especial com a face para cima em Posi��o de Ataque. Quando este card deixar o campo, destrua o alvo. Quando o alvo for destru�do, destrua este card.</html>";
		cardArmadilha = new CardArmadilha("Chamado dos Assombrados", 97077563, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Quando um monstro do oponente declarar um ataque: escolha o monstro atacante; negue o ataque e, se isso acontecer, cause dano ao seu oponente igual ao ATK do monstro.</html>";
		cardArmadilha = new CardArmadilha("Cilindro M�gico", 62279055, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Ative esse card ao escolher 1 monstro que seu oponente controla; ele n�o pode atacar ou mudar sua posi��o de batalha. Quando esse monstro for destru�do, destrua este card.</html>";
		cardArmadilha = new CardArmadilha("C�rculo da Profecia", 18807108, armadilhaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Quando um Card de Magia for ativado: descarte 1 card; negue a ativa��o e, se isso acontecer, destrua-o.</html>";
		cardArmadilha = new CardArmadilha("Bloqueador de Magia", 77414722, armadilhaResposta, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Quando um monstro do oponente declarar um ataque: destrua todos os monstros em Posi��o de Ataque que seu oponente controla.</html>";
		cardArmadilha = new CardArmadilha("For�a Espelho", 44095762, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Seu oponente deve manter sua m�o revelada. Durante cada Fase de Apoio do seu oponente, se ele tiver um Card de Magia na m�o dele, ele ganha 1000 PV.</html>";
		cardArmadilha = new CardArmadilha("Olho da Verdade", 34694160, magiaContinua, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Selecione 1 Spell Card no Cemit�rio do seu oponente. O efeito desta carta torna-se o mesmo efeito da carta selecionada, somente at� o fim da End Phase. Se o fizer, voc� recebe 2000 de dano.</html>";
		cardArmadilha = new CardArmadilha("Ladr�o de T�mulos", 61705417, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
		
		descricao = "<html>Durante a Fase de Batalha do seu oponente: selecione 2 Cards de Magia/Armadilha do seu Deck e 1 monstro que voc� controla. Invoque-os por Invoca��o-Especial como Monstros Normais (ATK 0/DEF 0) com a face para baixo em Posi��o de Defesa. Baixe o monstro selecionado se ele estava com a face para cima e embaralhe-os no campo. Os 2 cards selecionados do seu Deck s�o destru�dos no final da Fase de Batalha e n�o podem permanecer no campo, exceto durante esta Fase de Batalha.</html>";
		cardArmadilha = new CardArmadilha("Cartolas M�gicas", 81210420, armadilhaNormal, descricao);
		deckCards.add(cardArmadilha);
	}
	
	private void criaCardMagia() {
		String descricao;
		
		descricao = "<html>Escolha at� 5 cards em qual(is)quer Cemit�rio(s); bana-os.</html>";
		cardMagia = new CardMagia("Alma Livre", 5758500, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 monstro com a face para cima no campo; ele ganha 700 de ATK at� a Fase Final.</html>";
		cardMagia = new CardMagia("Arremetida Imprudente", 70046172, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>O monstro equipado ganha 700 de ATK e DEF. Quando este card for enviado do campo para o Cemit�rio: devolva-o para o topo do Deck.</html>";
		cardMagia = new CardMagia("Chifre do Unic�rnio", 64047146, magiaEquipamento, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 monstro que seu oponente controla; destrua o alvo e, depois, conceda o controle do segundo alvo ao seu oponente.</html>";
		cardMagia = new CardMagia("Caixa M�gica", 2577440, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Lance um dado de 6 faces. <br> At� a Fase Final, todos os monstros que voc� controla atualmente ganham ATK e DEF igual ao resultado x 100.</html>";
		cardMagia = new CardMagia("Dado Gracioso", 74137509, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Vire com a face para cima todos os monstros que seu oponente controla. Este card permanece no campo durante 3 turnos do seu oponente. Enquanto este card estiver no campo com a face para cima, os monstros controlados por seu oponente n�o podem declarar um ataque.</html>";
		cardMagia = new CardMagia("Espadas da Luz Reveladora", 72302403, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 'Rei Caveira' ou monstro do Tipo Trov�o que voc� controla; destrua todos os monstros que seu oponente controla com DEF menor ou igual ao ATK desse monstro. Voc� n�o pode conduzir sua Fase de Batalha no turno em que ativar este card.</html>";
		cardMagia = new CardMagia("Brumas M�gicas de Makiu", 27827272, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Invoque por Invoca��o-Especial 1 Monstro de Fus�o do seu Deck Adicional, usando monstros da sua m�o ou do seu lado do campo como Mat�rias de Fus�o.</html>";
		cardMagia = new CardMagia("Polimeriza��o", 24094653, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Este card � usado para a Invoca��o-Ritual de 'Soldado do Lustro Negro'. Voc� tamb�m deve oferecer como Tributo monstros da sua m�o ou campo cuja a soma dos N�veis seja igual a 8 ou mais.</html>";
		cardMagia = new CardMagia("Ritual do Lustro Negro", 55761792, magiaRitual, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Compre 2 cards.</html>";
		cardMagia = new CardMagia("Pote da Gan�ncia", 55144522, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 Card de Magia/Armadilha no campo; destrua o alvo.</html>";
		cardMagia = new CardMagia("Tuf�o Espacial M�stico", 5318639, magiaRapida, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Descarte 1 card; destrua todos os monstros com a face para cima que seu oponente controla.</html>";
		cardMagia = new CardMagia("Turbilh�o de Rel�mpagos", 69162969, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Se um monstro no seu lado do campo foi enviado para o seu Cemit�rio neste turno, voc� pode Invocar por Invoca��o-Especial 1 monstro com o ATK de 1500 pontos ou menos do seu Deck uma vez durante este turno. Depois, embaralhe seu Deck.</html>";
		cardMagia = new CardMagia("Testamento", 85602018, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 monstro no Cemit�rio de qualquer duelista; Invoque-o por Invoca��o-Especial.</html>";
		cardMagia = new CardMagia("Reviver Monstro", 83764718, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Destr�i 1 Card de Magia no Campo. Se o alvo deste card est� com a face para baixo, vire a face para cima. Se for um Card de Magia � destru�do. Se n�o, coloque-o novamente com a face para baixo. O card virado n�o � Ativado.</html>";
		cardMagia = new CardMagia("Remover Magia", 19159413, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Selecione 1 Card de Armadilha com a face para cima no campo e destrua-o.</html>";
		cardMagia = new CardMagia("Remover Armadilha", 51482758, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Escolha 1 monstro que seu oponente controla; tome o controle dele at� a Fase Final.</html>";
		cardMagia = new CardMagia("Mudan�a de Opini�o", 4031928, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Destrua o 1 monstro com a face para cima que seu oponente controla com o menor ATK. (Em caso de empate, voc� pode escolher.)</html>";
		cardMagia = new CardMagia("Fissura", 66788016, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Um monstro de TREVAS equipado com este card aumenta seu ATK em 400 pontos e diminui sua DEF em 200 pontos.</html>";
		cardMagia = new CardMagia("Espada Sombria da Destrui��o", 37120512, magiaEquipamento, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Aumente seus Pontos de Vida em 1000 pontos.</html>";
		cardMagia = new CardMagia("Dian Keto, Mestre da Cura", 84257639, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Cada duelista descarta toda a sua m�o e, depois, compra o mesmo n�mero de cards que descartou.</html>";
		cardMagia = new CardMagia("Destrui��o de Cards", 72892473, magiaNormal, descricao);
		deckCards.add(cardMagia);
		
		descricao = "<html>Destrua todos os monstros no campo.</html>";
		cardMagia = new CardMagia("Buraco Negro", 53129443, magiaNormal, descricao);
		deckCards.add(cardMagia);
	}

	private void criaCardMonstro() {
		String descricao;
		
		descricao = "<html>Um g�nio da l�mpada que est� sempre � disposi��o do seu mestre.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("La Jinn, o G�nio M�stico da L�mpada", 4, AtributoCard.Trevas, TipoCard.Demonio, 97590747, 1800, 1000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Este card ganha 300 de ATK para cada 'Mago Negro' ou 'Mago do Caos das Trevas' no Cemit�rio de qualquer duelista.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Pequena Maga Negra", 6, AtributoCard.Trevas, TipoCard.Mago, efeitoContinuo, 38033121, 2000, 1700, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Voc� pode Invocar este card por Invoca��o-Ritual com 'Ritual de Magia Negra'.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Mago do Caos das Trevas", 8, AtributoCard.Trevas, TipoCard.Mago, 30208479, 2800, 2600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Manipula os ataques inimigos com o poder da ilus�o.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Mago Ilusionista sem Rosto", 5, AtributoCard.Trevas, TipoCard.Mago, 28546905, 1200, 2200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>'Gaia, o Cavaleiro Impetuoso' + 'Maldi��o do Drag�o'</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Gaia, o Matador de Drag�es", 7, AtributoCard.Vento, TipoCard.Dragao, 66889139, 2600, 2100, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "<html>Quando um ou mais Cards de Equipamento forem equipados a este card: destrua os Cards de Equipamento.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Gearfried, o Cavaleiro de Ferro", 4, AtributoCard.Terra, TipoCard.Guerreiro, efeitoGatilho, 423705, 1800, 1600, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>A grossa coura�a desse monstro desvia a maioria dos ataques.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Griffore", 4, AtributoCard.Terra, TipoCard.Besta, 53829412, 1200, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um touro monstruoso muitas vezes encontrado na floresta, ele ataca os monstros inimigos com o seu par de chifres mort�feros.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Jovem Touro Guerreiro", 5, AtributoCard.Terra, TipoCard.BestaGuerreira, 18246479, 1800, 1300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Durante o turno do seu oponente, no c�lculo de dano: voc� pode descartar este card; voc� n�o sofre dano de batalha desta batalha (este � um Efeito R�pido).</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Kuriboh", 1, AtributoCard.Trevas, TipoCard.Demonio, efeitoRapido, 40650057, 300, 200, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>O que esta criatura falta em tamanho ele compensa em defesa quando lutando na pradaria.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Castor Guerreiro", 4, AtributoCard.Terra, TipoCard.BestaGuerreira, 32452818, 1200, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um mamute que protege os t�mulos do seu bando e que enfrenta ladr�es de t�mulos impiedosamente.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Cemit�rio de Mamutes", 3, AtributoCard.Terra, TipoCard.Dinossauro, 40374923, 1200, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um pequeno dem�nio brincalh�o que se esconde na escurid�o, esperando para atacar um inimigo descuidado.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Diabrete Selvagem", 4, AtributoCard.Trevas, TipoCard.Demonio, 41392891, 1300, 1400, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um drag�o normalmente encontrado protegendo fortalezas das montanhas. O seu ataque caracter�stico � um mergulho arrebatador vindo do c�u.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Drag�o Alado, Guardi�o da Fortaleza N�1", 4, AtributoCard.Vento, TipoCard.Dragao, 87796900, 1400, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Uma elfa delicada com pouco poder de ataque, mas com uma incr�vel defesa proveniente de poderes m�sticos.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Elfa M�stica", 4, AtributoCard.Luz, TipoCard.Mago, 15025844, 800, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um cavaleiro cujo cavalo galopa mais r�pido do que o vento. A sua carga de batalha � de uma for�a avassaladora.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Gaia, o Cavaleiro Impetuoso", 7, AtributoCard.Trevas, TipoCard.Guerreiro, 6368038, 2300, 2100, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um elfo que aprendeu a empunhar uma espada, ele confunde os inimigos com ataques rel�mpagos.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Guardi�o Celta", 4, AtributoCard.Terra, TipoCard.Guerreiro, 91152256, 1400, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>O mago definitivo em termos de ataque e defesa.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Mago Negro", 7, AtributoCard.Trevas, TipoCard.Mago, 46986414, 2500, 2100, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um drag�o perverso que se apoia nas for�as das trevas para executar um poderoso ataque.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Maldi��o do Drag�o", 5, AtributoCard.Trevas, TipoCard.Dragao, 28279543, 2000, 1500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>VIRE: Destr�i 1 Card de Armadilha no Campo. Se o alvo deste card est� com a face para baixo, vire a face para cima. Se for um Card de Armadilha � destru�do. Se n�o, coloque-o novamente com a face para baixo. O card virado n�o � ATIVADO.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Mestre das Armadilhas", 3, AtributoCard.Terra, TipoCard.Guerreiro, efeitoVirar, 46461247, 500, 1100, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Um guerreiro gigante feito de pedra. Um soco desta criatura faz com que a terra estrem�a.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Soldado Gigante de Pedra", 3, AtributoCard.Terra, TipoCard.Rocha, 13039848, 1300, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Uma perna direita, proibida e selada por magia. Qualquer um que romper este selo obter� poder infinito.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Perna Direita do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 8124921, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Uma perna esquerda, proibida e selada por magia. Qualquer um que romper este selo obter� poder infinito.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Perna Esquerda do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 44519536, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>'Maga Negra' + 'Buster Blader'. Deve ser Invocado por Invoca��o-Fus�o e n�o pode ser Invocado por Invoca��o-Especial de outras formas. Durante o turno de qualquer duelista, quando um Card de Magia for ativado: voc� pode descartar 1 card; negue a ativa��o e, se isso acontecer, destrua-o. Este card deve estar face para cima no campo para ativar e resolver este efeito. Este card ganha 500 de ATK para cada monstro do Tipo Drag�o no campo ou Cemit�rio de qualquer duelista.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Paladino Negro", 8, AtributoCard.Trevas, TipoCard.Mago, efeitoContinuo, 98502113, 2900, 2400, descricao);
		deckCardsFusao.add(cardMonstroComEfeito);
		
		descricao = "<html>Um dem�nio com poderes das trevas para confundir os inimigos. Entre os monstros do tipo dem�nio, � dos mais fortes.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Rei Caveira", 6, AtributoCard.Trevas, TipoCard.Demonio, 70781052, 2500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Voc� pode Invocar este card por Invoca��o-Especial com 'Ritual do Lustro Negro'.</html>";
		cardMonstroRitual = new CardMonstroRitual("Soldado do Lustro Negro", 8, AtributoCard.Terra, TipoCard.Guerreiro, 5405694, 3000, 2500, descricao);
		deckCards.add(cardMonstroRitual);
		
		descricao = "<html>'Drag�o Branco de Olhos Azuis' + 'Drag�o Branco de Olhos Azuis' + 'Drag�o Branco de Olhos Azuis'</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Supremo Drag�o Branco de Olhos Azuis", 12, AtributoCard.Luz, TipoCard.Dragao, 23995346, 4500, 3800, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "<html>Uma vez por turno: voc� pode oferecer 1 monstro como Tributo; cause dano ao seu oponente igual � metade do ATK que o monstro oferecido como Tributo tinha no campo.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Tartaruga Catapulta", 5, AtributoCard.Agua, TipoCard.Aqua, 95727991, 1000, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Muito mais do que um filhote, este drag�o � dotado de poderes ainda n�o revelados.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Beb� Drag�o", 3, AtributoCard.Vento, TipoCard.Dragao, 88819587, 1200, 700, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Quando este card for Invocado por Invoca��o-Normal ou Virar: voc� pode adicionar 1 'Gazelle, o Rei das Bestas M�sticas' do seu Deck � sua m�o.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Berfomet", 4, AtributoCard.Terra, TipoCard.Besta, 5818798, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Alfa, Beta e Gama se juntam em um para formar um monstro poderoso.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Beta, o Guerreiro Im�", 4, AtributoCard.Terra, TipoCard.Rocha, 39256679, 1700, 1600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um bra�o direito, proibido e selado por magia. Qualquer um que romper este selo obter� poder infinito.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Bra�o Direito do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 70903634, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um bra�o esquerdo, proibido e selado por magia. Qualquer um que romper este selo obter� poder infinito.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Bra�o Esquerdo do Proibido", 1, AtributoCard.Trevas, TipoCard.Mago, 7902349, 200, 300, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Este card ganha 500 de ATK para cada monstro do Tipo Drag�o que seu oponente controla ou que estiver no Cemit�rio dele.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Buster Blader", 7, AtributoCard.Terra, TipoCard.Guerreiro, efeitoContinuo, 78193831, 2600, 2300, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Este lend�rio drag�o � uma poderosa m�quina de destrui��o. Praticamente invenc�vel, muito poucos enfrentaram essa magnifica criatura e viveram para contar a hist�ria.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Drag�o Branco de Olhos Azuis", 8, AtributoCard.Luz, TipoCard.Dragao, 89631139, 3000, 2500, descricao);
		deckCards.add(cardMonstroSemEfeito);
		deckCards.add(cardMonstroSemEfeito);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>'Rei Caveira' + 'Drag�o Negro de Olhos Vermelhos'</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Drag�o Caveira Negro", 9, AtributoCard.Trevas, TipoCard.Dragao, 11901678, 3200, 2500, descricao);
		deckCardsFusao.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um drag�o mal�gno que cospe fogo. As suas chamas mal�ficas corrompem as almas de suas v�timas.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Drag�o Koumori", 4, AtributoCard.Trevas, TipoCard.Dragao, 67724379, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um drag�o feroz com um ataque letal.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Drag�o Negro de Olhos Vermelhos", 7, AtributoCard.Trevas, TipoCard.Dragao, 74677422, 2400, 2000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Um espadachim habilidoso que � metade serpente, metade humano. O golpe de sua espada � t�o r�pido como o som!</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Espada do Jacar�", 4, AtributoCard.Terra, TipoCard.Besta, 64428736, 1500, 1200, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Se, al�m deste card na sua m�o, voc� tiver 'Perna Direita do Proibido', 'Perna Esquerda do Proibido', 'Bra�o Direito do Proibido' e 'Bra�o Esquerdo do Proibido', voc� vence o Duelo.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Ex�dia, O Proibido", 3, AtributoCard.Trevas, TipoCard.Mago, 33396948, 1000, 1000, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Se este card atacar, ele � colocado em Posi��o de Defesa no final da Fase de Batalha e sua posi��o da batalha n�o pode mudar at� a Fase Final do seu pr�ximo turno.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("For�a de Ataque Goblin", 4, AtributoCard.Terra, TipoCard.Guerreiro, efeitoGatilho, 78658564, 2300, 0, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Um tubar�o branco gigante com dentes afiados como l�minas.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Grande Branco", 4, AtributoCard.Agua, TipoCard.Peixe, 13429800, 1600, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Com um machado em cada m�o, este monstro causa grandes estragos.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Imperador Cruel", 5, AtributoCard.Terra, TipoCard.BestaGuerreira, 26378150, 1800, 1600, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>VIRE: Escolha 1 monstro no campo; destrua o alvo.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Inseto Devorador de Homens", 2, AtributoCard.Terra, TipoCard.Inseto, efeitoVirar, 54652250, 450, 600, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Uma vez por turno: voc� pode lan�ar uma moeda e escolher cara ou coroa. Se voc� ganhar, destrua todos os monstros que seu oponente controla. Se voc� perder, destrua todos monstros que voc� controla e, se isso acontecer, voc� sofre dano igual � metade do ATK total que esses monstros destru�dos tinham no campo.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Mago do Tempo", 2, AtributoCard.Luz, TipoCard.Mago, efeitoGatilho, 71625222, 500, 400, descricao);
		deckCards.add(cardMonstroComEfeito);
		
		descricao = "<html>Um lobo da neve que, embora agrade aos olhos, � absolutamente feroz em batalha.</html>";
		cardMonstroSemEfeito = new CardMonstroSemEfeito("Presas de Prata", 3, AtributoCard.Terra, TipoCard.Besta, 90357090, 1200, 800, descricao);
		deckCards.add(cardMonstroSemEfeito);
		
		descricao = "<html>Quando este card for enviado do campo para o Cemit�rio: adicione 1 monstro com 1500 ou menos de ATK do seu Deck � sua m�o.</html>";
		cardMonstroComEfeito = new CardMonstroComEfeito("Sangan", 3, AtributoCard.Trevas, TipoCard.Demonio, efeitoGatilho, 26202165, 1000, 600, descricao);
		deckCards.add(cardMonstroComEfeito);
	}

	public List<Card> getDeck() {
		return deckCards;
	}
	
//	public List<Card> embaralhaERetornaDeck() {
//		List<Card> deckEmbaralhado = new ArrayList<>();
//		Random gerador = new Random();
//		
//		for(int i = deckCards.size(); i > 0; i--) {
//			int k = gerador.nextInt(i);
//			deckEmbaralhado.add(deckCards.get(k));
//			System.out.println(deckCards.get(k).getNome());
//			deckCards.remove(k);
//		}
//		
//		return deckEmbaralhado;
//	}
	
	public void retornaCards() {
		for(int i = 0; i < this.deckCards.size(); i++)
			System.out.println(this.deckCards.get(i).getNome());
	}

	
	public Card retornaCarta(int indice) {
		return deckCards.get(indice);
	}
	
	public void removeCardDeck(int indice) {
		this.deckCards.remove(indice);
	}
	
	public void embaralhaCards() {
		Collections.shuffle(deckCards);
	}
}
