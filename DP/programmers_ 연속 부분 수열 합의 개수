import java.util.*;
class Solution {
    public int solution(int[] elements) {        
        int n = elements.length;
        int max = Arrays.stream(elements).sum();

        boolean[] visited = new boolean[max+1];
        int[] dp = new int[n];
        visited[max] = true;
        int answer = 1;
        int count = 0;
        while(count != n-1){
            for(int i = 0; i<n; i++){
                if(i+count >= n){
                    dp[i] = dp[i] + elements[(i+count) - n];
                }
                else{
                    dp[i] = dp[i] + elements[i+count];
                }
                if(!visited[dp[i]]){
                    answer++;
                }
                visited[dp[i]] = true;
            }
            count ++;
        }
        return answer;
    }
}
