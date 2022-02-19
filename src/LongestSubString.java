import javafx.util.Pair;

public class LongestSubString {

    private static  boolean checkPalindrome(String subString){
        int i = 0, j = subString.length()-1;
        while(i<j){
            if(subString.charAt(i) != subString.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static String getLongestSubstring(String input){
        if(input == null || input.length() == 0){
            return null;
        }
        int maxLength = 1;
        String longestSubstring = "";

        for(int i =0 ;i<input.length(); i++){
            for(int j=0; j<=i ;j++){
                String subString  = input.substring(j, i);
                boolean isPalindrome =  checkPalindrome(subString);
                if(isPalindrome == true && subString.length() > maxLength){
                    maxLength = subString.length();
                    longestSubstring = subString;
                }
            }
        }
        return  longestSubstring;
    }

    public static void main(String[] args){
        String ans =  getLongestSubstring("abbbbaaaaaaaaa");
        System.out.println(ans);

    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    int solution(int N, int[] a, int [] b){
        int count[] = new int[N];
        for(int i=0;i<N;i++){
            count[i] = 0;
        }
        Pair[] pairs = new Pair[N];
        for(int i=0;i<N;i++){
            count[a]++;
            count[b]++;
        }
        for(int i=0;i<N;i++){
            pairs[i] = new Pair(a,  count[i]);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
             public int compare(Pair p1, Pair p2)
            {
                return p2.y - p1.y;
            }
        });

        int high = N;
        int[] rank = new int[N];
        for(int i=0;i<N;i++){
            int index = pairs[i].x ;
            rank[index] = high;
            high--;
        }

        int ans  = 0;
        for(int i=0;i<N;i++){
           int ind1 = a[i];
           int ind2 = b[i];
           ans = ans + rank[ind1] + rank[ind2];
        }
        return  ans;
    }
}
