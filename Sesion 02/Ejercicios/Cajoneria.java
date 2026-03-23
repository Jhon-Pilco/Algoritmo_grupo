
package Actividad_1.Sesion02;
//Ejercicio 3
import java.util.ArrayList;
import java.util.Iterator;

class Cajoneria implements Iterable<Caja<?>> {

    private ArrayList<Caja<?>> lista = new ArrayList<>();
    private int tope;

    public Cajoneria(int tope) {
        this.tope = tope;
    }

    public void add(Caja<?> caja) {
        if (lista.size() < tope) {
            lista.add(caja);
        } else {
            throw new RuntimeException("No caben mas cajas");
        }
    }

    public Iterator<Caja<?>> iterator() {
        return lista.iterator();
    }

    // 4.1 MÉTODO SEARCH
    public String search(Object elemento) {

        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);

            if (caja.obtener().equals(elemento)) {
                return "Encontrado en posicion: " + i +
                       " | Color: " + caja.getColor();
            }
        }

        return "Elemento no encontrado";
    }

    // 4.2 MÉTODO DELETE
    public Object delete(Object elemento) {

        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);

            if (caja.obtener().equals(elemento)) {
                Object eliminado = caja.obtener();
                lista.remove(i);
                return eliminado;
            }
        }

        return null;
    }

    // 4.3 MÉTODO toString
    public String toString() {

        String resultado = "Posicion | Color Caja | Objeto\n";

        for (int i = 0; i < lista.size(); i++) {
            Caja<?> caja = lista.get(i);

            resultado += (i + 1) + "        | "
                      + caja.getColor() + "      | "
                      + caja.obtener() + "\n";
        }

        return resultado;
    }
    
    
    
    
    
    
    //Ejercicio 6
    public int contar(Object elemento) {

    int contador = 0;

    for (Caja<?> caja : lista) {
        if (caja.obtener().equals(elemento)) {
            contador++;
        }
    }

    return contador;
}
}