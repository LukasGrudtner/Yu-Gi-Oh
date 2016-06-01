package modelo;

public abstract class CardMonstro extends Card{
	
	protected int nivel;
	protected int ATK;
	protected int DEF;
	protected AtributoCard atributoCard;
	protected TipoCard tipoCard;
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

}
