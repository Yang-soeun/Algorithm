package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 양
 */
public class Baekjoob_3184 {
    static int r, c;
    static int sCount = 0, wCount = 0;
    static char[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        array = new char[r][c];
        visited = new boolean[r][c];

        int sheep = 0, wolf = 0;

        for(int i = 0; i<r; i++){
            String str = br.readLine();
            for(int j = 0; j<c; j++){
                char ch = str.charAt(j);
                array[i][j] = ch;
            }
        }

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(array[i][j] != '#' && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j);
                    if(sCount > wCount){
                        sheep += sCount;
                    }else{
                        wolf += wCount;
                    }
                    sCount = wCount = 0;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void dfs(int x, int y){
        if(array[x][y] == 'o') sCount++;
        if(array[x][y] == 'v') wCount++;
        for(int i = 0; i<4; i++){
            int newX = x + arrX[i];
            int newY = y + arrY[i];

            if(newX < 0 || newY <0 || newX>= r || newY>=c) continue;
            if(!visited[newX][newY] && array[newX][newY] != '#'){
                visited[newX][newY] = true;
                dfs(newX, newY);
            }
        }
    }
}
