
package Actividad_1.Sesion02;

//Ejercicio 3
class Caja<T> {

    private T dato;
    private String color;

    public Caja(String color) {
        this.color = color;
    }

    public void guardar(T dato) {
        this.dato = dato;
    }

    public T obtener() {
        return dato;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Caja color: " + color + " | Contenido: " + dato;
    }
}