package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열
 */
public class Baekjoon_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        List<List<Integer>> path = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            path.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){
            sb.append("1").append("\n");
            sb.append(array[1]);
            System.out.println(sb);
            return;
        }

        dp[1] = 1;
        path.get(0).add(array[1]);
        int pos;
        int maxIndex = 0;
        int max = 0;
        for(int i = 2; i<=n; i++){
            dp[i] = 1;
            pos = i;
            for(int j = i; j>1; j--){
                if(array[i] > array[j-1]){
                    if(dp[i] < dp[j-1] + 1){
                        pos = j-1;
                        dp[i] = dp[j-1] + 1;
                    }
                }
            }
            if(dp[i] >= max){
                max = dp[i];
                maxIndex = i;
            }
            List<Integer> pre = path.get(pos -1);
            path.get(i-1).addAll(pre);
            path.get(i-1).add(array[i]);
        }

        List<Integer> maxPath = path.get(maxIndex-1);
        sb.append(dp[maxIndex]).append("\n");
        for (Integer num : maxPath) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
