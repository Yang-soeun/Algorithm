import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_12761 {
    static int A, B;
    static int N, M;
    static int[] array;
    static boolean[] visited;

    public static class Pos{
        int x;
        int count;

        public Pos(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static int bfs(int x){
        int[] arrX = {-1, 1, -A, A, -B, B, A, B};
        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(x, 0));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(poll.x == M){
                return poll.count;
            }

            for(int i = 0; i<8; i++){
                int newX = poll.x + arrX[i];

                if (i > 5) {
                    newX = poll.x * arrX[i];
                }

                if (newX < 0 || newX > 100000) continue;
                if(visited[newX] == false){
                    visited[newX] = true;
                    queue.add(new Pos(newX, poll.count+1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[100001];
        visited = new boolean[100001];

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }
}
