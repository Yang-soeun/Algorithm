package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사2
 */
public class Baekjoon_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[2][1500055];
        int[] dp = new int[1500055];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            array[0][i] = Integer.parseInt(st.nextToken());
            array[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i>=1; i--){
            if(i + array[0][i] > N+1){
                array[1][i] = 0;
            }else{
                break;
            }
        }

        int day = 1 + array[0][1];
        int pos = 1;
        dp[1] = array[1][1];
        int max = dp[1] + array[1][day];

        for(int i = 2; i<=N; i++){
            if(i < day){
                if(max < dp[pos-1] + array[1][i] + array[1][array[0][i] + i]){
                    dp[i] = dp[pos -1] + array[1][i];
                    day = i + array[0][i];
                    pos = i;
                    max = dp[i] + array[1][day];
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
            else{
                dp[i] = dp[pos-1] + array[1][i];
                day = i + array[0][i];
                pos = i;
                max = dp[i] + array[1][day];
            }
        }

        System.out.println(dp[N]);
    }
}
