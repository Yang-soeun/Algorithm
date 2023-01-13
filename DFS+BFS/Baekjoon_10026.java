import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs로 풀이
 * 백준 10026번 적록색약 문제
 */
public class Baekjoon_10026 {
    static int n;
    static char[][] array;
    static boolean[][] visited;
    static int[] arrX = {0,0,-1, 1};
    static int[] arrY = {-1,1,0,0};
    static int count =0;

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y){

        Queue<Pos> queue = new LinkedList<>();
        Pos pos = new Pos(x, y);

        queue.add(pos);
        visited[pos.x][pos.y] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            char color = array[poll.x][poll.y];

            for(int i =0 ; i<4; i++)
            {
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX <0 || newY<0 || newX>=n || newY >=n)
                    continue;

                if(array[newX][newY] == color && visited[newX][newY] == false){
                    Pos newPos = new Pos(newX, newY);
                    queue.add(newPos);
                    visited[newX][newY] = true;
                }
            }
        }

        count ++;

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        array = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i<n; i++){
            String color = br.readLine();
            for(int j = 0; j<n; j++){
                array[i][j] = color.charAt(j);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visited[i][j] == false)
                    bfs(i, j);
            }
        }

        sb.append(count).append(" ");
        visited = new boolean[n][n];
        count  = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(array[i][j] == 'G')
                    array[i][j] = 'R';
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visited[i][j] == false)
                    bfs(i, j);
            }
        }

        sb.append(count);

        System.out.println(sb);
    }
}
