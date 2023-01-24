import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 그림
 * 0은 색칠 안된부분, 1은 색칠된 부분
 */
public class Baekjoon_1926 {
    static int n;
    static int m;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};
    static int count  = 0;
    static int area = 0;

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        queue.add(0);

        array = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(array[i][j]==1 && visited[i][j] == false){
                    area  = 1;
                    visited[i][j] = true;
                    queue.add(dfs(i, j));
                    count++;
                }
            }
        }

        sb.append(count).append("\n");
        sb.append(queue.poll());
        System.out.println(sb);
    }

    public static int dfs(int x, int y){
        for(int i = 0; i<4; i++){
            int newX = x + arrX[i];
            int newY = y + arrY[i];

            if(newX<0 || newY<0 || newX>=n || newY>=m) continue;
            if(array[newX][newY] == 1 && visited[newX][newY] == false){
                area++;
                visited[newX][newY]  = true;
                dfs(newX, newY);
            }
        }

        return area;
    }
}
