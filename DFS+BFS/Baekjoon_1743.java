import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 음식물 피하기
 */
public class Main {
    static int n, m, k;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};

    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            array[r-1][c-1] = 1;
        }

        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(array[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        int count = 1;
        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX <0 || newY < 0 || newX >= n || newY >=m) continue;

                if(!visited[newX][newY] && array[newX][newY] == 1){
                    count++;
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }

        return count;
    }
}
