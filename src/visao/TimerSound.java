package visao;

import javax.swing.JFrame;

public class TimerSound extends Thread {
	
	PlaySound sound;
	int tempo;
	
	public TimerSound(PlaySound sound, int tempo) {
		this.tempo = tempo;
		this.sound = sound;
	}
	public void run() {
		while(true) {
			try{sleep(tempo);}catch(Exception erro){};
			sound.closeSound();
		}
	}

}
