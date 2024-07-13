package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] array1 = br.readLine().toCharArray();
        char[] array2 = br.readLine().toCharArray();
        int len1 = array2.length;
        int len2 = array1.length;
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <len1; i++) {
            for (int j = 0; j <len2; j++) {
                if (array1[j] == array2[i]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        int n = dp[len1][len2];
        sb.append(n);

        if(n == 0){
            System.out.println(sb);
            return;
        }

        sb.append("\n");

        Stack<Character> stack = new Stack<>();
        while(len1>=1 && len2>=1){
            if(dp[len1][len2] == dp[len1-1][len2]){
                len1--;
            }else if(dp[len1][len2] == dp[len1][len2 - 1]){
                len2--;
            }else{
                stack.push(array2[len1-1]);
                len1--;
                len2--;
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
