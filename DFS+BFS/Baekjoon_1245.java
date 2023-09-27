import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 농장 관리
 */
public class Baekjoon_1245 {
    static int N, M;
    static int[][] array;
    static boolean[][] visited;
    static int count = 0;
    static int[] arrX = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] arrY = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static class Pos{
        int px;
        int py;

        public Pos(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }

    public static void bfs(int x, int y){
        boolean isTop= true;//산봉우리인지
        int nowTop = array[x][y];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<8; i++){
                //격자무늬
                int newX = poll.px + arrX[i];
                int newY = poll.py + arrY[i];

                if(newX<0 || newY<0 || newX>=N || newY >=M) continue; //배열 범위 밖
                if(nowTop < array[newX][newY]) {//주위가 더 높으면 산봉우리가 아님
                    isTop = false;
                }
                else if(visited[newX][newY] == false && nowTop == array[newX][newY]){
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }

        if(isTop == true)
            count ++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ;i<N; i++){
            for(int j =0; j<M; j++){
                if(array[i][j] != 0 && visited[i][j] ==false){
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}
