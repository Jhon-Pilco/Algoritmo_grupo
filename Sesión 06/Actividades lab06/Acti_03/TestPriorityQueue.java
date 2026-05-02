package Acti_03;

import Acti_01.ExceptionIsEmpty;

public class TestPriorityQueue {
    public static void main(String[] args) {

        try {
            PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

            pq.enqueue("Juan", 2);
            pq.enqueue("Ana", 5);
            pq.enqueue("Luis", 3);
            pq.enqueue("Pedro", 1);

            System.out.println("Cola de prioridad:");
            System.out.println(pq);

            System.out.println("Front (mayor prioridad): " + pq.front());
            System.out.println("Back (menor prioridad): " + pq.back());

            System.out.println("Dequeue: " + pq.dequeue());

            System.out.println("Después de dequeue:");
            System.out.println(pq);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
