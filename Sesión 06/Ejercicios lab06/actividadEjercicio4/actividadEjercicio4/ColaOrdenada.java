package actividadEjercicio4;

public class ColaOrdenada<E> {

    private Node<E> head;

    public ColaOrdenada() {
        head = null;
    }

    // INSERTAR ORDENADO
    public void enqueue(E data, int prioridadSecundaria) {
        Node<E> nuevo = new Node<>(data, prioridadSecundaria);

        if (head == null || prioridadSecundaria < head.prioridadSecundaria) {
            nuevo.next = head;
            head = nuevo;
        } else {
            Node<E> actual = head;

            while (actual.next != null &&
                   actual.next.prioridadSecundaria <= prioridadSecundaria) {
                actual = actual.next;
            }

            nuevo.next = actual.next;
            actual.next = nuevo;
        }
    }

    // ELIMINAR (FIFO ya que está ordenado)
    public E dequeue() throws ExceptionIsEmpty {
        if (estaVacia()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E dato = head.data;
        head = head.next;
        return dato;
    }

    public boolean estaVacia() {
        return head == null;
    }
}