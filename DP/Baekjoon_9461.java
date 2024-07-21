import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 */
public class Baekjoon_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;

        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());

            for(int j = 4; j<=n; j++){
                dp[j] = dp[j-3] + dp[j-2];
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
