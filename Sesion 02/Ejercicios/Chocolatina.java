
package Actividad_1.Sesion02;


public class Chocolatina {
    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String toString() {
        return "Chocolatina: " + marca;
    }
    
    //Se agrega para el ejercicio 1
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Chocolatina c = (Chocolatina) obj;
        return this.marca.equals(c.marca);
    }
}
