package visao;

import javax.swing.JFrame;

public class Timer extends Thread{
	JFrame frame;
	int tempo;
	
	public Timer(JFrame frame, int tempo) {
		this.tempo = tempo;
		this.frame = frame;
	}
	public void run() {
		while(true) {
			try{sleep(tempo);}catch(Exception erro){};
			frame.dispose();
		}
	}

}
