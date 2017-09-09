package modelo;

public class CardMonstroSemEfeito extends CardMonstro {
	
	public CardMonstroSemEfeito(String nome, int nivel, AtributoCard atributoCard, TipoCard tipoCard, int numero, int ATK, int DEF, String descricao) {
		this.nome = nome;
		this.nivel = nivel;
		this.atributoCard = atributoCard;
		this.tipoCard = tipoCard;
		this.numero = numero;
		this.ATK = ATK;
		this.DEF = DEF;
		this.descricao = descricao;
	}

	@Override
	public TipoCard getTipoCard() {
		return this.tipoCard;
	}

}
