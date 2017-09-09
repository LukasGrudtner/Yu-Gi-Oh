package visao;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundSound {
	
	Clip clip;
	
	public void backgroundSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			clip  = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(500);
		} catch (Exception ex) {
			System.out.println("Erro ao executar SOM!");
			ex.printStackTrace();
		}
	}
	
	public void closeSound() {
		clip.close();
	}

}
