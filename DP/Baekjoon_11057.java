import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오르막 수
 */
public class Baekjoon_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N][10];
        int num = 0;

        for(int i = 0; i<10; i++)
            dp[0][i] = 1;

        for(int i = 1; i<N; i++){
            for(int j = 0; j<10; j++){
                for(int k = j; k<10; k++)
                    dp[i][j] += dp[i-1][k]%10007;
            }
        }

        for(int i = 0; i<10; i++)
            num += dp[N-1][i];

        System.out.println(num%10007);
    }
}
