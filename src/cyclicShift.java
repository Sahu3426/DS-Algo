import java.util.HashMap;
import java.util.Map;


class Main {
    public static int  solve(int[] arr){
        Map<String, Boolean> hmap = new HashMap<>();
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            int ele = arr[i];
            String strEle = String.valueOf(ele);
            // System.out.println(strEle);
            int len = strEle.length();
            if (len >= 2) {
                for (int j = 0; j < strEle.length()-1; j++) {
                    String temp = strEle.substring(len - j - 1, len );
                    String temp2 = strEle.substring(0, len - j - 1);
                    String finalStr = temp + temp2;
                    // System.out.println(temp);
                    // System.out.println(temp2);
                    // System.out.println(finalStr);
                    if (hmap.containsKey(finalStr)) {
                        System.out.println(finalStr + " dadada " + strEle);
                        ans++;
                    }
                }
            } else {
                if (hmap.contains(strEle)) {
                    System.out.println(strEle + "hcdijcd");
                    ans++;
                }
            }
            hmap.put(strEle, true);
        }
        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {13, 5604, 31, 2, 13, 4560, 546, 654, 456};
        int ans = solve(arr);
        System.out.println(ans);
    }
}