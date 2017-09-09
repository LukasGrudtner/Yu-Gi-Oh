package modelo;

import excecoes.ExcecaoFace;
import interfaces.Face;

public abstract class Card {
	
	private String nome;
	private Tipo tipo;
	private int numero;
	private String descricao;
	private Face face;
	
	public Card(String nome, int numero, String descricao) {
		this.nome = nome;
		this.numero = numero;
		this.descricao = descricao;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public Face getFace() {
		return this.face;
	}
	
	public void mudaFace(Face face) {
		this.face = face;
	}
	
	public void mudaFaceParaCima() throws ExcecaoFace {
		face.mudaFaceParaCima();
	}
	
	public void mudaFaceParaBaixo() throws ExcecaoFace {
		face.mudaFaceParaBaixo();
	}
	
	
}
