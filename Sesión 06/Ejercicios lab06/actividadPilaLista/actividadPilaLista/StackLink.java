package actividadPilaLista;

public class StackLink<E> implements Stack<E> {

    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    // INSERTAR (LIFO)
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);
        nuevo.setNext(top);
        top = nuevo;
    }

    // ELIMINAR
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E dato = top.getData();
        top = top.getNext();
        return dato;
    }

    // VER TOPE
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return top.getData();
    }

    // VERIFICAR VACÍA
    public boolean isEmpty() {
        return top == null;
    }

    // MOSTRAR PILA
    public String toString() {
        String resultado = "";
        Node<E> aux = top;

        while (aux != null) {
            resultado += aux.getData() + " -> ";
            aux = aux.getNext();
        }

        return resultado + "null";
    }
}