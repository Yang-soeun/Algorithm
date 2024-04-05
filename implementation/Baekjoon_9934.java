import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리
 */
public class Baekjoon_9934 {
    static int K;
    static int prePos = 0;
    static int[] building;
    static boolean[] visited;
    public static class Node{
        int h;
        int p;

        public Node(int h, int p) {
            this.h = h;
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        int nodeNum = (int)(Math.pow(2, K) - 1);
        building = new int[nodeNum];
        visited = new boolean[nodeNum];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< nodeNum; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int root = nodeNum /2;
        findTree(root);
    }

    public static void findTree(int root){
        visited[root] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(building[root]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(K, root));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int left = node.p;
            int right = node.p;

            if(prePos != node.h){
                prePos = node.h;
                sb.append("\n");
            }

            if(node.h == 2){
                left -=1;
                right +=1;
                sb.append(building[left]).append(" ").append(building[right]).append(" ");
                continue;
            }

            left -= (int) (Math.pow(2, node.h) / 4);
            right += (int) (Math.pow(2, node.h) / 4);

            if (!visited[left]) {
                sb.append(building[left]).append(" ");
                visited[left] = true;
                queue.add(new Node(node.h - 1, left));
            }
            if (!visited[right]) {
                sb.append(building[right]).append(" ");
                visited[right] = true;
                queue.add(new Node(node.h - 1, right));
            }
        }

        System.out.println(sb);
    }
}
