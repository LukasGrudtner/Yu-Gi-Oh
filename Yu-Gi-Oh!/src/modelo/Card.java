package modelo;

public abstract class Card {
	
	public String nome;
	public Tipo tipo;
	public int numero;
	public String descricao;
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	

}
