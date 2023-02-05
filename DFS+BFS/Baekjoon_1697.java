import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */

public class Baekjoon_1697 {
    static int n; //출발
    static int k; //도착
    static int[] visited;


    public static int bfs(int n){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            if(poll == k)
            {
                return visited[poll] -1;
            }

            int[] arrX = {(poll + 1), (poll-1), (poll*2)};

            for(int i = 0; i<3; i++){
                int newX = arrX[i];

                if(newX >=0 && newX <=100000 && visited[newX] == 0){//순서 주의!! 순서 바뀌면 런타임 에러 발생함
                    visited[newX] = visited[poll] + 1;
                    queue.add(newX);
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        visited[n] = 1;

        System.out.println(bfs(n));

    }
}
