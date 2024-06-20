
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon_2042 {
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
        tree = new long[n*4];

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
                long diff = (c - array[b-1]);
                array[b-1] = c;
                updateTree(0, n-1, 1, b-1, diff);
                m--;
            }
            else if(a == 2){
                long sum = sumTree(0, n-1, 1, b-1, c-1);
                sb.append(sum).append("\n");
                k--;
            }
        }

        System.out.println(sb);
    }

    private static long sumTree(int start, int end, int node, int b, long c) {
        if(end < b || start > c) return 0;
        if(start>=b && end <=c) return tree[node];

        int mid = (start + end) /2;
        return sumTree(start, mid, 2*node, b, c) + sumTree(mid+1, end, 2*node + 1, b, c);
    }

    private static void updateTree(int start, int end, int node, int changePos, long diff) {
        if(changePos < start || changePos > end) return;
        tree[node] += diff;
        int mid = (start + end)/2;
        if(start == end) return;
        updateTree(start, mid, 2*node, changePos, diff);
        updateTree(mid + 1, end, 2*node + 1, changePos, diff);
    }

    private static long initTree(int start, int end, int node) {
        if(start == end)
            return tree[node] = array[start];

        int mid = (start + end)/2;
        return tree[node] = initTree(start, mid, 2*node) + initTree(mid + 1, end, 2*node + 1);
    }
}
