package Actividad_1.Sesion02;

import static Actividad_1.Sesion02.DemoMetodoGenerico.igualArrays;


public class Principal {
    public static void main(String[] args) {

        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);

        Chocolatina c = new Chocolatina("Milka");
        Chocolatina c1 = new Chocolatina("Sublime");
        Chocolatina c2 = new Chocolatina("Ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }
        
        Bolsa<Golosina> goloGol=new Bolsa<>(1);
        Golosina g = new Golosina("Kriss", 1);
        
        goloGol.add(g);
        
        for (Golosina golosina : goloGol) {
            System.out.println(golosina.getNombre());
        }
        
        
        //Demo metodo generico.java
        Integer nums[]={1,2,3,4,5};
        Integer nums2[]={1,2,3,4,5};
        Integer nums3[]={1,2,7,4,5};
        Integer nums4[]={1,2,7,4,5,6};
        if (igualArrays(nums,nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums,nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums,nums3))
            System.out.println("nums es igual a num3");
        if (igualArrays(nums,nums4))
            System.out.println("nums es igual a nums4");
        // Crea un array de double
        Double dvals[]={1.1,2.2,3.3,4.4,5.5};
        
        if (igualArrays(nums,dvals))
            System.out.println("nums es igual a dvals");
        
    }
}
