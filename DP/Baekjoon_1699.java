import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제곱수의 합
 */
public class Baekjoon_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;

        for(int i = 2; i<=N; i++){
            dp[i] = i;//1로만 표현할 수 있는 경우의 수
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
