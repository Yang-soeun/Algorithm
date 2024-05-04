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
        int dp[][] =  new int[N][N];
        boolean visited[][] = new boolean[N][N];

        array[0][0] = dp[0][0] = Integer.parseInt(br.readLine());
        visited[0][0] = true;

        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = true;
            }
        }

        dp[1][0] = dp[0][0] + array[1][0];
        dp[1][1] = dp[0][0] + array[1][1];

        for(int i = 2; i<N; i++){
            for(int j = 0; j<array[i].length; j++){
                if(!visited[i][j])
                    continue;
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][j] + array[i][j], dp[i-1][j] + array[i][j+1]);
                }
                else if(j == N-1 || !visited[i][j+1]){
                    dp[i][j] = dp[i-1][j-1] + array[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1] + array[i][j], dp[i-1][j] + array[i][j]);
                }
            }
        }

        int max = Arrays.stream(dp[N-1]).max().getAsInt();
        System.out.println(max);
    }
}
