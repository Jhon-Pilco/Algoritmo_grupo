package actividadColaArreglo;

public class ColaArreglo {

    private int[] cola;
    private int frente;
    private int fin;
    private int tamaño;
    private int capacidad;

    public ColaArreglo(int capacidad) {
        this.capacidad = capacidad;
        cola = new int[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    // ENCOLAR
    public void encolar(int x) throws ExceptionIsFull {
        if (estaLlena()) {
            throw new ExceptionIsFull("Cola llena");
        }
        fin = (fin + 1) % capacidad; // circular
        cola[fin] = x;
        tamaño++;
    }

    // DESENCOLAR
    public int desencolar() throws ExceptionIsEmpty {
        if (estaVacia()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        int valor = cola[frente];
        frente = (frente + 1) % capacidad; // circular
        tamaño--;
        return valor;
    }

    // VER FRENTE
    public int frente() throws ExceptionIsEmpty {
        if (estaVacia()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return cola[frente];
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }
}