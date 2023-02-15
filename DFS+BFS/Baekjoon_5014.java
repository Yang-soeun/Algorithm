import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스타트링크
 */
public class Baekjoon_5014 {
    static int F, S, G, U, D;
    static int[] array;
    static boolean[] visited;

    public static void bfs(int p){
        int[] move = {U, -D};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            if(poll == G){
                System.out.println(array[poll]);
                return;
            }

            for(int i = 0; i<2; i++){
                int newS = poll + move[i];

                if(newS <= 0 || newS>F) continue;
                if(array[newS] == 0 && visited[newS] == false){
                    array[newS] = array[poll] + 1;
                    visited[newS] = true;
                    queue.add(newS);
                }
            }

        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());//건물의 총 층 수
        S = Integer.parseInt(st.nextToken());//현재 있는 곳
        G = Integer.parseInt(st.nextToken());//가야하는 층
        U = Integer.parseInt(st.nextToken());//위로 가는 층
        D = Integer.parseInt(st.nextToken());//아래로 가는 층

        array = new int[F+1];
        visited = new boolean[F+1];
        visited[S] = true;

        bfs(S);
    }
}
