
package Actividad_1.Sesion02;


public class DemoMetodoGenerico {
    static <T, U> boolean igualArrays (T[] x, U[] y){
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++)
            if (!x[i].toString().equals(y[i].toString())) { //el poder de la fuerza
                return false; //arrays diferentes
            }
        return true; 
        }
    
}
