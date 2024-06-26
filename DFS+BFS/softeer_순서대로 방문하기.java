import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static boolean[][] visited;
    static final int[] arrX = {-1, 1, 0, 0};
    static final int[] arrY = {0, 0, -1, 1};
    static int n, m, count = 0;
    static Pos[] route;
    
    public static class Pos{
        int x;
        int y;
        
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//배열 크기
        m = Integer.parseInt(st.nextToken());//방문해야 하는 칸의 수

        array = new int[n][n];
        visited = new boolean[n][n];
        route = new Pos[m];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            route[i] = new Pos(x, y);
        }

        visited[route[0].x][route[0].y] = true;
        dfs(route[0], 0);
        System.out.println(count);
    }

    public static void dfs(Pos p, int depth){
        if(route[m-1].x == p.x && route[m-1].y == p.y){
            if(depth == m-1){
                count ++;
                return;
            }
        }

        visited[p.x][p.y] = true;
        
        if(route[depth].x == p.x && route[depth].y == p.y){
            dfs(p, depth + 1);
        }

        for(int i = 0; i<4; i++){
            int newX = arrX[i] + p.x;
            int newY = arrY[i] + p.y;

            if(newX < 0 || newY < 0 || newX>=n || newY >= n) continue;
            
            if(!visited[newX][newY] && array[newX][newY] == 0){
                visited[newX][newY] = true;
                dfs(new Pos(newX, newY), depth);
                visited[newX][newY] = false;
            }
        }
    }
}
