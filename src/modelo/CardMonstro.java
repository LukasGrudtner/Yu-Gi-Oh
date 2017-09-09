package modelo;

import excecoes.ExcecaoPosicao;
import interfaces.Posicao;

public abstract class CardMonstro extends Card{
	
	protected int nivel;
	protected int ATK;
	protected int DEF;
	protected AtributoCard atributoCard;
	protected TipoCard tipoCard;
	protected Posicao posicao;
	public enum AtributoCard{Terra, Trevas, Agua, Vento, Luz}
	public enum TipoCard{Anjo, Aqua, Besta, BestaGuerreira, Demonio, Dinossauro, Dragao, Guerreiro, Inseto, Mago, Peixe, Rocha, Zumbi}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public int getATK() {
		return this.ATK;
	}
	
	public int getDEF() {
		return this.DEF;
	}
	
	public void setATK(int ATK) {
		this.ATK = ATK;
	}
	
	public void setDEF(int DEF) {
		this.DEF = DEF;
	}
	
	public AtributoCard getAtributoCard() {
		return this.atributoCard;
	}
	
	public abstract TipoCard getTipoCard();
	
	public void mudaPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public void posicaoAtaque() throws ExcecaoPosicao {
		posicao.mudaParaPosicaoAtaque();
	}
	
	public void posicaoDefesa() throws ExcecaoPosicao {
		posicao.mudaParaPosicaoDefesa();
	}
}
