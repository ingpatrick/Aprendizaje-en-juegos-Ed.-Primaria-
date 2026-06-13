import java.util.ArrayList;

public class Juego {
    
    private ArrayList<Pregunta> preguntas;
    private int indicePregunta;
    private Usuario usuario;

    public Juego(Usuario usuario) {

        this.usuario = usuario;

        preguntas = new ArrayList<>();

        indicePregunta = 0;

        cargarPreguntas();
    }

    private void cargarPreguntas() {

         preguntas.add(new Pregunta(
        "¿Qué debemos hacer con la basura?",
        new String[]{"Botarla en el tacho", "Tirarla al suelo", "Dejarla en la calle"},
        0,
        "La basura debe colocarse en los tachos para mantener limpio el ambiente."));

preguntas.add(new Pregunta(
        "¿Qué recurso debemos ahorrar al lavarnos las manos?",
        new String[]{"Agua", "Basura", "Humo"},
        0,
        "El agua es un recurso muy importante que debemos cuidar."));

preguntas.add(new Pregunta(
        "¿Qué debemos hacer al salir de un salón vacío?",
        new String[]{"Dejar las luces encendidas", "Apagar las luces", "Romper los focos"},
        1,
        "Apagar las luces ayuda a ahorrar energía."));

preguntas.add(new Pregunta(
        "¿Qué ayuda a mantener limpio el planeta?",
        new String[]{"Reciclar", "Contaminar", "Quemar basura"},
        0,
        "Reciclar permite reutilizar materiales y reducir residuos."));

preguntas.add(new Pregunta(
        "¿Qué debemos hacer con una botella de plástico vacía?",
        new String[]{"Reciclarla", "Tirarla al río", "Dejarla en el parque"},
        0,
        "Las botellas de plástico pueden reciclarse y convertirse en nuevos productos."));

preguntas.add(new Pregunta(
        "¿Por qué son importantes los árboles?",
        new String[]{"Porque ayudan a limpiar el aire", "Porque producen basura", "Porque contaminan"},
        0,
        "Los árboles producen oxígeno y ayudan a mantener limpio el aire."));

preguntas.add(new Pregunta(
        "¿Qué debemos hacer para cuidar un parque?",
        new String[]{"Mantenerlo limpio", "Arrancar las plantas", "Botar basura"},
        0,
        "Los parques deben mantenerse limpios para que todos puedan disfrutarlos."));

preguntas.add(new Pregunta(
        "¿Cuál de estas acciones cuida el medio ambiente?",
        new String[]{"Reutilizar materiales", "Desperdiciar agua", "Ensuciar las calles"},
        0,
        "Reutilizar materiales ayuda a generar menos residuos."));

preguntas.add(new Pregunta(
        "¿Qué debemos hacer si vemos basura en el suelo?",
        new String[]{"Recogerla o avisar a un adulto", "Ignorarla", "Patearla"},
        0,
        "Mantener los espacios limpios es responsabilidad de todos."));

preguntas.add(new Pregunta(
        "¿Qué podemos usar para llevar nuestras compras y reducir el uso de plástico?",
        new String[]{"Bolsa reutilizable", "Muchas bolsas descartables", "Más envolturas de plástico"},
        0,
        "Las bolsas reutilizables ayudan a reducir la contaminación por plástico."));
}

    public Pregunta obtenerPreguntaActual() {

        return preguntas.get(indicePregunta);
    }

    public boolean verificarRespuesta(int respuesta) {

        boolean correcta =
                preguntas.get(indicePregunta)
                        .validarRespuesta(respuesta);

        if (correcta) {

            usuario.aumentarPuntaje();
        }

        return correcta;
    }

    public void siguientePregunta() {

        indicePregunta++;
    }

    public boolean finJuego() {

        return indicePregunta >= preguntas.size();
    }

    public Usuario getUsuario() {

        return usuario;
    }
    
}
