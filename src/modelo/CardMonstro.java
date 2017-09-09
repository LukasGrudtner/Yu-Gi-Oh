package modelo;

import excecoes.ExcecaoModo;
import interfaces.Modo;

public abstract class CardMonstro extends Card{
	
	protected int nivel;
	protected int ATK;
	protected int DEF;
	protected AtributoCard atributoCard;
	protected TipoCard tipoCard;
	protected Modo modo;
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
	
	public void mudaModo(Modo modo) {
		this.modo = modo;
	}
	
	public void modoAtaque() throws ExcecaoModo {
		modo.mudaParaModoAtaque();
	}
	
	public void modoDefesa() throws ExcecaoModo {
		modo.mudaParaModoDefesa();
	}
}
