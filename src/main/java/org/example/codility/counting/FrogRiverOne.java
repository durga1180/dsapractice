package org.example.codility.counting;

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] arr = {1,3,1,4,2,3,5,4};
        int k = 5;
        int res = getFrogRiverOne(arr,k);
        System.out.println(res);
    }

    private static int getFrogRiverOne(int[] arr, int k) {
        boolean[] res = new boolean[k+1];
        for (int i=0; i<arr.length; i++) {
            int r = arr[i];
            if(!res[r]) {
                res[r] = true;
                k --;
                if(k==0)
                    return i;
            }
        }
        return -1;
    }
}
