import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178 {

    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};

    public static class Point{
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void bfs(Point p){
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            int newC = poll.count;

            if(poll.x == n-1 && poll.y == m-1){
                System.out.println(poll.count);
                return;
            }

            for(int i =0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX<0 || newY<0|| newX>=n || newY>=m)
                    continue;
                if(maze[newX][newY] == 1 && visited[newX][newY] == false)
                {
                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, newC + 1));
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

        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<m; j++){
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(new Point(0, 0, 1));
    }
}
