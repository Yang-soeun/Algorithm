import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7569 {
    static int m;//열
    static int n;//행
    static int h;//높이
    static int[][] array;
    static Queue<Pos> queue = new LinkedList<>();
    static int[] arrX = {-1, 1, 0,0};
    static int[] arrY = {0,0,-1,1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs() {

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            int newH = poll.x - h;

            for (int i = 0; i < 4; i++) {
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if (newX < 0 || newY < 0 || newX >= n * h || newY >= m || newH < 0) continue;

                if (array[newX][newY] == 0) {
                    queue.add(new Pos(newX, newY));
                    array[newX][newY] = array[poll.x][poll.y] + 1;
                }
                if (array[newH][poll.y] == 0) {
                    array[newH][poll.y] = array[poll.x][poll.y] + 1;
                    queue.add(new Pos(newH, poll.y));
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n * h; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0)
                    return -1;
                else if (max < array[i][j])
                    max = array[i][j];
            }
        }

        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        array = new int[n*h][m];

        for(int i = 0; i<n*h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] == 1)
                    queue.add(new Pos(i, j));
            }
        }

        System.out.println(bfs());
    }
}
