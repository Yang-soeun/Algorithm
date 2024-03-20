package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_4963 {
    static int w;
    static int h;
    static int count;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrX = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] arrY = {0, 0, -1, 1, -1, 1, 1, -1};

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
        queue.add(new Pos(x, y));

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int newX = poll.x + arrX[i];
                int newY = poll.y + arrY[i];

                if (newX < 0 || newY < 0 || newX >= h || newY >= w) {
                    continue;
                }

                if (visited[newX][newY] == false && array[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.add(new Pos(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s;

        while(!(s = br.readLine()).equals("0 0")){
            st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            array = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<w; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(visited[i][j] == false && array[i][j] == 1){
                        visited[i][j] = true;
                        bfs(i, j);
                        count ++;
                    }
                }
            }

            sb.append(count).append("\n");
            count = 0;
        }

        System.out.println(sb);
    }
}
