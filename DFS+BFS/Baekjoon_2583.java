import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2583 {

    static int m;
    static int n;
    static int[][] array;
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

    public static void bfs(int x, int y){
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

                if(array[newX][newY] !=1 && visited[newX][newY] == false)
                {
                    Pos newPos = new Pos(newX, newY);
                    queue.add(newPos);
                    visited[newX][newY] = true;
                    Area++;
                }
            }
        }
        count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> AreaList = new ArrayList<>();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        array = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = m - (Integer.parseInt(st.nextToken()) + 1);
            int rx= Integer.parseInt(st.nextToken()) -1;
            int ry = m - Integer.parseInt(st.nextToken());

            array[ly][lx] = 1;
            array[ry][rx] = 1;

            for(int s = lx; s <= rx; s++){
                for(int t = ly; t>=ry; t-- )
                    if(array[t][s] != 1 && visited[t][s] == false){
                        array[t][s] = 1;
                        visited[t][s] = true;
                    }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(array[i][j] != 1 && visited[i][j] == false)
                {
                    bfs(i, j);
                    AreaList.add(Area);
                }
            }
        }

        System.out.println(count);
        Collections.sort(AreaList);

        for (int i : AreaList) {
            System.out.print(i+" ");
        }
    }
}
