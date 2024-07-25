import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자두 나무
 */
public class Baekjoon_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[t+1];
        for(int i = 1; i<=t; i++){
            tree[i] = Integer.parseInt(br.readLine()) -1;
        }

        int[][] dp = new int[t+1][w+1];

        dp[1][0] = tree[1]  == 0 ? 1 : 0;
        dp[1][1] = tree[1] == 1 ? 1 : 0;

        for(int i = 1; i<=t; i++){
            dp[i][0] = tree[i] == 1 ? 1 : 0;
        }

        for(int i = 1; i<=t; i++){
            for(int j = 1; j<=w; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + (j%2==tree[i]? 1 : 0);
            }
        }

        int result = 0;
        for(int i = 1; i<=w; i++){
            result = Math.max(result, dp[t][i]);
        }

        System.out.println(result + 1);
    }
}