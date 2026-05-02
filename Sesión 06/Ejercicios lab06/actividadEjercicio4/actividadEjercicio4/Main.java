package actividadEjercicio4;

public class Main {
    public static void main(String[] args) {

        PriorityQueueHybrid<String> cola = new PriorityQueueHybrid<>(3);

        cola.enqueue("A", 2, 5);
        cola.enqueue("B", 2, 1);
        cola.enqueue("C", 1, 3);
        cola.enqueue("D", 2, 3);

        try {
            while (!cola.estaVacia()) {
                System.out.println(cola.dequeue());
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}