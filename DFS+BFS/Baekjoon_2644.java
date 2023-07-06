import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2644 {
    static int [][] array;
    static boolean[][] visited;
    static int n, p2;
    static boolean finish = false;
    static int finCount;

    public static class Pos{
        int x;
        int count;

        public Pos(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    public static void dfs(Pos pos){
        int start = pos.x;
        int count = pos.count;

        for(int i =1; i<n+1; i++){
            if(array[start][i] == 1 && visited[i][start] == false){
                if(i == p2){
                    finCount = count;
                    finish = true;
                    return;
                }
                visited[start][i] = true;
                dfs(new Pos(i, count+1));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int p1;
        int m;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        array = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            array[x][y] = array[y][x] = 1;
        }

        dfs(new Pos(p1, 1));
        if(finish == true)
            System.out.println(finCount);
        else System.out.println(-1);
    }
}
