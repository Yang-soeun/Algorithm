import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Baekjoon_2583_bfs {

    static int m;
    static int n;
    static boolean[][] visited;
    static int count;
    static int Area = 0;
    static int[] arrayX = {0,0,-1,1};
    static int[] arrayY = {-1,1,0,0};

    public static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y){
        Area = 1;

        Queue<Pos> queue = new LinkedList<>();

        Pos pos = new Pos(x, y);
        queue.add(pos);
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<4; i++)
            {
                int newX = poll.x + arrayX[i];
                int newY = poll.y + arrayY[i];

                if(newX < 0 || newY <0 || newX>=m || newY>=n)
                    continue;

                if(visited[newX][newY] == false)
                {
                    Pos newPos = new Pos(newX, newY);
                    queue.add(newPos);
                    visited[newX][newY] = true;
                    Area++;
                }
            }
        }
        count++;

        return Area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        visited = new boolean[m][n];

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx= Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int s = ly; s < ry; s++){
                for(int t = lx; t<rx; t++ )
                    if(visited[s][t] == false){
                        visited[s][t] = true;
                    }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(visited[i][j] == false)
                    pqueue.add(bfs(i, j));
            }
        }

        sb.append(count).append("\n");
        while (!pqueue.isEmpty()){
            sb.append(pqueue.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
