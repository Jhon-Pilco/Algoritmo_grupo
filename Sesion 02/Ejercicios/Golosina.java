package Actividad_1.Sesion02;


public class Golosina {
    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String toString() {
        return "Golosina: " + nombre + " - Peso: " + peso;
    }
    
    //Se agrega para el ejercicio 1
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Golosina g = (Golosina) obj;
        return this.nombre.equals(g.nombre) && this.peso == g.peso;
    }
    
}
