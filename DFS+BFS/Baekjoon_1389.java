import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 케빈 베이컨의 6단계 법칙
 */

public class Baekjoon_1389 {
    static int N;
    static int[][] array;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, minNum;

    public static class Pos{
        int start;
        int count;

        public Pos(int start, int count) {
            this.start = start;
            this.count = count;
        }
    }
    public static void bfs(Pos p){
        Queue<Pos> queue = new LinkedList<>();
        int count = 0;

        visited[p.start] = true;
        queue.add(p);

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            count += poll.count;

            for(int i = 1; i<=N; i++){
                if(array[poll.start][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    queue.add(new Pos(i, poll.count+1));
                }
            }
        }

        if(count < min){
            min = count;
            minNum = p.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array= new int[N+1][N+1];

        for(int i = 0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            array[x][y] = array[y][x] = 1;
        }

        for(int i = 1; i<N+1; i++){
            visited = new boolean[N+1];
            bfs(new Pos(i, 0));
        }

        System.out.println(minNum);
    }
}
