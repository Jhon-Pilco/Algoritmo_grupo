package com.mycompany.sesion_04;

import java.util.Scanner;

public class Laberinto {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean resolver(int[][] lab, int[][] sol, int fila, int col, int n, int m) {
        if (fila == n - 1 && col == m - 1) {
            sol[fila][col] = 1;
            return true;
        }

        for (int d = 0; d < 4; d++) {
            int nf = fila + dr[d];
            int nc = col  + dc[d];

            if (esValido(lab, sol, nf, nc, n, m)) {
                sol[nf][nc] = 1;

                if (resolver(lab, sol, nf, nc, n, m)) {
                    return true;
                }

                sol[nf][nc] = 0;
            }
        }

        return false;
    }

    static boolean esValido(int[][] lab, int[][] sol, int fila, int col, int n, int m) {
        return fila >= 0 && fila < n
            && col  >= 0 && col  < m
            && lab[fila][col] == 0  
            && sol[fila][col] == 0; 
    }

    static void imprimirMatriz(int[][] M, int n, int m, String titulo) {
        System.out.println(titulo);
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < m; j++) {
                System.out.print(M[i][j]);
                if (j < m - 1) System.out.print(", ");
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

    static void imprimirCamino(int[][] sol, int n, int m) {
        System.out.println("Camino encontrado (* = paso del camino):");
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < m; j++) {
                System.out.print(sol[i][j] == 1 ? "*" : ".");
                if (j < m - 1) System.out.print(", ");
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

    static void imprimirPasos(int[][] sol, int n, int m) {
        System.out.print("Pasos: ");
        boolean primero = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sol[i][j] == 1) {
                    if (!primero) System.out.print(" -> ");
                    System.out.print("(" + i + "," + j + ")");
                    primero = false;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Filas del laberinto: ");
        int n = sc.nextInt();
        System.out.print("Columnas del laberinto: ");
        int m = sc.nextInt();

        int[][] lab = new int[n][m];
        int[][] sol = new int[n][m];

        System.out.println("Ingrese el laberinto fila por fila (0=libre, 1=pared):");
        for (int i = 0; i < n; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        if (lab[0][0] == 1 || lab[n-1][m-1] == 1) {
            System.out.println("\nSalida: false");
            System.out.println("Razon: el punto de inicio o destino es una pared.");
            return;
        }

        imprimirMatriz(lab, n, m, "\nLaberinto ingresado:");

        sol[0][0] = 1;
        boolean encontrado = resolver(lab, sol, 0, 0, n, m);

        System.out.println("Salida: " + encontrado);
        System.out.println();

        if (encontrado) {
            imprimirCamino(sol, n, m);
            imprimirPasos(sol, n, m);
        } else {
            System.out.println("No hay camino desde (0,0) hasta (" + (n-1) + "," + (m-1) + ").");
        }
    }
}