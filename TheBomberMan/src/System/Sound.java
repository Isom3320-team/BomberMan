package System;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;




public class Sound {

		public void playSound(String filepath, boolean loop) {
			try {
				Clip clip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem
						.getAudioInputStream(getClass().getResource(filepath));

				clip.open(inputStream);
				if (loop) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} else {
					clip.start();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
