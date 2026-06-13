import javax.sound.sampled.*;
import java.io.File;

public class sonidos {

    private Clip correcto;
    private Clip incorrecto;

    public sonidos() {

        try {

            AudioInputStream a1 =
                    AudioSystem.getAudioInputStream(
                            new File("src/sonidos/correcto.wav"));

            correcto = AudioSystem.getClip();
            correcto.open(a1);

            AudioInputStream a2 =
                    AudioSystem.getAudioInputStream(
                            new File("src/sonidos/incorrecto.wav"));

            incorrecto = AudioSystem.getClip();
            incorrecto.open(a2);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void reproducirCorrecto() {

        correcto.setFramePosition(0);
        correcto.start();
    }

    public void reproducirIncorrecto() {

        incorrecto.setFramePosition(0);
        incorrecto.start();
    }
}

