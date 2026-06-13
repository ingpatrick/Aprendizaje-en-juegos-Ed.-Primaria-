import javax.swing.*;
import java.awt.*;


public class resultados_visual extends JFrame {
 
    public resultados_visual(String nombre, int puntaje) {
        setTitle("Resultado final");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitulo = new JLabel("Resultado de " + nombre, JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblPuntaje = new JLabel("Puntaje obtenido: " + puntaje + " de 10", JLabel.CENTER);
        lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 16));

        JProgressBar barra = new JProgressBar(0, 10);
        barra.setValue(puntaje);
        barra.setStringPainted(true);

        JLabel lblMensaje = new JLabel("", JLabel.CENTER);

       if (puntaje >= 9) {
       lblMensaje.setText("¡Excelente! Eres un héroe del medio ambiente.");
       } else if (puntaje >= 7) {
       lblMensaje.setText("¡Muy bien! Sabes mucho sobre cómo cuidar el planeta.");
       } else if (puntaje >= 5) {
       lblMensaje.setText("¡Buen trabajo! Sigue aprendiendo sobre el medio ambiente.");
       } else {
       lblMensaje.setText("No te rindas. Puedes volver a intentarlo y aprender más.");
       }

        setLayout(new GridLayout(4, 1));
        add(lblTitulo);
        add(lblPuntaje);
        add(barra);
        add(lblMensaje);
    }
    
    
}
