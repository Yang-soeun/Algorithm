import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] array = new int[41];
        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        for(int i = 0; i<m; i++){
            array[Integer.parseInt(br.readLine())] = 1;
        }

        int count = 0;
        int answer = 1;
        for(int i = 1; i<=n; i++){
            if(array[i] == 1){
                answer *= dp[count];
                count = 0;
                continue;
            }
            count ++;
        }
        answer = answer * dp[count];
        System.out.println(answer);
    }
}
