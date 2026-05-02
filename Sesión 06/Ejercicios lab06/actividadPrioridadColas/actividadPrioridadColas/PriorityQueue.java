package actividadPrioridadColas;

public class PriorityQueue<E> {

    private Cola<E>[] queues;
    private int niveles;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int niveles) {
        this.niveles = niveles;
        queues = new Cola[niveles];
        for (int i = 0; i < niveles; i++) {
            queues[i] = new Cola<>();
        }
    }

    // ENQUEUE con prioridad
    public void enqueue(E x, int prioridad) {
        if (prioridad >= 0 && prioridad < niveles) {
            queues[prioridad].enqueue(x);
        } else {
            System.out.println("Prioridad inválida");
        }
    }

    // DEQUEUE: de mayor prioridad a menor
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) {
            if (!queues[i].estaVacia()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola vacía");
    }

    public boolean estaVacia() {
        for (int i = 0; i < niveles; i++) {
            if (!queues[i].estaVacia()) return false;
        }
        return true;
    }
}