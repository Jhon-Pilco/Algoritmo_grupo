package bstreeInterface;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNotFound;

public interface BinarySearchTree<E> {

    boolean isEmpty();

    void insert(E data) throws ItemDuplicated;

    E search(E data) throws ItemNotFound;

    void delete(E data) throws ExceptionIsEmpty;

    void destroyNodes() throws ExceptionIsEmpty;

    int countAllNodes();

    int countNodes();

    int height(E x);

    int areaBST();

    void drawBST();

    void parenthesize();

    boolean isValidBST();

    void searchRange(E min, E max);

    int countLeaves();

    void printDescending();
}