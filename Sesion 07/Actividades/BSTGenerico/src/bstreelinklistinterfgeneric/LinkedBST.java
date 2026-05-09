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

    @Override
    public void delete(E data) throws ExceptionIsEmpty {

        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío");
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

    @Override
    public String toString() {
        return "BST creado correctamente";
    }
}
