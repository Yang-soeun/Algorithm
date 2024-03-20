package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array1 = br.readLine().toCharArray();
        char[] array2 = br.readLine().toCharArray();
        int dp[][] = new int[array2.length + 1][array1.length + 1];

        for (int i = 0; i <array2.length; i++) {
            for (int j = 0; j <array1.length; j++) {
                if (array2[i] == array1[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[array2.length][array1.length]);
    }
}
