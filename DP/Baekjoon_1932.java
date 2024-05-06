package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정수 삼각형
 */

public class Baekjoon_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int array[][] = new int[N][N];
        int dp[][] =  new int[N+1][N+1];

        array[0][0] = dp[1][1] = Integer.parseInt(br.readLine());

        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 2; i<=N; i++){
            for(int j = 1; j<=N; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + array[i-1][j-1];
            }
        }

        int max = Arrays.stream(dp[N]).max().getAsInt();
        System.out.println(max);
    }
}
