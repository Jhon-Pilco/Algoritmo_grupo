package bstreelinklistinterfgeneric;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import Exceptions.ExceptionIsEmpty;

public class Prueba {

    public static void main(String[] args) {

        LinkedBST<Integer> bst = new LinkedBST<>();

        try {

            bst.insert(400);
            bst.insert(100);
            bst.insert(700);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);

            System.out.println("RECORRIDO INORDER");
            bst.inOrder();

            System.out.println("\n");

            System.out.println("RECORRIDO PREORDER");
            bst.preOrder();

            System.out.println("\n");

            System.out.println("RECORRIDO POSTORDER");
            bst.postOrder();

            System.out.println("\n");

            System.out.println("MINIMO: " + bst.findMin());

            System.out.println("MAXIMO: " + bst.findMax());

        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
    }
}
