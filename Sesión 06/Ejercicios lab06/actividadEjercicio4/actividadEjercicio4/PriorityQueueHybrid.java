package actividadEjercicio4;

public class PriorityQueueHybrid<E> {

    private ColaOrdenada<E>[] niveles;
    private int n;

    @SuppressWarnings("unchecked")
    public PriorityQueueHybrid(int n) {
        this.n = n;
        niveles = new ColaOrdenada[n];
        for (int i = 0; i < n; i++) {
            niveles[i] = new ColaOrdenada<>();
        }
    }

    // INSERTAR
    public void enqueue(E data, int prioridad, int prioridadSecundaria) {
        if (prioridad >= 0 && prioridad < n) {
            niveles[prioridad].enqueue(data, prioridadSecundaria);
        } else {
            System.out.println("Prioridad inválida");
        }
    }

    // ELIMINAR: mayor prioridad primero
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = n - 1; i >= 0; i--) {
            if (!niveles[i].estaVacia()) {
                return niveles[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola vacía");
    }

    public boolean estaVacia() {
        for (int i = 0; i < n; i++) {
            if (!niveles[i].estaVacia()) return false;
        }
        return true;
    }
}