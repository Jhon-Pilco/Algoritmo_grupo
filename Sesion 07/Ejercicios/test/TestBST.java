package test;

import bstreelinklistinterfgeneric.LinkedBST;

public class TestBST {

    public static void main(String[] args) {

        LinkedBST<Integer> inventario = new LinkedBST<>();

        try {

            // =====================================
            // INSERTAR PRODUCTOS
            // =====================================

            inventario.insert(50);
            inventario.insert(30);
            inventario.insert(70);
            inventario.insert(20);
            inventario.insert(40);
            inventario.insert(60);
            inventario.insert(80);

            // =====================================
            // MOSTRAR BST
            // =====================================

            System.out.println("=================================");
            System.out.println("   INVENTARIO DE PRODUCTOS BST");
            System.out.println("=================================");

            inventario.drawBST();

            // =====================================
            // RECORRIDOS
            // =====================================

            System.out.println("\n=================================");
            System.out.println("          RECORRIDOS");
            System.out.println("=================================");

            System.out.print("InOrder   : ");
            inventario.inOrder();

            System.out.print("\nPreOrder  : ");
            inventario.preOrder();

            System.out.print("\nPostOrder : ");
            inventario.postOrder();

            // =====================================
            // BÚSQUEDA POR RANGO
            // =====================================

            System.out.println("\n\n=================================");
            System.out.println("       BÚSQUEDA POR RANGO");
            System.out.println("=================================");

            inventario.searchRange(30, 70);

            // =====================================
            // CONTAR HOJAS
            // =====================================

            System.out.println("\n=================================");
            System.out.println("       PRODUCTOS HOJA");
            System.out.println("=================================");

            System.out.println("Cantidad de hojas: "
                    + inventario.countLeaves());

            // =====================================
            // ORDEN DESCENDENTE
            // =====================================

            System.out.println("\n=================================");
            System.out.println("    PRODUCTOS DESCENDENTES");
            System.out.println("=================================");

            inventario.printDescending();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}