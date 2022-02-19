class Pair {
    int x;
    int y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class programques {
    public static int solution(int N, int[] a, int [] b){
        int count[] = new int[N];
        for(int i=0;i<N;i++){
            count[i] = 0;
        }
        Pair[] pairs = new Pair[N];
        for(int i=0;i<a.length;i++){
            count[a[i]]++;
            count[b[i]]++;
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

    public static void main(String args[]) {
        int [] arr1 = {2,2,1,2};
        int[] arr2 =  {1,3,4,4};
        int ans = solution(5, arr1, arr2);
        System.out.println(ans);
    }
}