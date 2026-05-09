package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;
import Exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    class Node {

        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // =================================================
    // INSERTAR PRODUCTOS
    // =================================================

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, E data) throws ItemDuplicated {

        if (node == null) {
            return new Node(data);
        }

        if (data.compareTo(node.data) < 0) {

            node.left = insertRec(node.left, data);

        } else if (data.compareTo(node.data) > 0) {

            node.right = insertRec(node.right, data);

        } else {

            throw new ItemDuplicated("Elemento duplicado");
        }

        return node;
    }

    // =================================================
    // BUSCAR PRODUCTO
    // =================================================

    @Override
    public E search(E data) throws ItemNotFound {

        Node result = searchRec(root, data);

        if (result == null) {
            throw new ItemNotFound("Elemento no encontrado");
        }

        return result.data;
    }

    private Node searchRec(Node node, E data) {

        if (node == null || data.compareTo(node.data) == 0) {
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            return searchRec(node.left, data);
        }

        return searchRec(node.right, data);
    }

    // =================================================
    // ELIMINAR PRODUCTO
    // =================================================

    @Override
    public void delete(E data) throws ExceptionIsEmpty {

        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }

        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, E data) {

        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {

            node.left = deleteRec(node.left, data);

        } else if (data.compareTo(node.data) > 0) {

            node.right = deleteRec(node.right, data);

        } else {

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            node.data = findMinNode(node.right);

            node.right = deleteRec(node.right, node.data);
        }

        return node;
    }

    // =================================================
    // MÍNIMO Y MÁXIMO
    // =================================================

    private E findMinNode(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }

    private E findMaxNode(Node node) {

        while (node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    public E findMin() {
        return findMinNode(root);
    }

    public E findMax() {
        return findMaxNode(root);
    }

    // =================================================
    // RECORRIDO INORDER
    // =================================================

    private void inOrder(Node node) {

        if (node != null) {

            inOrder(node.left);

            System.out.print(node.data + " ");

            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    // =================================================
    // RECORRIDO PREORDER
    // =================================================

    private void preOrder(Node node) {

        if (node != null) {

            System.out.print(node.data + " ");

            preOrder(node.left);

            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    // =================================================
    // RECORRIDO POSTORDER
    // =================================================

    private void postOrder(Node node) {

        if (node != null) {

            postOrder(node.left);

            postOrder(node.right);

            System.out.print(node.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    // =================================================
    // BUSCAR PRODUCTOS POR RANGO
    // =================================================

    @Override
    public void searchRange(E min, E max) {

        System.out.println("Productos dentro del rango:");

        searchRangeRec(root, min, max);

        System.out.println();
    }

    private void searchRangeRec(Node node, E min, E max) {

        if (node == null) {
            return;
        }

        if (node.data.compareTo(min) > 0) {
            searchRangeRec(node.left, min, max);
        }

        if (node.data.compareTo(min) >= 0
                && node.data.compareTo(max) <= 0) {

            System.out.print(node.data + " ");
        }

        if (node.data.compareTo(max) < 0) {
            searchRangeRec(node.right, min, max);
        }
    }

    // =================================================
    // CONTAR NODOS HOJA
    // =================================================

    @Override
    public int countLeaves() {

        return countLeavesRec(root);
    }

    private int countLeavesRec(Node node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeavesRec(node.left)
                + countLeavesRec(node.right);
    }

    // =================================================
    // MOSTRAR DESCENDENTE
    // =================================================

    @Override
    public void printDescending() {

        System.out.println("Productos en orden descendente:");

        printDescendingRec(root);

        System.out.println();
    }

    private void printDescendingRec(Node node) {

        if (node != null) {

            printDescendingRec(node.right);

            System.out.print(node.data + " ");

            printDescendingRec(node.left);
        }
    }

    // =================================================
    // MÉTODOS EXTRA
    // =================================================

    @Override
    public void destroyNodes() throws ExceptionIsEmpty {

        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }

        root = null;
    }

    @Override
    public int countAllNodes() {
        return 0;
    }

    @Override
    public int countNodes() {
        return 0;
    }

    @Override
    public int height(E x) {
        return 0;
    }

    @Override
    public int areaBST() {
        return 0;
    }

    @Override
    public void drawBST() {

        drawBSTRec(root, "", true);
    }

    private void drawBSTRec(Node node, String space, boolean isRight) {

        if (node == null) {
            return;
        }

        System.out.println(space
                + (isRight ? "└── " : "├── ")
                + node.data);

        drawBSTRec(node.left,
                space + (isRight ? "    " : "│   "),
                false);

        drawBSTRec(node.right,
                space + (isRight ? "    " : "│   "),
                true);
    }

    @Override
    public void parenthesize() {
    }

    @Override
    public boolean isValidBST() {
        return true;
    }

    @Override
    public String toString() {
        return "BST de inventario creado";
    }
}