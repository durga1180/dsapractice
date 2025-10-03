package org.example.codility.office;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array A of N integer representing the maximum heights of N skyscrapers to be built.
 * Your task to specify the actual height of the skyscrapers given that the height of the K skyscrapers
 * should be positive and not bigger than of K. Note two skyscrapers should be same height.
 * The total sum of skyscrapers heights should be the maximum possible.
 * Write a programme that given an array A of N integer , written an array B of N integer , where B of k is the
 * assigned height of the kth skyscraper, satisfying the above condition. if there are server several possible
 * answers, the function may return any of them. you may assume that it is always possible to build all
 * skyscrapers while fulfilling all the requirements.
 * Example:
 * 1. A = {1,2,3} , O/P = {1,2,3}
 * 2. A = {9,4,3,7,7} , O/P = {9,4,3,7,6} or {9,4,3,6,7}
 * 3. A = {2,5,4,5,5} , O/P = {1,2,3,4,5}
 * To solve the problem,we need to assign unique heights to each skyscraper such that
 * 1. The height of the kth skyscraper is greater than zero and less or equal ti A[k]
 * 2. No two skyscrapers can have the same height
 * 3. The total sum of heights is maximized, meaning we want to assign heights as close as
 * possible to their respective maximum values in array A.
 * Approach:
 * 1. Sort the skyscrapers by their maximum allowed height.
 * 2. Assign unique heights ->
 * 3. Greedily assign heights*
 * Steps:
 * 1. Pair each skyscraper's maximum height(A[k]) with its index.
 * 2. Sort the skyscrapers based on their maximum heights.
 * 3. Assign unique heights starting from the smallest possible value(1) up to
 * the maximum allowed height,ensuring that no two skyscrapers get the same height.
 */
public class SkyscraperHeights {
    public static void main(String[] args) {
        int[] A1 = {1,2,3};
        int[] A2 = {9,4,3,7,7};
        int[] A3 = {2,5,4,5,5};
        int[] res1 = assignHeights(A1);
        System.out.println(Arrays.toString(res1));
        int[] res2 = assignHeights(A2);
        System.out.println(Arrays.toString(res2));
        int[] res3 = assignHeights(A3);
        System.out.println(Arrays.toString(res3));
    }

    private static int[] assignHeights(int[] a) {
        int n = a.length;
        // Create an array to hold pairs of (index, max height)
        int[][] skyscrapers = new int[n][2];
        for (int i=0; i<n; i++) {
            //Original heights
            skyscrapers[i][0] = i;
            //Max height
            skyscrapers[i][1] = a[i];
        }
        // Sort skyscrapers by their maximum height (ascending order)
        Arrays.sort(skyscrapers, Comparator.comparingInt(s -> s[1]));
        int[] res = new int[n];
        // Set to keep track of assigned heights
        Set<Integer> assignedHeights = new HashSet<>();
        for (int i=n-1; i>= 0; i--) {
            int max = skyscrapers[i][1];
            System.out.print(max+" ");
            while (assignedHeights.contains(max) && max > 0) {
                max --;
            }
            if (max > 0) {
                res[skyscrapers[i][0]] = max;
                assignedHeights.add(max);
            }
        }
        return res;
    }
}
