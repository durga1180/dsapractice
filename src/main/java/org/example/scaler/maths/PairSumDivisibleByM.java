package org.example.scaler.maths;


import java.util.Arrays;

public class PairSumDivisibleByM {
    public static void main(String[] args) {
        int[] A = { 2, 2, 1, 7, 5, 3 };
        int n = A.length;
        int K = 4;
        int sum = getPairSum(A,n,K);
        System.out.println("Result::"+sum);
    }

    private static int getPairSum(int[] a, int n, int K) {
        int[] freq = new int[K];

        for (int i=0; i<n; i++)
            ++freq[a[i]%K];
        
        System.out.println(Arrays.toString(freq));
        int sum = (freq[0] * (freq[0]-1))/2;
        System.out.println(sum);
        for (int i = 1; i <= K / 2 && i != (K - i); i++)
            sum += freq[i] * freq[K - i];
        // If K is even
        if (K % 2 == 0)
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
        return sum;
    }

}
