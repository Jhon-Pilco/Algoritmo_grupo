package com.mycompany.sesion_04;

import java.util.Scanner;

public class RioMasBarato {

    static final int INF = Integer.MAX_VALUE / 2;

    static int[][] calcularCostos(int[][] T, int n) {
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)      C[i][j] = 0;
                else if (i < j)  C[i][j] = T[i][j];
                else             C[i][j] = INF;
            }
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                int mejor = T[i][j];

                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != INF && C[k][j] != INF) {
                        int costoVia = T[i][k] + C[k][j];
                        if (costoVia < mejor) {
                            mejor = costoVia;
                        }
                    }
                }
                C[i][j] = mejor;
            }
        }

        return C;
    }

    static String reconstruirRuta(int[][] T, int[][] C, int i, int j) {
        if (i == j) return "E" + (i + 1);
        if (j == i + 1) return "E" + (i + 1) + " -> E" + (j + 1);

        int mejorK = -1;
        int mejorCosto = T[i][j];

        for (int k = i + 1; k < j; k++) {
            if (T[i][k] + C[k][j] < mejorCosto) {
                mejorCosto = T[i][k] + C[k][j];
                mejorK = k;
            }
        }

        if (mejorK == -1) {
            return "E" + (i + 1) + " -> E" + (j + 1);
        }

        return reconstruirRuta(T, C, i, mejorK)
             + reconstruirRuta(T, C, mejorK, j).substring(("E" + (mejorK + 1)).length());
    }

    static void imprimirMatriz(int[][] M, int n, String nombre) {
        System.out.println("\nMatriz " + nombre + ":");
        System.out.print("     ");
        for (int j = 0; j < n; j++) System.out.printf("E%-4d", j + 1);
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("E%-4d", i + 1);
            for (int j = 0; j < n; j++) {
                if (i > j)        System.out.printf("%-5s", "-");
                else if (i == j)  System.out.printf("%-5d", 0);
                else if (M[i][j] == INF) System.out.printf("%-5s", "INF");
                else              System.out.printf("%-5d", M[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero de embarcaderos: ");
        int n = sc.nextInt();

        int[][] T = new int[n][n];

        System.out.println("Ingrese la tabla de tarifas (0 si no hay ruta directa):");
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.printf("T[%d][%d]: ", i + 1, j + 1);
                int v = sc.nextInt();
                T[i][j] = (v == 0) ? INF : v;
            }
        }

        int[][] C = calcularCostos(T, n);

        imprimirMatriz(T, n, "T (tarifas directas)");
        imprimirMatriz(C, n, "C (costos minimos)");

        System.out.print("\nOrigen (1 a " + n + "): ");
        int org = sc.nextInt() - 1;
        System.out.print("Destino (1 a " + n + "): ");
        int dst = sc.nextInt() - 1;

        if (org >= dst) {
            System.out.println("El origen debe ser menor que el destino.");
        } else if (C[org][dst] == INF) {
            System.out.println("No hay ruta disponible.");
        } else {
            System.out.println("\nCosto minimo E" + (org+1) + " -> E" + (dst+1) + ": " + C[org][dst]);
            System.out.println("Ruta: " + reconstruirRuta(T, C, org, dst));
        }
    }
}