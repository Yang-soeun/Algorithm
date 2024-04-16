import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 강의실 배정
 */
public class Baekjoon_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> room = new HashMap<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            room.put(start, room.getOrDefault(start, 0) + 1);
            room.put(end, room.getOrDefault(end, 0) - 1);
        }

        List<Integer> keySet = new ArrayList<>(room.keySet());
        Collections.sort(keySet);

        int count = 0;
        int max = 0;

        for (Integer key : keySet) {
            count += room.get(key);
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
