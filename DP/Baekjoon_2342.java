package DP;

import java.io.*;
import java.util.Arrays;

/**
 * Dance Dance Revolution
 */
public class Baekjoon_2342 {
    static int[][][] dp;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        pos = new int[split.length -1];

        for(int i = 0; i<split.length-1; i++){
            pos[i] = Integer.parseInt(split[i]);
        }

        dp = new int[5][5][split.length];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(dance(0,0,0));
    }

    static int dance(int left, int right, int cnt){
        if(cnt == pos.length) return 0;

        if(dp[left][right][cnt] != -1) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(dance(pos[cnt], right, cnt + 1) + getPower(left, pos[cnt]),
                dance(left, pos[cnt], cnt +1) + getPower(right, pos[cnt]));
        return dp[left][right][cnt];
    }

    static int getPower(int now, int next){
        int num = Math.abs(now-next);
        if(now == 0) return 2;
        else if(num == 0) return 1;
        else if(num == 1|| num ==3) return 3;
        else return 4;
    }
}
