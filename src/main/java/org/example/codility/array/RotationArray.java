package org.example.codility.array;

import java.util.Arrays;

public class RotationArray {
    public static void main(String[] args) {
        int[] arr = {7,5,8,3,5};
        int[] rotationArray = getRotationArray(arr,2);
        System.out.println(Arrays.toString(rotationArray));
    }

    private static int[] getRotationArray(int[] arr, int k) {
        int[] result = new int[arr.length];
        for (int i=0; i <arr.length; i++) {
            result[(i + k) % arr.length] = arr[i];
        }
        return result;
    }
}
