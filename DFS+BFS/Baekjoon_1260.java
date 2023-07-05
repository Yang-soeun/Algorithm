import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS 와 BFS
 */
public class Baekjoon_1260 {

    static StringBuilder sb = new StringBuilder();
    static int n, m, v;
    static int[][] array;
    static boolean[] visited;

    public static void dfs(int start){
        sb.append(start).append(" ");
        visited[start] = true;

        for(int i = 1; i<n+1; i++){
            if(array[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            sb.append(poll).append(" ");

            for(int i = 1; i< n+1; i++){
                if(array[poll][i] == 1 && visited[i] ==false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        array = new int[n+1][n+1];
        visited = new boolean[n+1];

        int x, y;

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            array[x][y] = 1;
            array[y][x] = 1;
        }

        dfs(v);
        visited = new boolean[n+1];
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }
}
