import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 물통
 */
public class Baekjoon_2251 {
    static int bottleA, bottleB, bottleC;
    static List<Integer> list = new ArrayList<>();
    public static class Bucket {
        int x;
        int y;
        int z;

        public Bucket(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void bfs(){
        Queue<Bucket> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[bottleA + 1][bottleB + 1][bottleC + 1];
        queue.add(new Bucket(0, 0, bottleC));

        while (!queue.isEmpty()){
            Bucket poll = queue.poll();

            if(visited[poll.x][poll.y][poll.z]) continue;

            if(poll.x == 0){//첫번째 물통이 비어있을 때 세번째 물통에 담겨있는 물의 양
                list.add(poll.z);
            }

            visited[poll.x][poll.y][poll.z] = true;

            //B-> A
            if(poll.y + poll.x <= bottleA){
                queue.add(new Bucket(poll.x + poll.y, 0, poll.z));
            }
            else{
                queue.add(new Bucket(bottleA, poll.y+ poll.x-bottleA, poll.z));
            }

            //C-> A
            if(poll.x + poll.z <= bottleA){
                queue.add(new Bucket(poll.x + poll.z, poll.y, 0));
            }
            else{
                queue.add(new Bucket(bottleA, poll.y, (poll.z+ poll.x)-bottleA));
            }

            //A-> B
            if(poll.x + poll.y <= bottleB){
                queue.add(new Bucket(0, poll.x+ poll.y, poll.z));
            }
            else{
                queue.add(new Bucket((poll.x + poll.y) - bottleB, bottleB, poll.z));
            }

            //C-> B
            if(poll.y + poll.z <= bottleB){
                queue.add(new Bucket(poll.x, poll.y+ poll.z, 0));
            }
            else{
                queue.add(new Bucket(poll.x, bottleB, (poll.z+ poll.y)-bottleB));
            }

            //A-> C
            if(poll.x + poll.z <= bottleC){
                queue.add(new Bucket(0, poll.y, poll.x + poll.z));
            }
            else{
                queue.add(new Bucket((poll.x + poll.z) - bottleC, poll.y, bottleC));
            }


            //B-> C
            if(poll.y + poll.z <= bottleC){
                queue.add(new Bucket(poll.x , 0, poll.z + poll.y));
            }
            else{
                queue.add(new Bucket(poll.x, (poll.y+ poll.z)-bottleC, bottleC));
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        bottleA = Integer.parseInt(st.nextToken());
        bottleB = Integer.parseInt(st.nextToken());
        bottleC = Integer.parseInt(st.nextToken());

        bfs();
        Collections.sort(list);

        for (Integer i : list) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
