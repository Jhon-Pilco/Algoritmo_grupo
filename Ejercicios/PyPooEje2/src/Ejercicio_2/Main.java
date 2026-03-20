package Ejercicio_2;

import java.io.*;
import java.util.*;

public class Main {

    public static Zona[][] leerArchivo(String nombreArchivo) throws Exception {
        Scanner sc = new Scanner(new File(nombreArchivo));

        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        Zona[][] matriz = new Zona[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String mineral = sc.next();
                int cantidad = sc.nextInt();
                double pureza = sc.nextDouble();

                matriz[i][j] = new Zona(mineral, cantidad, pureza);
            }
        }

        sc.close();
        return matriz;
    }
    public static void analizar(Zona[][] matriz, int k) {

        int filas = matriz.length;
        int columnas = matriz[0].length;

        double maxValor = 0;
        int mejorFila = 0;
        int mejorColumna = 0;

        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= columnas - k; j++) {

                double suma = 0;

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        suma += matriz[x][y].calcularValor();
                    }
                }

                if (suma > maxValor) {
                    maxValor = suma;
                    mejorFila = i;
                    mejorColumna = j;
                }
            }
        }

        mostrarResultado(matriz, mejorFila, mejorColumna, k, maxValor);
    }
    
    public static void mostrarResultado(Zona[][] matriz, int fila, int col, int k, double total) {

        System.out.println("Region mas valiosa encontrada:\n");
        System.out.println("Posicion inicial: (" + fila + "," + col + ")");
        System.out.println("Tamano de la region: " + k + " x " + k);

        System.out.println("\nZonas analizadas:");

        Map<String, Integer> contador = new HashMap<>();

        for (int i = fila; i < fila + k; i++) {
            for (int j = col; j < col + k; j++) {

                Zona z = matriz[i][j];
                System.out.println(z);

                contador.put(z.mineral, contador.getOrDefault(z.mineral, 0) + 1);
            }
        }

        System.out.println("\nValor total estimado: " + total);

        String dominante = "";
        int max = 0;

        for (String mineral : contador.keySet()) {
            if (contador.get(mineral) > max) {
                max = contador.get(mineral);
                dominante = mineral;
            }
        }

        System.out.println("Mineral predominante en la region: " + dominante);
    }
    
    public static void main(String[] args) {
        try {
            Zona[][] matriz = leerArchivo("datos.txt");

            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el tamano k: ");
            int k = sc.nextInt();

            analizar(matriz, k);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}