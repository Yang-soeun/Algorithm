package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주
 */
public class Baekjoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1){
            System.out.println(array[1]);
            return;
        }

        dp[1] = array[1];
        dp[2] = array[1] + array[2];

        for(int i = 3; i<=n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + array[i], dp[i-3] + array[i-1] + array[i]));
        }

        System.out.println(dp[n]);
    }
}
