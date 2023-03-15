import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 단지번호붙이기
 * dfs
 */
public class Baekjoon_2667 {
   static int n;
   static int[][] array;
   static boolean[][] visited;
   static int area=0;
   static int[] arrX = {-1, 1, 0,0};
   static int[] arrY = {0,0,-1,1};
   public static int dfs(int x, int y){

       visited[x][y] = true;
       area++;

       for(int i = 0; i<4; i++){
           int newX = x + arrX[i];
           int newY = y + arrY[i];

           if(newX<0 || newY <0 || newX>=n || newY>=n) continue;
           if(array[newX][newY] ==1 && visited[newX][newY] == false){
               visited[newX][newY] = true;
               dfs(newX, newY);
           }
       }


       return area;
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        int count =0;

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                array[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(array[i][j] == 1 && visited[i][j] == false){
                    area = 0;
                    pqueue.add(dfs(i, j));
                    visited[i][j] = true;
                    count ++;
                }
            }
        }

        if(count == 0){
            sb.append(count).append("\n");
            sb.append(0);
        }
        else {
            sb.append(count).append("\n");
            while (!pqueue.isEmpty())
                sb.append(pqueue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
