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
    static boolean[][] visited;
    static int[] arrX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] arrY = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int count = 0;
    static int near = 0;
    static int newX, newY;

    static class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int bfs(int x, int y){
        count = 0;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<8; i++){
                if((poll.x)%2 == 0){//짝수인 경우
                    if(arrX[i]== 1 && arrY[i] ==-1 ||(arrX[i]== -1 && arrY[i] ==-1)) continue;
                    newX = poll.x + arrX[i];
                    newY = poll.y + arrY[i];
                }
                else{//홀수인 경우
                    if((arrX[i]== 1 && arrY[i] ==1) ||(arrX[i]== -1 && arrY[i] ==1)) continue;
                    newX = poll.x + arrX[i];
                    newY = poll.y + arrY[i];
                }
 

                if(newX <0 ||newY<0 ||newX>=H || newY >=W) continue;
                if(array[newX][newY] == 1){
                    near ++;
                    if(visited[newX][newY] == false) {
                        queue.add(new Pos(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }

            count += (6-near);
            near = 0;
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int len = 0;

        array = new int[H][W];
        visited = new boolean[H][W];

        for(int i = 0; i<H; i++){//행
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<W; j++){//열
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<H; i++){
            for(int j = 0; j<W; j++){
                if(array[i][j] == 1 && visited[i][j]==false){
                    visited[i][j] = true;
                    len += bfs(i, j);
                }
            }
        }

        System.out.println(len);
    }
}
