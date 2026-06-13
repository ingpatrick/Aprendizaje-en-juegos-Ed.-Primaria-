import javax.sound.sampled.*;
import java.io.File;

public class musica {

    private Clip clip;

    public void reproducirMusica(String ruta) {
        try {
            File archivoMusica = new File(ruta);

            if (archivoMusica.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(archivoMusica);
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
                System.out.println("No se encontró el archivo de música: " + ruta);
            }
         
        } catch (Exception e) {
            System.out.println("Error al reproducir música: " + e.getMessage());
        }
    }

    public void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}