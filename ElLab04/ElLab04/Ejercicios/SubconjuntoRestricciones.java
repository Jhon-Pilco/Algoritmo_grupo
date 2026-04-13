package com.mycompany.sesion_04;

import java.util.*;

public class SubconjuntoRestricciones {

    public static boolean solve(int[] arr, int target) {
        int n = arr.length;
        
        boolean[] canChoose = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                if (i + 1 < n && arr[i + 1] % 2 == 0) {
                    canChoose[i] = false;
                } else {
                    canChoose[i] = true;
                }
            } else {
                canChoose[i] = true;
            }
        }
        int mandatorySum = 0;
        List<Integer> optional = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0) {
                if (!canChoose[i]) {
                    return false;
                }
                mandatorySum += arr[i];
            } else {
                if (canChoose[i]) {
                    optional.add(arr[i]);
                }
            }
        }
        if (mandatorySum > target) return false;

        int remaining = target - mandatorySum;
        return subsetSum(optional, remaining);
    }

    private static boolean subsetSum(List<Integer> nums, int remaining) {
        if (remaining == 0) return true;
        if (remaining < 0 || nums.isEmpty()) return false;

        return subsetSumHelper(nums, remaining, 0);
    }

    private static boolean subsetSumHelper(List<Integer> nums, int remaining, int index) {
        if (remaining == 0) return true;
        if (index >= nums.size()) return false;

        if (subsetSumHelper(nums, remaining - nums.get(index), index + 1)) {
            return true;
        }

        return subsetSumHelper(nums, remaining, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();

        System.out.println(solve(arr, target));
    }
}