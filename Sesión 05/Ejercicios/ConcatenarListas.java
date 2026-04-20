package com.mycompany.sesion_05;

public class ConcatenarListas {

    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; this.next = null; }
    }

    public static <T> Node<T> concatenarListas(Node<T> head1, Node<T> head2) {

        if (head1 == null) return copiarLista(head2);

        if (head2 == null) return copiarLista(head1);

        Node<T> nuevoHead = copiarLista(head1);

        Node<T> ultimo = nuevoHead;
        while (ultimo.next != null) {
            ultimo = ultimo.next;
        }

        ultimo.next = copiarLista(head2);

        return nuevoHead;
    }

    private static <T> Node<T> copiarLista(Node<T> head) {
        if (head == null) return null;
        Node<T> nuevoHead = new Node<>(head.data);
        Node<T> actual = head.next;
        Node<T> colaActual = nuevoHead;
        while (actual != null) {
            colaActual.next = new Node<>(actual.data);
            colaActual = colaActual.next;
            actual = actual.next;
        }
        return nuevoHead;
    }

    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo;
        Node<T> actual = head;
        while (actual.next != null) actual = actual.next;
        actual.next = nuevo;
        return head;
    }

    public static <T> void imprimirLista(String nombre, Node<T> head) {
        System.out.print(nombre + ": ");
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data);
            if (actual.next != null) System.out.print(" = ");
            actual = actual.next;
        }
        System.out.println(" = null");
    }

    public static void main(String[] args) {
        System.out.println("=== Caso 1: Integer + Integer ===");
        Node<Integer> l1 = null;
        l1 = insertarAlFinal(l1, 10);
        l1 = insertarAlFinal(l1, 20);
        l1 = insertarAlFinal(l1, 30);
        Node<Integer> l2 = null;
        l2 = insertarAlFinal(l2, 40);
        l2 = insertarAlFinal(l2, 50);
        imprimirLista("L1", l1);
        imprimirLista("L2", l2);
        imprimirLista("Resultado", concatenarListas(l1, l2));

        System.out.println("\n=== Caso 2: L1 vacia ===");
        imprimirLista("L1", null);
        imprimirLista("L2", l2);
        imprimirLista("Resultado", concatenarListas(null, l2));

        System.out.println("\n=== Caso 3: L2 vacia ===");
        imprimirLista("L1", l1);
        imprimirLista("L2", null);
        imprimirLista("Resultado", concatenarListas(l1, null));

        System.out.println("\n=== Caso 4: ambas vacias ===");
        imprimirLista("Resultado", concatenarListas(null, null));

        System.out.println("\n=== Caso 5: String + String ===");
        Node<String> s1 = null;
        s1 = insertarAlFinal(s1, "Hola");
        s1 = insertarAlFinal(s1, "mundo");
        Node<String> s2 = null;
        s2 = insertarAlFinal(s2, "desde");
        s2 = insertarAlFinal(s2, "Java");
        imprimirLista("S1", s1);
        imprimirLista("S2", s2);
        imprimirLista("Resultado", concatenarListas(s1, s2));
    }
}
