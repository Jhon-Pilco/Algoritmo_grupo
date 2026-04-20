package com.mycompany.sesion_05;

public class CompararListas {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
        Node<T> actual1 = head1;
        Node<T> actual2 = head2;

        while (actual1 != null && actual2 != null) {
            if (!actual1.data.equals(actual2.data)) {
                return false;                    
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }

        return actual1 == null && actual2 == null;
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
            if (actual.next != null) System.out.print(" → ");
            actual = actual.next;
        }
        System.out.println(" = null");
    }

    public static void main(String[] args) {
        System.out.println("=== Caso 1: listas iguales ===");
        Node<Integer> l1 = null;
        l1 = insertarAlFinal(l1, 10);
        l1 = insertarAlFinal(l1, 20);
        l1 = insertarAlFinal(l1, 30);
        Node<Integer> l2 = null;
        l2 = insertarAlFinal(l2, 10);
        l2 = insertarAlFinal(l2, 20);
        l2 = insertarAlFinal(l2, 30);
        imprimirLista("L1", l1);
        imprimirLista("L2", l2);
        System.out.println("¿Son iguales? " + sonIguales(l1, l2));

        System.out.println("\n=== Caso 2: mismo tamano, distinto valor ===");
        Node<Integer> l3 = null;
        l3 = insertarAlFinal(l3, 10);
        l3 = insertarAlFinal(l3, 99);
        l3 = insertarAlFinal(l3, 30);
        imprimirLista("L1", l1);
        imprimirLista("L3", l3);
        System.out.println("¿Son iguales? " + sonIguales(l1, l3));

        System.out.println("\n=== Caso 3: distinto tamano ===");
        Node<Integer> l4 = null;
        l4 = insertarAlFinal(l4, 10);
        l4 = insertarAlFinal(l4, 20);
        imprimirLista("L1", l1);
        imprimirLista("L4", l4);
        System.out.println("¿Son iguales? " + sonIguales(l1, l4));

        System.out.println("\n=== Caso 4: ambas vacias ===");
        System.out.println("¿Son iguales? " + sonIguales(null, null));

        System.out.println("\n=== Caso 5: listas de String ===");
        Node<String> s1 = null;
        s1 = insertarAlFinal(s1, "Ana");
        s1 = insertarAlFinal(s1, "Luis");
        Node<String> s2 = null;
        s2 = insertarAlFinal(s2, "Ana");
        s2 = insertarAlFinal(s2, "Luis");
        imprimirLista("S1", s1);
        imprimirLista("S2", s2);
        System.out.println("¿Son iguales? " + sonIguales(s1, s2));
    }
}
