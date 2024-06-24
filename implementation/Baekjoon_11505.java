import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11505 {
    static final int MOD = 1000000007;
    static long[] array;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new long[n];
        tree = new long[4*n];

        for(int i = 0; i<n; i++){
            array[i] = Long.parseLong(br.readLine());
        }

        initTree(0, n-1, 1);

        while(m!=0 || k!=0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                array[b-1] = c;
                updateTreeUp(0, n-1, 1, b-1, c);
                m--;
            }else if(a == 2){
                long mul = mulTree(0, n-1, 1, b-1, (int)c-1);
                sb.append(mul).append("\n");
                k--;
            }
        }
        System.out.println(sb);
    }

    public static long initTree(int start, int end, int node){
        if(start == end) {
            return tree[node] = array[start];
        }
        int mid = (start + end) /2;
        return tree[node] = (initTree(start, mid, 2*node) * initTree(mid+1, end, 2*node +1)) %MOD;
    }

    public static long updateTreeUp(int start, int end, int node, int changePos, long c){
        if(start > changePos || end < changePos){
            return tree[node];
        }

        if(start == end){
            return tree[node] = c;
        }

        int mid = (start + end) /2;
        return tree[node] = (updateTreeUp(start, mid, 2*node, changePos, c) * updateTreeUp(mid+1, end, 2*node+1, changePos, c)) % MOD;
    }

    public static long mulTree(int start, int end, int node, int b, int c){
        if(start > c || end < b) return 1;
        if(start>=b && end <=c) return tree[node];

        int mid = (start + end)/2;
        return (mulTree(start, mid, 2*node, b, c) * mulTree(mid+1, end, 2*node + 1, b, c))%MOD;
    }
}
