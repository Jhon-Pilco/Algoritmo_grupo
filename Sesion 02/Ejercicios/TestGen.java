
package Actividad_1.Sesion02;

//Ejercicio 1
public class TestGen {

    public static <T> boolean exist(T[] arreglo, T elemento) {
        for (T item : arreglo) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] v = {"Perez", "Sanchez", "Rodriguez"};
        Integer[] w = {12, 34, 56};

        System.out.println(exist(v, "Sanchez")); // true
        System.out.println(exist(w, 34));        // true

        // System.out.println(exist(w, "Salas")); // ❌ ERROR (tipos incompatibles)
    }
    
    
}