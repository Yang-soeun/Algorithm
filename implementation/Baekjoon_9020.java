import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드바흐의 추측
 */
public class Baekjoon_9020 {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        getPrime();
        for(int i = 0; i<T; i++){
            sb.append(findPartition(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
    }

    public static String findPartition(int num) {
        int div = num / 2;

        int left = div;
        int right = div;
        while (prime[left] || prime[right]) {
            left--;
            right++;
        }
        return left + " " + right;
    }

    public static void getPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
