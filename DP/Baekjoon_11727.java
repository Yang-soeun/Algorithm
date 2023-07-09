import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2xn 타일링 2
 */
public class Baekjoon_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[1001];

        array[1] = 1;
        array[2] = 3;

        for(int i = 3; i<=n; i++){
            array[i] = (array[i-1] + 2*array[i-2])%10007;
        }

        System.out.println(array[n]);
    }
}
