import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Best Grass
 */
public class Baekjoon_6186 {
    static int R, C, count;
    static int[][] array;
    static boolean[][] visited;
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
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while (!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX<0 || newY <0 || newX>=R || newY >=C) continue;
                if(array[newX][newY] == '#' && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i<R; i++){
            String str = br.readLine();
            for(int j = 0; j<C; j++){
                array[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(array[i][j] == '#' && visited[i][j] ==false){
                    visited[i][j] = true;
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}
