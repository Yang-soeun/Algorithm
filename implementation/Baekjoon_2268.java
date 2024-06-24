import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합 7
 */
public class Baekjoon_2268 {
    static long[] array;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new long[n];
        tree = new long[4*n];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 0){ //구간 합
                long sum;
                if(b < c){
                    sum = sumTree(0, n-1, 1, b-1, (int)c-1);
                }else{
                    sum = sumTree(0, n-1, 1, (int)c-1, b-1);
                }
                sb.append(sum).append("\n");
            }else{
                long diff = c - array[b-1];
                array[b-1] = c;
                update(0, n-1, 1, b-1, diff);
            }
        }

        System.out.println(sb);
    }

    public static long sumTree(int start, int end, int node, int b, int c){
        if(start > c || end < b) return 0;  //범위가 아니면
        if(start>=b && end <=c) return tree[node];

        int mid = (start + end)/2;
        return sumTree(start, mid, 2*node, b, c) + sumTree(mid+1, end, 2*node +1, b, c);
    }

    public static void update(int start, int end, int node, int changePos, long diff){
        if(start > changePos || end < changePos) return;
        tree[node] +=diff;

        int mid = (start + end)/2;
        if(start == end) return;


        update(start, mid, 2*node, changePos, diff);
        update(mid+1, end, 2*node+1, changePos, diff);
    }
}
