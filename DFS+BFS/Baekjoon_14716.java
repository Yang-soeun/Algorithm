import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14716 {
    static int m, n;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] arrY = {0, 0, -1, 1, -1, 1, 1, -1};

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

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        array = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(array[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<8; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX<0 || newY <0 || newX>=m || newY>=n) continue;
                if(!visited[newX][newY] && array[newX][newY] == 1){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }
    }
}
