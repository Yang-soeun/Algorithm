import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14248 {
    static int n, s;
    static int[] bridge;
    static boolean[] visited;

    public static void bfs(int index){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            int arrX[] = {bridge[poll], -bridge[poll]};

            for(int i = 0; i<2; i++){
                int newIndex = poll + arrX[i];

                if(newIndex<1 || newIndex>n) continue;
                if(visited[newIndex] == false){
                    visited[newIndex] = true;
                    queue.add(newIndex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        bridge = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());

        visited[s] = true;
        bfs(s);

        int count = 0;
        for (boolean b : visited) {
            if(b) count++;
        }

        System.out.println(count);
    }
}
