public class Tarea {
    private String titulo;
    private int prioridad;

    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Prioridad: " + prioridad;
    }
}