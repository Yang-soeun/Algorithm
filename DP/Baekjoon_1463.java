import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 */

public class Baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        if(N==1)
            dp[1] =0;
        if(N >=2)
            dp[2] = 1;
        if(N>=3)
            dp[3] = 1;


        for(int i =4; i<=N; i++){
            if(i%6 == 0){
                dp[i] = Math.min((1 + dp[i-1]), (Math.min((1 + dp[i/3]),  (1 + dp[i/2]))));
            }
            else if(i%3 == 0){
                dp[i] = Math.min((1 + dp[i-1]), (1 + dp[i/3]));
            }
            else if(i%2 == 0){
                dp[i] = Math.min((1 + dp[i-1]), (1 + dp[i/2]));
            }
            else{
                dp[i] = (1 + dp[i-1]);
            }
        }

        System.out.println(dp[N]);
    }
}
