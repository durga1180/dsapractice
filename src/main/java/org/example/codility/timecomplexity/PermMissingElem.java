package org.example.codility.timecomplexity;


import java.util.Arrays;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5,7};
        int missingElement = getMissingEl(arr);
        System.out.println(missingElement);
    }

    private static int getMissingEl(int[] arr) {
        long actualSum = Arrays.stream(arr).sum();
        long maxNumber = arr.length + 1;
        long expectedSum = (maxNumber * (maxNumber + 1) / 2);
        return (int) (expectedSum - actualSum);
    }
}
