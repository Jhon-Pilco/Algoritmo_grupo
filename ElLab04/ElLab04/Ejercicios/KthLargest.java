
package com.mycompany.sesion_04;

import java.util.*;

public class KthLargest {

    public static int kthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int quickSelect(int[] arr, int left, int right, int targetIndex) {
        if (left == right) return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == targetIndex) {
            return arr[pivotIndex];
        } else if (targetIndex < pivotIndex) {

            return quickSelect(arr, left, pivotIndex - 1, targetIndex);
        } else {

            return quickSelect(arr, pivotIndex + 1, right, targetIndex);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right); // coloca el pivote en su posición final
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(kthLargest(new int[]{4, 2, 7, 10, 4, 17}, 3));   // 7
        System.out.println(kthLargest(new int[]{4, 2, 7, 10, 4, 1, 6}, 5)); // 4
        System.out.println(kthLargest(new int[]{4, 2, 7, 1, 4, 6}, 1));     // 7
        System.out.println(kthLargest(new int[]{9, 2, 7, 1, 7}, 4));        // 2
    }
}
