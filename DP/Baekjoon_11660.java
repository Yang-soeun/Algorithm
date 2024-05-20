package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 5
 */
public class Baekjoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] array =  new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixsum = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                prefixsum[i][j] = array[i][j] + prefixsum[i][j-1] + prefixsum[i-1][j] - prefixsum[i-1][j-1];
            }
        }

        int count = 0;
        int[][] dp = new int[n+1][n+1];
        while(count != m){
            count++;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            dp[x2][y2] = prefixsum[x2][y2] - prefixsum[x2][y1-1] - prefixsum[x1-1][y2] + prefixsum[x1-1][y1-1];
            sb.append(dp[x2][y2]).append("\n");
        }

        System.out.println(sb);
    }
}
