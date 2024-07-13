package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 가장 긴 감소하는 부분 수열
 */
public class Baekjoon_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n+1];
        int dp[] =  new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = 1;
            for(int j = i; j>=1; j--){
                if(array[i] < array[j-1]){
                    dp[i] = Math.max(dp[i], dp[j-1] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}
