import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일루미네이션
 */
public class Baekjoon_5547 {
    static int W, H;
    static int[][] array;
    static int[][] map;
    static boolean[][] visited;
    static int[][] odd =  {{0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};;//홀수
    static int[][] even = {{0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};//짝수
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

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            int newX = 0;
            int newY = 0;

            for(int i = 0; i<6; i++){
                if((poll.x%2) == 0){//짝수인 경우
                    newX = poll.x + even[i][0];
                    newY = poll.y + even[i][1];
                }else{//홀수인 경우
                    newX = poll.x + odd[i][0];
                    newY = poll.y + odd[i][1];
                }

                if(newX < 0 || newY <0|| newX >= H+2 || newY >= W+2) continue;

                if(array[newX][newY] == 1){
                    map[poll.x][poll.y] ++;
                    continue;
                }

                if(visited[newX][newY] || map[newX][newY] != 0) continue;

                visited[newX][newY] = true;
                queue.add(new Pos(newX, newY));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        W = Integer.parseInt(st.nextToken());//열
        H = Integer.parseInt(st.nextToken());//행

        array = new int[H+2][W+2];
        map = new int[H+2][W+2];
        visited = new boolean[H+2][W+2];

        for(int i =1; i<= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=W; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] == 1)
                    visited[i][j] = true;
            }
        }

        bfs(0, 0);
        visited[0][0] = true;

        for(int i =0; i<=H+1; i++){
            for(int j = 0; j<=W+1; j++){
                count += map[i][j];
            }
        }

        System.out.println(count);

    }
}
