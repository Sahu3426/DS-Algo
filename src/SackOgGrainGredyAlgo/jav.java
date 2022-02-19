import java.util.HashMap;

class Main {
    static int value_of_arr(int N, int K, int[] A){
        for(int i=0; i<N-K;i++){
            HashMap<Integer, Integer> hmap = new HashMap<>();
            int ans = 0;
            for(int j=i; j< i+K; j++){

                if(hmap.containsKey(A[j])){
                    int val = hmap.get(containsKey(A[j]);
                    hmap.put(hmap.containsKey(A[j], val++);
                } else {
                    hmap.put(hmap.containsKey(A[j], 1);
                }

            }
            Iterator<Map.Entry<String, String>> itr = hmap.entrySet().iterator();

            while(itr.hasNext())
            {
                Map.Entry<String, String> entry = itr.next();
                System.out.println("Key = " + entry.getKey() +
                        ", Value = " + entry.getValue());
            }
        }
    }
    public static void main(String args[]) {

    }
}