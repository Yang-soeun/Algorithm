package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 침투
 */
public class Baekjoon_13565 {
    static int M;
    static int N;
    static char[][] array;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        array = new char[M][N];

        for(int i = 0; i<M; i++){
            array[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<N; i++){
            if(array[0][i] == '0'){
                if(bfs(0, i)){
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    public static boolean bfs(int x, int y){
        boolean[][] visited = new boolean[M][N];
        visited[x][y] = true;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            if(poll.x == M-1){
                return true;
            }

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX < 0 || newY < 0 || newX >=M || newY >=N ) continue;
                if(array[newX][newY] == '0' && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }
        return false;
    }
}
