import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 빙산
 */
public class Baekjoon_2573 {
    static int N;//행
    static int M;//열
    static int[][] array;
    static int[][] meltarr;
    static boolean[][] visited;

    static int[] arrX = {-1, 1, 0,0};
    static int[] arrY = {0,0,-1, 1};

    static Queue<Pos> queue = new LinkedList<>();

    static int count =0;//인접하는 0의 개수
    static int cnt = 0;//구역의 개수
    static int year = 0;
    static int all = 0; //다 녹았는지 확인하는 함수

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(Pos p){
        Queue<Pos> que = new LinkedList<>();

        que.add(p);

        while(!que.isEmpty()){
            Pos poll = que.poll();

            for(int i = 0; i< 4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX < 0 || newY<0 || newX>=N || newY>=M) continue;
                if(meltarr[newX][newY] != 0 && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    que.add(new Pos(newX, newY));
                }
            }
        }
        cnt++;
    }

    public static void melt(){
        year ++;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX < 0 || newY<0 || newX>=N || newY>=M) continue;
                if(array[newX][newY] == 0)
                    count ++;
            }

            if(count != 0){
                meltarr[poll.x][poll.y] -= count;
                if(meltarr[poll.x][poll.y] < 0)
                    meltarr[poll.x][poll.y] = 0;
                count = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new boolean[N][M];
        meltarr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                meltarr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    array[i][j] = meltarr[i][j];
                    if (array[i][j] != 0) {
                        all++;
                        queue.add(new Pos(i, j));
                    }
                }
            }

            if(all == 0){
                System.out.println(all);
                break;
            }

            all = 0;

            melt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (meltarr[i][j] != 0 && visited[i][j] == false) {
                        bfs(new Pos(i, j));
                    }
                }
            }

            if (cnt >= 2){
                System.out.println(year);
                break;
            }

            visited = new boolean[N][M];
            cnt = 0;
            all = 0;
        }
    }
}
