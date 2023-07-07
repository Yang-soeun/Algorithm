import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열 사이클
 */

public class Baekjoon_10451 {
    static boolean[] visited;
    static int N;
    static int[] array;
    public static void dfs(int start){
        if(visited[start] == false){
            int next = array[start];
            visited[start] = true;
            dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int t = 0;

        while(t<T){
            N = Integer.parseInt(br.readLine());
            array = new int[N+1];
            visited = new boolean[N+1];
            int count = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<N+1; i++){
                int j = Integer.parseInt(st.nextToken());
                array[i] = j;
            }

            for(int i = 1; i<N+1; i++){
                if(visited[i] == false){
                    int start = array[i];
                    visited[i] = true;
                    dfs(start);
                    count++;
                }
            }

            sb.append(count).append("\n");
            t++;
        }

        System.out.println(sb);
    }
}
