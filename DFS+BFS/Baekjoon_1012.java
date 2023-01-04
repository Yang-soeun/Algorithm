import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1012 {
    static int m;
    static int n;
    static int[][] array;//배추 위치
    static boolean[][] visited;//방문

    static int[] px = {0, 0, -1, 1};
    static int[] py = {-1, 1, 0, 0};

    static int count = 0;

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){

        Queue<Pos> queue = new LinkedList<>();
        Pos pos = new Pos(x,y);

        queue.add(pos);
        visited[pos.x][pos.y] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++){
                int newX = poll.x + px[i];
                int newY = poll.y + py[i];

                if(newX < 0 || newY < 0 || newX>=m || newY >=n)
                    continue;

                if(array[newX][newY] == 1 && visited[newX][newY] == false){
                    queue.add(new Pos(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

        count ++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());
        int k;



        for(int i = 0; i<a; i++){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            array = new int[m][n];
            visited = new boolean[m][n];

            for(int j = 0; j<k; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                array[x][y] = 1;
            }

            for(int s = 0; s<m; s++){
                for(int t =0; t<n; t++){
                    if(array[s][t] == 1 && visited[s][t] == false)
                        bfs(s, t);
                }
            }

            System.out.println(count);
            count = 0;
        }
    }
}
