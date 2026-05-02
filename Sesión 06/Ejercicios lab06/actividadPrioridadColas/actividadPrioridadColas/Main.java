package actividadPrioridadColas;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<String> cola = new PriorityQueue<>(3);

        cola.enqueue("A", 0);
        cola.enqueue("B", 2);
        cola.enqueue("C", 1);
        cola.enqueue("D", 2);

        try {
            while (!cola.estaVacia()) {
                System.out.println(cola.dequeue());
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}