package actividadEjercicio4;

public class Node<E> {
    E data;
    int prioridadSecundaria;
    Node<E> next;

    public Node(E data, int prioridadSecundaria) {
        this.data = data;
        this.prioridadSecundaria = prioridadSecundaria;
        this.next = null;
    }
}