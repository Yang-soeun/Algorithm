import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숨바꼭질2
 * 큐: FIFO
 * 스택: LIFO
 */
public class Baekjoon_13913 {
    static int n;//수빈이 위치
    static int k;//동생이 있는 위치
    static int[] visited;
    static int[] route;

    public static int bfs(int p){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            if(poll == k){
                return visited[poll] -1;
            }

            int[] arrX = {(poll-1), (poll+1), (2*poll)};

            for(int i = 0; i<3; i++){
                int newX = arrX[i];

                if(newX>=0 && newX<=100000 && visited[newX] == 0){
                    visited[newX] = visited[poll] + 1;
                    queue.add(newX);
                    route[newX] = poll;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        route = new int[100001];
        visited[n] = 1;

        sb.append(bfs(n)).append("\n");

        Stack<Integer> stack = new Stack<>();
        int index = k;
        while(index != n){
            stack.push(index);
            index = route[index];
        }

        stack.push(n);

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
