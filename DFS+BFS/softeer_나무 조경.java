import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static boolean[][] visited;
    static final int[] arrX = {0, 1};
    static final int[] arrY = {1, 0};
    static int ans = 0, n;
    static int maxDepth = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n == 2){
            maxDepth = 2;
        }
        
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int sum, int depth){
        if(depth == maxDepth){
            ans = Math.max(sum, ans);
            return;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<2; k++){
                    if(visited[i][j]) continue;
                    int newX = i + arrX[k];
                    int newY = j + arrY[k];

                    if(newX >= n || newY >= n) continue;
                    
                    if(!visited[newX][newY]){
                        visited[i][j] = true;
                        visited[newX][newY] = true;
                        dfs(sum+array[newX][newY]+array[i][j], depth+1);
                        visited[i][j] = false;
                        visited[newX][newY] = false;
                    }
                }
            }
        }
    }
}
