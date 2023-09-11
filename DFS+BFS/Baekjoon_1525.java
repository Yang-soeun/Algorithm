import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 퍼즐
 */
public class Baekjoon_1525 {
    static String answer = "123456780";
    static int[] arrX = {-1, 1, 0,0};
    static int[] arrY = {0,0,-1, 1};
    static Map<String, Integer> map = new HashMap<>();

    public static int bfs(String puzzle){
        Queue<String > queue = new LinkedList<>();
        queue.add(puzzle);

        while(!queue.isEmpty()){
            String poll = queue.poll();
            int count = map.get(poll);
            int zeroPos = poll.indexOf("0");
            int zeroRow = zeroPos%3;
            int zeroCol = zeroPos/3;

            if(poll.equals(answer))
                return count;

            for(int i = 0; i<4; i++){
                int newX = zeroRow + arrX[i];
                int newY = zeroCol + arrY[i];

                if(newX<0 || newX>2 || newY <0 || newY>2) continue;

                int changePos = newX + 3*newY;
                char c = poll.charAt(changePos);

                String temp = poll.replace(c, 't');
                temp = temp.replace('0', c);
                temp = temp.replace('t', '0');

                if(!map.containsKey(temp)){
                    queue.add(temp);
                    map.put(temp, count + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String puzzle = "";

        for(int i = 0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                int num = Integer.parseInt(st.nextToken());
                puzzle += num;
            }
        }

        map.put(puzzle, 0);
        System.out.println(bfs(puzzle));
    }
}
