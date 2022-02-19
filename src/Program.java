import java.util.List;

public class Program {

    private static int maxConsecutive(List<Integer> input){
        if(input == null || input.size()==0){
            return 0;
        }
      int ans = 1;
      int goodTillNow = 1;
      for(int i=1; i<input.size();i++){
          int element = input.get(i);
          int lastElement = input.get(i-1);
          if(element == lastElement+1){
              goodTillNow++;
//              ans = Math.max(goodTillNow, ans);
              if(goodTillNow > ans){
                  ans = goodTillNow;
              }
          } else {
              goodTillNow = 1;
          }
      }
      return ans;
    }
    public static void main(String [] args){
       // 4,5,1,2,3,4,7,8,10,6 -> 4
        // 10 11 1 99 2 98 3 97 4 96 ->
        // 1 2 3 4 7 8 9 11 12
        int ans = maxConsecutive(Arrays.asList(4, 5, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 6));
        System.out.println(ans);
         ans = maxConsecutive(Arrays.asList(4));
        System.out.println(ans);
        ans = maxConsecutive(null);
        System.out.println(ans);
        ans = maxConsecutive(null);

        System.out.println(ans);
    }
}

class Node{
    int data;
    List<Node> childList;
}

        private int maxConsecutiveInTree (TreeNode node){
            //checking null
            if(node == null){
                return 0
            }
            //leaf node
            if(node.childList.size() == 0)
      }
              5
              6     7
              7     9 8
              8  9 1  4  5


              5
              6     7
              90 7      9 8
              8  9 1  4  5