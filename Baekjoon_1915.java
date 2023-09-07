import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가증 큰 정사각형 -> ICT 인턴십 코딩테스트 3번 문제 유형
 */
public class Baekjoon_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int array[][] = new int[n + 1][m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);

                if (c == '1') {
                    array[i][j] = Math.min(array[i - 1][j - 1], Math.min(array[i - 1][j], array[i][j - 1])) + 1;
                    max = Math.max(max, array[i][j]);
                }
            }
        }

        System.out.print(max * max);
    }
}
