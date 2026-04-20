package com.mycompany.sesion_05;


public class ListaEnlazada {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor); 

        if (head == null) {                
            return nuevo;
        }

        Node<T> actual = head;              
        while (actual.next != null) {        
            actual = actual.next;
        }
        actual.next = nuevo;                 

        return head;                        
    }

    public static <T> void imprimirLista(Node<T> head) {
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data);
            if (actual.next != null) System.out.print(" = ");
            actual = actual.next;
        }
        System.out.println(" = null");
    }

    public static void main(String[] args) {

        System.out.println("=== Lista de Integer ===");
        Node<Integer> head = null;
        head = insertarAlFinal(head, 10);
        head = insertarAlFinal(head, 20);
        head = insertarAlFinal(head, 30);
        head = insertarAlFinal(head, 99);
        imprimirLista(head);

        System.out.println("\n=== Lista de String ===");
        Node<String> headStr = null;
        headStr = insertarAlFinal(headStr, "Ana");
        headStr = insertarAlFinal(headStr, "Luis");
        headStr = insertarAlFinal(headStr, "Maria");
        imprimirLista(headStr);

        System.out.println("\n=== Lista vacia ===");
        Node<Double> headVacio = null;
        headVacio = insertarAlFinal(headVacio, 3.14);
        imprimirLista(headVacio);
    }
}
