import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 배열 합치기
 */
public class Baekjoon_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<A; i++){
            result.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<B; i++){
            result.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(result);

        for (Integer num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
