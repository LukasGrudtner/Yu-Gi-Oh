package modelo;

import excecoes.ExcecaoAtaque;
import excecoes.ExcecaoPosicao;
import interfaces.Ataque;
import interfaces.Posicao;
import modelo.estados.estadosCard.estadosCardMonstro.AtaqueNaoRealizado;

public abstract class CardMonstro extends Card{
	
	private int nivel;
	private int ATK;
	private int DEF;
	private Posicao posicao;
	private Ataque ataque;
	
	public CardMonstro(String nome, int nivel, int numero, int ATK, int DEF, String descricao) {
		super(nome, numero, descricao);
		this.nivel = nivel;
		this.ATK = ATK;
		this.DEF = DEF;
		this.ataque = new AtaqueNaoRealizado(this);
	}
	
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
	
	public void mudaAtaque(Ataque ataque) {
		this.ataque = ataque;
	}
	
	public Ataque getAtaque() {
		return this.ataque;
	}
	
	public void mudaParaAtaqueRealizado() throws ExcecaoAtaque {
		ataque.mudaParaAtaqueRealizado();
	}
	
	public void mudaParaAtaqueNaoRealizado() throws ExcecaoAtaque {
		ataque.mudaParaAtaqueNaoRealizado();
	}
	
	public void mudaParaPosicaoAtaque() throws ExcecaoPosicao {
		posicao.mudaParaPosicaoAtaque();
	}
	
	public void mudaParaPosicaoDefesa() throws ExcecaoPosicao {
		posicao.mudaParaPosicaoDefesa();
	}
	
	public void mudaPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public Posicao getPosicao() {
		return this.posicao;
	}
}
