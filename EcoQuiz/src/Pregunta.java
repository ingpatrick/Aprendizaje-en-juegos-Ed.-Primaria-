
public class Pregunta {
    
    private String enunciado;
    private String[] alternativas;
    private int respuestaCorrecta;
    private String explicacion;

   public Pregunta(String enunciado,
                String[] alternativas,
                int respuestaCorrecta,
                String explicacion) {

    this.enunciado = enunciado;
    this.alternativas = alternativas;
    this.respuestaCorrecta = respuestaCorrecta;
    this.explicacion = explicacion;
}

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }
    
    public String getExplicacion() {
    return explicacion;
}

    public boolean validarRespuesta(int respuestaUsuario) {

        return respuestaUsuario == respuestaCorrecta;
    }
    
}
