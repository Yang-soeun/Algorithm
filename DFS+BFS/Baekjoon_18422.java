import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Emacs
 */
public class Baekjoon_18422 {
    static int N, M;
    static char[][] array;
    static boolean[][] visited;
    static int count  = 0;
    static int[] arrX = {-1, 1, 0,0};
    static int[] arrY = {0,0,-1, 1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        count++;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX<0 || newY <0 || newX>=N || newY>=M) continue;

                if(array[newX][newY] == '*' && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

         array = new char[N][M];
         visited = new boolean[N][M];

         for(int i = 0; i<N; i++){
             String str = br.readLine();
             for(int j = 0; j<M; j++){
                 array[i][j] = str.charAt(j);
             }
         }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(visited[i][j] == false && array[i][j] =='*'){
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}
