
package Ejercicio_2;


public class Zona {

    String mineral;
    int cantidad;
    double pureza;
    
    public Zona(String mineral, int cantidad, double pureza){
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }
    
    public double calcularValor() {
        return cantidad * pureza;
    }
    
    @Override
    public String toString() {
        return "[ " + mineral + ", cantidad: " + cantidad + ", pureza: " + pureza + " ]";
    }
            
}
