import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 상범 빌딩
 */
public class Baekjoon_6593 {
    static int l;//층
    static int r;//행
    static int c;//열
    static Character[][][] array;
    static boolean[][][] visited;

    //동,서,남,북,상,하
    static int[] arrX = {0,0,-1,1,0,0};
    static int[] arrY = {0,0,0,0,-1,1};
    static int[] arrZ = {-1,1,0,0,0,0};

    public static class Point{
        int x;
        int y;
        int z;
        int count;

        public Point(int z, int x, int y, int count) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(Point p){
        Queue<Point> queue = new LinkedList<>();

        queue.add(p);

        while(!queue.isEmpty()){
            Point poll = queue.poll();

            if(array[poll.z][poll.x][poll.y] == 'E'){
                return poll.count;
            }

            for(int i = 0; i<6; i++){
                int newZ = poll.z + arrZ[i];
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newZ<0 || newY<0 || newX<0 || newZ>=l || newX>=r || newY >= c) continue;
                if((array[newZ][newX][newY] == '.' && visited[newZ][newX][newY] == false) || array[newZ][newX][newY] == 'E'){
                    visited[newZ][newX][newY] = true;
                    queue.add(new Point(newZ, newX, newY, poll.count + 1));
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r ==0 && c==0){
                System.out.println(sb);
                break;
            }

            array = new Character[l][r][c];
            visited = new boolean[l][r][c];
            String str;

            for(int i = 0; i<l; i++){
                for(int j = 0; j<r; j++){
                    str = br.readLine();
                    if(str.isEmpty())
                        str = br.readLine();
                    for(int k = 0; k<c; k++){
                        array[i][j][k] = str.charAt(k);
                    }
                }
            }

            int count =0;
            for(int i = 0; i<l; i++){
                for(int j = 0; j<r; j++){
                    for(int k = 0; k<c; k++){
                        if(array[i][j][k] == 'S'){
                            visited[i][j][k] = true;
                            count = bfs(new Point(i, j, k, 0));
                        }
                    }
                }
            }

            if(count !=0)
                sb.append("Escaped in " + count + " minute(s).").append("\n");
            else
                sb.append("Trapped!").append("\n");

            str = br.readLine();
        }
    }
}