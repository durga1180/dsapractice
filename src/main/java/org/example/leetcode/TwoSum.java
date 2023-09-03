package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum sum = new TwoSum();
        int[] res = sum.twoSum(nums,target);
        System.out.println(Arrays.toString(res));
        int[] resOptimumSol = sum.twoSumOptimization(nums,target);
        System.out.println(Arrays.toString(resOptimumSol));

    }

    //TC: O(n)
    private int[] twoSumOptimization(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int y = target - nums[i];
            if(map.containsKey(y)) {
                return new int[]{map.get(y), i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    //TC - O(n^2)
    public int[]  twoSum(int[] nums, int target) {
        int[] res =new int[2];
        for(int i=0; i < nums.length; i++) {
            int n = nums[i];
            for(int j=i+1; j < nums.length; j++) {
                int m = nums[j];
                if(n+m == target) {
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}
