
package Actividad_1.Sesion02;


public class App {
    public static void main(String[] args) {

        
        //Ejercicio 4
        /*Cajoneria cajoneria = new Cajoneria(3);

        Caja<Integer> c1 = new Caja<>("Rojo");
        c1.guardar(100);

        Caja<String> c2 = new Caja<>("Amarillo");
        c2.guardar("Hola");

        Caja<Golosina> c3 = new Caja<>("Verde");
        c3.guardar(new Golosina("Caramelo", 0.2));

        cajoneria.add(c1);
        cajoneria.add(c2);
        cajoneria.add(c3);

        //SEARCH
        System.out.println(cajoneria.search("Hola"));

        //DELETE
        System.out.println("Eliminado: " + cajoneria.delete(100));

        //REPORTE
        System.out.println(cajoneria);*/
        
        
        
        
        
        //Ejercicio 5
        Cajoneria cajoneria = new Cajoneria(10);

        Caja<Golosina> c1 = new Caja<>("Rojo");
        c1.guardar(new Golosina("Caramelo", 0.2));

        Caja<Golosina> c2 = new Caja<>("Azul");
        c2.guardar(new Golosina("Chocolate", 0.5));

        Caja<Golosina> c3 = new Caja<>("Verde");
        c3.guardar(new Golosina("Galleta", 0.3));

        Caja<Golosina> c4 = new Caja<>("Amarillo");
        c4.guardar(new Golosina("Chicle", 0.1));

        Caja<Golosina> c5 = new Caja<>("Negro");
        c5.guardar(new Golosina("Dulce", 0.4));

        cajoneria.add(c1);
        cajoneria.add(c2);
        cajoneria.add(c3);
        cajoneria.add(c4);
        cajoneria.add(c5);

        System.out.println("--- CONTENIDO ---");
        System.out.println(cajoneria);

        System.out.println("--- BUSQUEDA ---");
        System.out.println(cajoneria.search(new Golosina("Chocolate", 0.5)));
        System.out.println(cajoneria.search(new Golosina("Helado", 1.0)));

        System.out.println("--- ELIMINAR ---");
        Object eliminado = cajoneria.delete(new Golosina("Chicle", 0.1));
        System.out.println("Eliminado: " + eliminado);

        System.out.println("--- DESPUES DE ELIMINAR ---");
        System.out.println(cajoneria);
        
    }
}
