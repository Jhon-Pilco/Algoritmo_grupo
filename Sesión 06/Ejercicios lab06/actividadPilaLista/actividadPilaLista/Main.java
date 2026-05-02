package actividadPilaLista;

public class Main {
    public static void main(String[] args) {

        StackLink<Integer> pila = new StackLink<>();

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Pila: " + pila);

        try {
            System.out.println("Top: " + pila.top());
            System.out.println("Pop: " + pila.pop());
            System.out.println("Pila después de pop: " + pila);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}