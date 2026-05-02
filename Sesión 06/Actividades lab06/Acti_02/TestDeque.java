package Acti_02;

import Acti_01.ExceptionIsEmpty;

public class TestDeque {
    public static void main(String[] args) {

        try {
            DequeLink<Integer> deque = new DequeLink<>();

            deque.addFirst(10);
            deque.addLast(20);
            deque.addFirst(5);
            deque.addLast(30);

            System.out.println("Deque: " + deque);

            System.out.println("Primero: " + deque.getFirst());
            System.out.println("Último: " + deque.getLast());

            deque.removeFirst();
            System.out.println("Después de removeFirst: " + deque);

            deque.removeLast();
            System.out.println("Después de removeLast: " + deque);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}