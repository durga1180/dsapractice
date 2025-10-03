package org.example.codility.counting;

import java.util.Arrays;

public class MaxCounter {
    public static void main(String[] args) {
        int fill = 5;
        int[] arr = {3,4,4,6,1,4,4};
        int[] res = getMaxCounterOptimal(fill,arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] getMaxCounter(int fill, int[] arr) {
        int[] res = new int[fill];
        Arrays.fill(res, 0);
        for (int i=0; i<arr.length; i++) {
            int pos = arr[i];
            if (pos > fill) {
                int max = Arrays.stream(res).max().getAsInt();
                Arrays.fill(res, max);
                //System.out.println(Arrays.toString(res));
            } else {
                res[pos - 1] = res[pos - 1] + 1;
            }
            //System.out.println(Arrays.toString(res));
        }
        return res;
    }

    private static int[] getMaxCounterOptimal(int fill, int[] arr) {
        int[] res = new int[fill];
        Arrays.fill(res, 0);
        int start_line = 0;
        int current_max = 0;
        for (int i : arr) {
            int x = i-1;
            if (i > fill) {
                start_line = current_max;
            }
            else if (res[x] < start_line) {
                res[x] = start_line + 1;
            }
            else {
                res[x] += 1;
            }
            if (i <= fill && res[x] > current_max)
            {
                current_max = res[x];
            }
            //System.out.println(start_line+":::"+current_max+">>>"+Arrays.toString(res));
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] < start_line) {
                res[i] = start_line;
            }
        }

        return res;
    }
}
