public class GestorDeTareas<T> {
    private Node<T> head;

    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevo;
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> actual = head;
        while (actual.next != null) {
            if (actual.next.data.equals(tarea)) {
                actual.next = actual.next.next;
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }

    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> actual = head;
        Node<T> next;

        while (actual != null) {
            next = actual.next;
            actual.next = prev;
            prev = actual;
            actual = next;
        }
        head = prev;
    }

    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;

        Node<T> actual = head;
        T max = actual.data;

        while (actual != null) {
            if (actual.data instanceof Tarea) {
                Tarea t1 = (Tarea) actual.data;
                Tarea t2 = (Tarea) max;

                if (t1.getPrioridad() > t2.getPrioridad()) {
                    max = actual.data;
                }
            }
            actual = actual.next;
        }
        return max;
    }
}