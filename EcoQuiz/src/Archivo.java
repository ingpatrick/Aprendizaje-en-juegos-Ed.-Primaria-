import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Archivo {
    
    private final String archivo = "puntajes.txt";

    public void guardarResultado(String nombre, int puntaje) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(archivo, true));

            writer.write(nombre + " - Puntaje: " + puntaje);

            writer.newLine();

            writer.close();

        } catch (IOException e) {

            System.out.println("Error al guardar resultados");
        }
    }
    
}
