import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_2583 {
    static int[] px = {0,0,-1, 1};
    static int[] py = {-1, 1, 0,0};
    static boolean[][] visited;
    static int m;
    static int n;

    public static int DFS(int x, int y)
    {
        int size = 1;
        int newX, newY;

        for(int i = 0; i<4; i++){
            newX = x+px[i];
            newY = y+py[i];

            if(newX< 0 || newY<0 || newX>=m || newY>=n)
                continue;

            if(visited[newX][newY] == false)
            {
                visited[newX][newY] = true;
                size += DFS(newX, newY);
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        int count =0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int lx, ly, rx, ry;
        for(int i = 0; i<k; i++){
            st =  new StringTokenizer(br.readLine());

            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());

            for(int s = ly; s<ry; s++){
                for(int t = lx; t<rx; t++)
                    visited[s][t] = true;
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    queue.add(DFS(i,j));
                    count++;
                }
            }
        }

        sb.append(count).append("\n");
        while (!queue.isEmpty())
            sb.append(queue.poll()).append(" ");

        System.out.println(sb);
    }
}
