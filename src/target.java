import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;
public class target {
    public static void main(String [] args){
       int[] ans = twoSum(new int[]{3,17,8,9,2,2}, 4);
       System.out.println(ans[0] + " " +  ans[1]);
    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        int ind = 0;
        for(int firstElement : nums){
            if (hmap.containsKey(target - firstElement)) {
                answer[1] = ind;
                answer[0] = hmap.get(target - firstElement);
                //System.out.println(answer[0] + " " +  answer[1]);
                break;
            }
            hmap.put(firstElement, ind);
            ind++;
        }
        return answer;
    }

}
