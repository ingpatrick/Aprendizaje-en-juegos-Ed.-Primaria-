
public class Usuario {
    
    private String nombre;
    private int puntaje;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void aumentarPuntaje() {
        puntaje++;
    }
}

