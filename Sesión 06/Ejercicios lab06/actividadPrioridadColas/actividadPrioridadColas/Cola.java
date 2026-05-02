package actividadPrioridadColas;

public class Cola<E> {

    private Node<E> frente;
    private Node<E> fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    // ENCOLAR
    public void enqueue(E x) {
        Node<E> nuevo = new Node<>(x);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.setNext(nuevo);
            fin = nuevo;
        }
    }

    // DESENCOLAR
    public E dequeue() throws ExceptionIsEmpty {
        if (estaVacia()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E dato = frente.getData();
        frente = frente.getNext();
        if (frente == null) fin = null;
        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}