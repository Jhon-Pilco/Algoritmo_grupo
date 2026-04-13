import java.util.*;
public class MergeSort {
    public static void mergeSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;

            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);

            merge(arr, izq, mid, der);
        }
    }
    public static void merge(int[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {

        int[] arr1 = {8, 3, 5, 2, 9}; // 5 elementos
        int[] arr2 = {7, 1, 6, 3, 9, 2, 8, 4}; // 8 elementos
        int[] arr3 = {10, 4, 7, 2, 9, 1, 6, 3, 8, 5}; // 10 elementos

        System.out.println("Antes (5): " + Arrays.toString(arr1));
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println("Después (5): " + Arrays.toString(arr1));

        System.out.println("\nAntes (8): " + Arrays.toString(arr2));
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("Después (8): " + Arrays.toString(arr2));
        System.out.println("\nAntes (10): " + Arrays.toString(arr3));
        mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("Después (10): " + Arrays.toString(arr3));
    }
}