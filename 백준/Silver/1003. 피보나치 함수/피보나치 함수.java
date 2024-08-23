import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int[][][] dp;

		for(int i = 0; i<t; i++){
			int n = Integer.parseInt(br.readLine());
			dp = new int[n+2][2][1];
			dp[0][0][0] = dp[1][1][0] = 1;

			for(int j = 2; j<=n; j++){
				dp[j][0][0] = dp[j-1][0][0] + dp[j-2][0][0];
				dp[j][1][0] = dp[j-1][1][0] + dp[j-2][1][0];
			}

			sb.append(dp[n][0][0]).append(" ").append(dp[n][1][0]).append("\n");
		}

		System.out.println(sb);
	}
}
