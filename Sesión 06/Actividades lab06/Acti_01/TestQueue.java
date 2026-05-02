package Acti_01;

public class TestQueue {
    public static void main(String[] args) {

        try {
            QueueArray<Integer> colaInt = new QueueArray<>(5);

            colaInt.enqueue(10);
            colaInt.enqueue(20);
            colaInt.enqueue(30);

            System.out.println("Cola Integer: " + colaInt);

            System.out.println("Front: " + colaInt.front());

            colaInt.dequeue();

            System.out.println("Después de dequeue: " + colaInt);

            QueueArray<String> colaStr = new QueueArray<>(5);

            colaStr.enqueue("A");
            colaStr.enqueue("B");
            colaStr.enqueue("C");

            System.out.println("\nCola String: " + colaStr);

            System.out.println("Front: " + colaStr.front());

            colaStr.dequeue();

            System.out.println("Después de dequeue: " + colaStr);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
