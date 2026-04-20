import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> completadas = new ArrayList<>();

        Tarea t1 = new Tarea("Estudiar", 3);
        Tarea t2 = new Tarea("Programar", 5);
        Tarea t3 = new Tarea("Dormir", 1);

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);

        gestor.eliminarTarea(t3);

        gestor.imprimirTareas();

        System.out.println("Existe tarea Programar: " + gestor.contieneTarea(t2));

        gestor.invertirTareas();

        completadas.add(t2);
        gestor.eliminarTarea(t2);

        System.out.println("Tareas pendientes:");
        gestor.imprimirTareas();

        System.out.println("Tareas completadas:");
        for (Tarea t : completadas) {
            System.out.println(t);
        }
    }
}