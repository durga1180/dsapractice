package org.example.codility.office;

import java.util.Arrays;

/**
 * You are given a string letters made of N english letter. Count the number of different letters that appear
 * in both uppercase and lowercase where all lowercase occurrence of the given letter appear before
 * any upper occurrences. For example for the letter "aaAbcCAB" B,c the answer 2. The condition is met for the
 * letter a and b but not for c. Write a java program that the given string letter return the array of different
 * letter fulfilling the condition above.
 */
public class UpperLowerLetters {
    public static void main(String[] args) {
        String l1 = "aaAbcCABBc";
        String l2 = "xyzXYZabcABC";
        String l3 = "ABCabcAefG";
        int c1 = countValidLetter(l1);
        int c2 = countValidLetter(l2);
        int c3 = countValidLetter(l3);
        System.out.println(c1+"::"+c2+"::"+c3);
    }

    private static int countValidLetter(String l1) {
        int n = l1.length();
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);
        for (int i =0; i <n; i++) {
            char c = l1.charAt(i);
            if(Character.isLowerCase(c)) {
                int index = c - 'a';
                lastLower[index] = i;
            } else if (Character.isUpperCase(c)) {
                int index = c - 'A';
                if (firstUpper[index] == -1) {
                    firstUpper[index] = i;
                }
            }
        }
        //System.out.println(Arrays.toString(lastLower));
        //System.out.println(Arrays.toString(firstUpper));
        int[] splitLen = {2,4,5,6};
        String str = "DurgaPrasadSurada17051980";
        String[] strings = new String[splitLen.length];
        int starIndex = 0;
        int lastIndex = 0;
        for (int i=0; i < splitLen.length; i++) {
                lastIndex = splitLen[i];
                String s = str.substring(starIndex,lastIndex);
                strings[i] = s;
                starIndex = lastIndex;
        }
        System.out.println(Arrays.toString(strings));
        int count = 0;
        for (int i=0; i<26; i++) {
            if (lastLower[i]!= -1 && firstUpper[i]!= -1) {
                if (lastLower[i] < firstUpper[i]) {
                    count ++;
                }
            }
        }
        return count;
    }
}
