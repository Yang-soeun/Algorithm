package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 동전 2
 */
public class Baekjoon_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (coin[i] <= j) {
                    if (j % coin[i] == 0) {
                        dp[j] = j / coin[i];
                        continue;
                    }
                    for (int m = 1; m <= j / coin[i]; m++) {
                        if (dp[j - (coin[i] * m)] != 0) {
                            if (dp[j] != 0) {
                                dp[j] = Math.min(dp[j - (coin[i] * m)] + m, dp[j]);
                            } else {
                                dp[j] = dp[j - (coin[i] * m)] + m;
                            }
                            break;
                        }
                    }
                }
            }
        }

        if (dp[k] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
