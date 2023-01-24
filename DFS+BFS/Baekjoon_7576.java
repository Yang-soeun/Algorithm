import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 */

public class Baekjoon_7576 {
    static int m,n;
    static int[][] array;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};
    static Queue<Pos> queue = new LinkedList<>();

    public static class Pos{
        int x;
        int y;
        int cnt;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(){

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            int cnt = poll.cnt;

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX <0 || newY <0 || newX>=n || newY>=m)
                    continue;

                if(array[newX][newY] == 0){
                    array[newX][newY] = array[poll.x][poll.y] + 1;
                    queue.add(new Pos(newX, newY));
                }
            }
        }

        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(array[i][j] == 0)
                    return -1;
                if(max < array[i][j])
                    max = array[i][j];
            }
        }

        return max -1;
    }

    public static void main(String[] args) throws IOException {
        m = readInt();
        n = readInt();

        array = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                array[i][j] = readInt();
                if(array[i][j] == 1)
                    queue.add(new Pos(i, j));
            }
        }

        System.out.println(bfs());
    }

    private static int readInt() throws IOException {
        int value = 0;
        boolean negative = false;

        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (negative) ? -value : value;
            } else if (input == '-') {
                negative = true;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}
