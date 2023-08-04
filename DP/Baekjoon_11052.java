import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기
 */
public class Baekjoon_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N+1];
        int dp[] = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = array[1];

        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i],dp[i-j] +array[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
