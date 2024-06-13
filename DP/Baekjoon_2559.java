import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            array[i] = array[i-1] + Integer.parseInt(st.nextToken());
        }

        dp[k] = array[k];
        for(int i = k+1; i<=n; i++){
            dp[i] = Math.max(dp[i-1], array[i] - array[i-k]);
        }

        System.out.println(dp[n]);
    }
}
