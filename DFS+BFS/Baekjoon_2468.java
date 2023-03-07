import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 안전 영역
 * bfs
 */
public class Baekjoon_2468 {
    static int n;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY ={0,0,-1, 1};
    static int count;
    static int h = 1;

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(Pos p){
        Queue<Pos> queue = new LinkedList<>();

        queue.add(p);

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX<0 || newY<0 || newX>=n || newY>=n) continue;
                if(array[newX][newY] >= h && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }

        count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        int max = 0;

        for(int i = 0; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] > max)
                    max = array[i][j];
            }
        }

        while(h<=max){
            count =0;
            visited = new boolean[n][n];

            for(int i = 0; i<n ; i++){
                for(int j = 0; j<n; j++){
                    if(array[i][j]>=h && visited[i][j] ==false){
                        visited[i][j] = true;
                        bfs(new Pos(i, j));
                    }
                }
            }

            pqueue.add(count);
            h++;
        }

        System.out.println(pqueue.poll());
    }
}
