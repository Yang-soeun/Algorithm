import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질 3
 */
public class Baekjoon_13549 {
    static int N;//수빈이 위치
    static int K;//동생 위치
    static int[] array;
    static boolean[] visited;

    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            if(poll == K){
                System.out.println(array[poll] -1);
                return;
            }

            int[] newPos = {poll*2, poll -1, poll +1};

            for(int i = 0; i<3; i++){
                int newP = newPos[i];

                if(newP < 0 || newP >100000) continue;

                if(array[newP] == 0 && visited[newP] == false)
                {
                    if(i == 0){
                        array[newP] = array[poll];
                    }
                    else{
                        array[newP] = array[poll] + 1;
                    }

                    visited[newP] = true;
                    queue.add(newP);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[100001];
        visited = new boolean[100001];

        array[N] = 1;
        visited[N] = true;

        bfs(N);
    }
}
