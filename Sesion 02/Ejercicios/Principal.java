package Actividad_1.Sesion02;

import static Actividad_1.Sesion02.DemoMetodoGenerico.igualArrays;


public class Principal {
    public static void main(String[] args) {

       // --- Bolsa ---
        /*Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);

        bolsaCho.add(new Chocolatina("Milka"));
        bolsaCho.add(new Chocolatina("Sublime"));
        bolsaCho.add(new Chocolatina("Ferrero"));

        for (Chocolatina c : bolsaCho) {
            System.out.println(c.getMarca());
        }

        System.out.println("-----");

        Bolsa<Golosina> goloGol = new Bolsa<>(1);
        goloGol.add(new Golosina("Kriss", 1));

        for (Golosina g : goloGol) {
            System.out.println(g.getNombre());
        }

        System.out.println("----- PRUEBA EXIST -----");

        // --- Chocolatina ---
        Chocolatina[] chocos = {
            new Chocolatina("Milka"),
            new Chocolatina("Sublime")
        };

        System.out.println(DemoMetodoGenerico.exist(chocos, new Chocolatina("Milka"))); // true

        // --- Golosina ---
        Golosina[] golos = {
            new Golosina("Kriss", 1),
            new Golosina("Gomitas", 0.5)
        };

        System.out.println(DemoMetodoGenerico.exist(golos, new Golosina("Kriss", 1))); // true*/
    
        
        
        
        
        
    /*ejercicio 2 Solución al problema
    Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
        bolsaCho.add(new Chocolatina("Milka"));
        bolsaCho.add(new Chocolatina("Sublime"));
        bolsaCho.add(new Chocolatina("Ferrero"));

        Bolsa<Golosina> bolsaGol = new Bolsa<>(2);
        bolsaGol.add(new Golosina("Kriss", 1));
        bolsaGol.add(new Golosina("Gomitas", 0.5));

        System.out.println("Chocolatinas:");
        mostrarBolsa(bolsaCho);

        System.out.println("-----");

        System.out.println("Golosinas:");
        mostrarBolsa(bolsaGol);
    }
    public static <T> void mostrarBolsa(Bolsa<T> bolsa) {
        for (T elemento : bolsa) {
            System.out.println(elemento);
        }*/
    
    
    
    
    
    /*Cajoneria cajoneria = new Cajoneria(10);

        // --- Golosinas ---
        Caja<Golosina> c1 = new Caja<>("Rojo");
        c1.guardar(new Golosina("Chocolate", 0.5));

        Caja<Golosina> c2 = new Caja<>("Azul");
        c2.guardar(new Golosina("Chocolate", 0.5));

        Caja<Golosina> c3 = new Caja<>("Verde");
        c3.guardar(new Golosina("Caramelo", 0.2));

        cajoneria.add(c1);
        cajoneria.add(c2);
        cajoneria.add(c3);

        System.out.println("=== CONTAR GOLOSINAS ===");
        System.out.println("Chocolate: " +
            cajoneria.contar(new Golosina("Chocolate", 0.5)));

        System.out.println("Caramelo: " +
            cajoneria.contar(new Golosina("Caramelo", 0.2)));

        // --- Chocolatinas ---
        Cajoneria cajoneria2 = new Cajoneria(5);

        Caja<Chocolatina> ch1 = new Caja<>("Rojo");
        ch1.guardar(new Chocolatina("Milka"));

        Caja<Chocolatina> ch2 = new Caja<>("Azul");
        ch2.guardar(new Chocolatina("Milka"));

        cajoneria2.add(ch1);
        cajoneria2.add(ch2);

        System.out.println("=== CONTAR CHOCOLATINAS ===");
        System.out.println("Milka: " +
            cajoneria2.contar(new Chocolatina("Milka")));*/
        
        Cajoneria cajoneria = new Cajoneria(5);

        // Crear cajas con chocolatinas
        Caja<Chocolatina> c1 = new Caja<>("Rojo");
        c1.guardar(new Chocolatina("Milka"));

        Caja<Chocolatina> c2 = new Caja<>("Azul");
        c2.guardar(new Chocolatina("Milka"));

        Caja<Chocolatina> c3 = new Caja<>("Verde");
        c3.guardar(new Chocolatina("Sublime"));

        Caja<Chocolatina> c4 = new Caja<>("Amarillo");
        c4.guardar(new Chocolatina("Ferrero"));

        // Agregar a la cajonería
        cajoneria.add(c1);
        cajoneria.add(c2);
        cajoneria.add(c3);
        cajoneria.add(c4);

        System.out.println("=== CONTENIDO CHOCOLATINAS ===");
        System.out.println(cajoneria);

        //SEARCH
        System.out.println("=== BUSQUEDA ===");
        System.out.println(cajoneria.search(new Chocolatina("Milka")));

        //CONTAR
        System.out.println("=== CONTAR ===");
        System.out.println("Milka: " +
            cajoneria.contar(new Chocolatina("Milka")));

        //DELETE
        System.out.println("=== ELIMINAR ===");
        Object eliminado = cajoneria.delete(new Chocolatina("Sublime"));
        System.out.println("Eliminado: " + eliminado);

        //Mostrar después
        System.out.println("=== DESPUES DE ELIMINAR ===");
        System.out.println(cajoneria);
    }
        
    
        //Demo metodo generico.java
        //Integer nums[]={1,2,3,4,5};
        //Integer nums2[]={1,2,3,4,5};
        //Integer nums3[]={1,2,7,4,5};
        //Integer nums4[]={1,2,7,4,5,6};
        //if (igualArrays(nums,nums))
          //  System.out.println("nums es igual a nums");
        //if (igualArrays(nums,nums2))
          //  System.out.println("nums es igual a nums2");
        //if (igualArrays(nums,nums3))
          //  System.out.println("nums es igual a num3");
        //if (igualArrays(nums,nums4))
          //  System.out.println("nums es igual a nums4");
        // Crea un array de double
        //Double dvals[]={1.1,2.2,3.3,4.4,5.5};
        
        //if (igualArrays(nums,dvals))
          //  System.out.println("nums es igual a dvals");
        
    
    
    
}
    