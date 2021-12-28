import netscape.security.UserTarget;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String [] args){
        List<List<Integer>> answer = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(answer);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<List<Integer>>();
        int len = nums.length;
        for(int i=0; i<len-2; i++) {
            int j = i + 1;
            int k = len - 1;
            while ((j < k)) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(sum > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(answer);
    }
}

//    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.



//https://leetcode.com/problems/3sum/
