package modelo;

import excecoes.ExcecaoAtaque;
import modelo.estados.TurnoComputador;
import modelo.estados.TurnoJogador;
import modelo.estados.estadosCard.PosicaoAtaque;

public class Battle {

	CampoDeBatalha campoDeBatalha;
	CardMonstro cardAtacante;
	CardMonstro cardAlvo;
	int resultado;

	public Battle(CampoDeBatalha campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}

	public void setCardAtacante(CardMonstro cardAtacante) {

		if (campoDeBatalha.getTurno() instanceof TurnoJogador && campoDeBatalha.getCardsMonstrosDoCampoDoComputador().size() == 0) {
			resultado = cardAtacante.getATK();
			campoDeBatalha.setVidaComputador(resultado);
			try {
				cardAtacante.mudaParaAtaqueRealizado();
			} catch (ExcecaoAtaque e) {
			}
			campoDeBatalha.setCardEnabledJogador();
			resetBattle();
		}
		if (campoDeBatalha.getTurno() instanceof TurnoComputador && campoDeBatalha.getCardsMonstrosDoCampoDoJogador().size() == 0) {
				
			resultado = cardAtacante.getATK();
			campoDeBatalha.setVidaJogador(resultado);
			try {
				cardAtacante.mudaParaAtaqueRealizado();
			} catch (ExcecaoAtaque e) {
			}
			campoDeBatalha.setCardEnabledComputador();
			resetBattle();
		} else
			this.cardAtacante = cardAtacante;
	}

	public void setCardAlvo(CardMonstro cardAlvo) {
		this.cardAlvo = cardAlvo;
		iniciaCalculo();
	}

	public void iniciaCalculo() {
		if (campoDeBatalha.getTurno() instanceof TurnoJogador)
			calculaDanoParaJogador();
		if (campoDeBatalha.getTurno() instanceof TurnoComputador)
			calculaDanoParaComputador();
	}

	public void calculaDanoParaJogador() {

		if (cardAtacante != null) {
			try {
				cardAtacante.mudaParaAtaqueRealizado();
			} catch (ExcecaoAtaque e) {
			}

			if (cardAlvo.getPosicao() instanceof PosicaoAtaque) {
				resultado = cardAtacante.getATK() - cardAlvo.getATK();

				if (resultado > 0) {
					campoDeBatalha.setVidaComputador(resultado);
					campoDeBatalha.setCardEnabledJogador();
					campoDeBatalha.destroiCardComputador(cardAlvo);
				}
				if (resultado < 0) {
					campoDeBatalha.setVidaJogador(resultado * (-1));
					campoDeBatalha.destroiCardJogador(cardAtacante);
				}

				if (resultado == 0) {
					campoDeBatalha.destroiCardJogador(cardAtacante);
					campoDeBatalha.destroiCardComputador(cardAlvo);
				}
				resetBattle();
			}

			else {
				resultado = cardAtacante.getATK() - cardAlvo.getDEF();

				if (resultado > 0) {
					campoDeBatalha.setVidaComputador(0);
					campoDeBatalha.setCardEnabledJogador();
					campoDeBatalha.destroiCardComputador(cardAlvo);
				}
				if (resultado < 0) {
					campoDeBatalha.setVidaJogador(resultado * (-1));
					campoDeBatalha.destroiCardJogador(cardAtacante);
				}

				if (resultado == 0) {
					campoDeBatalha.destroiCardJogador(cardAtacante);
					campoDeBatalha.destroiCardComputador(cardAlvo);
				}
				resetBattle();
			}
		}
	}

	public void calculaDanoParaComputador() {
		// if(cardAlvo == null)
		// return;
		if (cardAtacante != null) {
			try {
				cardAtacante.mudaParaAtaqueRealizado();
			} catch (ExcecaoAtaque e) {
			}

			if (cardAlvo.getPosicao() instanceof PosicaoAtaque) {
				resultado = cardAtacante.getATK() - cardAlvo.getATK();

				if (resultado > 0) {
					campoDeBatalha.setVidaJogador(resultado);
					campoDeBatalha.setCardEnabledComputador();
					campoDeBatalha.destroiCardJogador(cardAlvo);
				}
				if (resultado < 0) {
					campoDeBatalha.setVidaComputador(resultado * (-1));
					campoDeBatalha.destroiCardComputador(cardAtacante);
				}
				if (resultado == 0) {
					campoDeBatalha.destroiCardJogador(cardAlvo);
					campoDeBatalha.destroiCardComputador(cardAtacante);
				}
				resetBattle();
			}

			else {
				resultado = cardAtacante.getATK() - cardAlvo.getDEF();

				if (resultado > 0) {
					campoDeBatalha.setVidaJogador(0);
					campoDeBatalha.setCardEnabledComputador();
					campoDeBatalha.destroiCardJogador(cardAlvo);
				}
				if (resultado < 0) {
					campoDeBatalha.setVidaComputador(resultado * (-1));
					campoDeBatalha.destroiCardComputador(cardAtacante);
				}
				if (resultado == 0) {
					campoDeBatalha.destroiCardJogador(cardAlvo);
					campoDeBatalha.destroiCardComputador(cardAtacante);
				}
				resetBattle();

			}
		}
	}

	public void resetBattle() {
		this.cardAtacante = null;
		this.cardAlvo = null;
	}

}
