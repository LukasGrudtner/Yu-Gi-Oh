package modelo;

import excecoes.ExcecaoFace;
import interfaces.Face;
import interfaces.Modo;

public abstract class Card {
	
	public String nome;
	public Tipo tipo;
	public int numero;
	public String descricao;
	protected Face face;
	
	
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
	
	public void faceParaCima() throws ExcecaoFace {
		face.mudaFaceParaCima();
	}
	
	public void faceParaBaixo() throws ExcecaoFace {
		face.mudaFaceParaBaixo();
	}
}
