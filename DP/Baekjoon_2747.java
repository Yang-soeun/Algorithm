import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수
 */
public class Baekjoon_2747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];

        array[0] = 0;
        array[1] = 1;

        for(int i = 2; i<=n; i++){
            array[i] = array[i-1] + array[i-2];
        }

        System.out.println(array[n]);
    }
}
