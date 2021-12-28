package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String [] args){
        List<List<Integer>> answer = fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        System.out.println(answer);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        int len = nums.length;
        for(int i=0; i<len-3; i++){
            for(int j=i+1; j<len-2; j++){
                int left = j+1;
                int right = len-1;
                while(left < right){
                    int tempTarget = nums[i] + nums[j] + nums[left] + nums[right];
                    int sum = target - (nums[i] + nums[j]);
                    int rem = (nums[left] + nums[right]);
                    if(sum == rem){
                        //System.out.println(nums[i] + " " + nums[j] + " " + nums[left] + " " + nums[right]);
                        answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if(sum - rem > 0){
                        left++;
                    } else{
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(answer);
    }
}


//    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//        0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//        nums[a] + nums[b] + nums[c] + nums[d] == target
//        You may return the answer in any order.