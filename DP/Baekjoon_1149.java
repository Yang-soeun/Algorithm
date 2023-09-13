import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB 거리
 */
public class Baekjoon_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i<N; i++){
            for(int j = 0; j<3; j++){
                if(j == 0)
                    dp[i][j] += Math.min(dp[i-1][1], dp[i-1][2]);
                else if(j == 1)
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][2]);
                else
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }

        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}
