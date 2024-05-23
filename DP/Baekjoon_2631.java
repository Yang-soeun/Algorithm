package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줄세우기
 */
public class Baekjoon_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i<=n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i = 1; i<=n; i++){
            dp[i] = 1;
            for(int j = 1; j<i; j++){
                if(array[j] <= array[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(n-max);
    }
}
