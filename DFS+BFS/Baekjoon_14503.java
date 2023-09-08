import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 */
public class Baekjoon_14503 {
    static int N, M;
    static int r, c, d;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0,-1, 1};
    static int count = 0;
    static boolean doClean = false;

    public static int dfs(int x, int y, int z){
        doClean = false;

        if(array[x][y] == 0 && visited[x][y] == false){//1번
            visited[x][y] = true;
            count ++;
        }

        for(int i = 0; i<4; i++){//2번
            int newX = x + arrX[i];
            int newY = y + arrY[i];

            if(array[newX][newY] == 0 && visited[newX][newY] == false)
            {
                doClean = true;
                break;
            }
        }

        if(doClean == false){//2번 - 주변이 다 막힌경우
            back(x, y, z);

            if(array[r][c] == 0)//후진
            {
                dfs(r, c, z);
            }
            else//후진이 불가능한 경우
                return count;
        }else{//3번 - 청소가 되지 않은 빈칸이 있는 경우
            //90도 회전
            while (true){
                if(z != 0)
                    z = z-1;
                else
                    z = 3;

                front(x, y, z);

                if(array[r][c] == 0 && visited[r][c] == false){//바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                    dfs(r, c, z);
                    break;
                }
            }
        }


        return count;
    }

    private static void back(int x, int y, int z) {
        if(z == 0) {
            r = x +1;
            c = y;
        }
        else if(z == 1) {
            r = x;
            c = y-1;
        }
        else if(z == 2) {
            r = x -1;
            c = y;
        }
        else {
            r = x;
            c = y+1;
        }
    }

    private static void front(int x, int y, int z) {
        if(z == 0){
            r = x -1;
            c = y;
        }
        else if(z == 1) {
            r = x;
            c = y+1;
        }
        else if(z == 2){
            r = x + 1;
            c = y;
        }
        else{
            r = x;
            c = y-1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(r, c, d));
    }
}
