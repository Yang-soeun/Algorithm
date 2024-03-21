package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 데스 나이트
 */
public class Baekjoon_16948 {
    static int N;
    static int r2;
    static int c2;
    static int[][] array;
    static boolean[][] visited;
    static int[] arrR = {-2, -2, 0, 0, 2, 2};
    static int[] arrC = {-1, 1, -2, 2, -1, 1};

    public static class Pos{
        int r;
        int c;
        int count;

        public Pos(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited[r1][c1] = true;
        System.out.println(bfs(r1, c1, 1));
    }

    public static int bfs(int r, int c, int count){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c, count));

        while(!queue.isEmpty()){
            Pos poll = queue.poll();

            for(int i = 0; i<6; i++){
                int newR = poll.r + arrR[i];
                int newC = poll.c + arrC[i];

                if (newR < 0 || newC < 0 || newR >= N || newC >= N || visited[newR][newC]) continue;

                if(newR == r2 && newC == c2){
                    return poll.count;
                }

                visited[newR][newC] = true;
                queue.add(new Pos(newR, newC, poll.count + 1));
            }
        }

        return -1;
    }
}
