package com.mycompany.sesion_05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListaGenerica {
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento == null) {
                if (valor == null) return true;
            } else {
                if (elemento.equals(valor)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 25, 37, 42, 58);
        System.out.println("///// Lista de enteros /////");
        System.out.println("Lista: " + numeros);
        System.out.println("Contiene 37? " + buscarElemento(numeros, 37));  
        System.out.println("Contiene 99? " + buscarElemento(numeros, 99));   

        List<String> nombres = Arrays.asList("Ana", "Luis", "Maria", "Carlos");
        System.out.println("\n=== Lista de Strings ===");
        System.out.println("Lista: " + nombres);
        System.out.println("Contiene 'Maria'? " + buscarElemento(nombres, "Maria")); 
        System.out.println("Contiene 'Pedro'? " + buscarElemento(nombres, "Pedro")); 

        List<Double> decimales = new LinkedList<>(Arrays.asList(1.5, 3.14, 2.71, 0.99));
        System.out.println("\n=== LinkedList de Double ===");
        System.out.println("Lista: " + decimales);
        System.out.println("Contiene 3.14? " + buscarElemento(decimales, 3.14)); 
        System.out.println("Contiene 5.00? " + buscarElemento(decimales, 5.00)); 
    }
}
