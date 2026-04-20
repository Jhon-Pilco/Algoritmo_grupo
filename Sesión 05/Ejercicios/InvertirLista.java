package com.mycompany.sesion_05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InvertirLista {
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("//// Lista de enteros ////");
        System.out.println("Original:  " + numeros);
        System.out.println("Invertida: " + invertirLista(numeros));

        List<String> nombres = Arrays.asList("Ana", "Luis", "Maria", "Carlos");
        System.out.println("\n//// Lista de Strings ////");
        System.out.println("Original:  " + nombres);
        System.out.println("Invertida: " + invertirLista(nombres));

        List<Double> decimales = new LinkedList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4));
        System.out.println("\n//// LinkedList de Double ////");
        System.out.println("Original:  " + decimales);
        System.out.println("Invertida: " + invertirLista(decimales));
    }
}
