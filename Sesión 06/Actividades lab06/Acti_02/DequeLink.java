package Acti_02;

import Acti_01.ExceptionIsEmpty;

class DequeLink<E> implements Deque<E> {

    private Node<E> first;
    private Node<E> last;

    public DequeLink() {
        first = null;
        last = null;
    }

    // Insertar al inicio
    public void addFirst(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            nuevo.next = first;
            first = nuevo;
        }
    }

    // Insertar al final
    public void addLast(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            last.next = nuevo;
            last = nuevo;
        }
    }

    // Eliminar del inicio
    public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        E dato = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return dato;
    }

    // Eliminar del final
    public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        E dato = last.data;

        if (first == last) {
            first = last = null;
        } else {
            Node<E> temp = first;

            while (temp.next != last) {
                temp = temp.next;
            }

            temp.next = null;
            last = temp;
        }

        return dato;
    }

    // Ver primero
    public E getFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }
        return first.data;
    }

    // Ver último
    public E getLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }
        return last.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String resultado = "";
        Node<E> temp = first;

        while (temp != null) {
            resultado += temp.data + " ";
            temp = temp.next;
        }

        return resultado;
    }
}