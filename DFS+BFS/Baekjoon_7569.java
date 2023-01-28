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

    static int[][][] array;
    static int[] arrX = {0,0,-1, 1, 0,0};
    static int[] arrY = {0,0, 0,0, -1, 1};
    static int[] arrZ = {-1, 1, 0,0,0,0,};
    static Queue<Pos> queue =  new LinkedList<>();

    public static class Pos{
        int x;
        int y;
        int z;

        public Pos(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static int bfs(){

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i=0; i<6; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];
                int newZ = poll.z + arrZ[i];

                if(newX<0 || newY <0 || newZ<0 || newX>=n || newY>=m || newZ>=h) continue;
                if(array[newZ][newX][newY] == 0){
                    array[newZ][newX][newY] = array[poll.z][poll.x][poll.y] + 1;
                    queue.add(new Pos(newZ, newX, newY));
                }
            }
        }

        int max = 0;

        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    if(array[i][j][k] == 0)
                        return -1;
                    if(max<array[i][j][k])
                        max = array[i][j][k];
                }
            }
        }

        return max -1;
    }

    public static void main(String[] args) throws IOException{

        m = read();
        n = read();
        h = read();

        array = new int[h][n][m];

        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    array[i][j][k] = read();;
                    if(array[i][j][k] == 1)
                        queue.add(new Pos(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int read() throws IOException {
        int ninput, value = System.in.read() - 48;
        while ((ninput = System.in.read()) > 32)//줄바꿈이나 공백이 아닐때
            value = 10 * value + ninput - 48;
        return value;
    }
}
