package org.example.codility.timecomplexity;

import java.util.Arrays;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,3};
        int x = getSolution(arr);
        System.out.println(x);
    }

    private static int getSolution(int[] arr) {
        int right = Arrays.stream(arr).sum();
        int left = 0;
        int max = Integer.MAX_VALUE;
        for (int i=0; i<arr.length - 1; i++) {
            right -=arr[i];
            left += arr[i];
            if (Math.abs(left - right) < max) {
                max = Math.abs(left - right);
            }
        }
        return max;
    }
}
