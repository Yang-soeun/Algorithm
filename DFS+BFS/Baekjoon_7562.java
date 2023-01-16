import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7562 {
    static int n, l;
    static boolean[][] visited;
    static Point start, end;
    static int[] arrX = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] arrY = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static class Point{
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(Point p){
        Queue<Point>  queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;

        while(!queue.isEmpty()){
            Point poll = queue.poll();

            int count = poll.count;

            if(poll.x == end.x && poll.y  == end.y){
                return poll.count;
            }

            for(int i = 0; i<8; i++){
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if(newX <0 || newY <0 || newX>=l || newY>=l)
                    continue;
                if(visited[newX][newY] == false){
                    queue.add(new Point(newX, newY, count+1));
                    visited[newX][newY] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            l= Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            start = new  Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            end = new  Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            int count = bfs(start);
            sb.append(count).append("\n");
        }

        //마지막 문제 제거
        if(sb.length() >0)
            sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
