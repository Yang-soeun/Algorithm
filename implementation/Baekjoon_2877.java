import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4와 7
 */
public class Baekjoon_2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        String binary = getBinary(K + 1);

        for(int i = binary.length() - 2; i>=0; i--){
            int n = binary.charAt(i) - '0';
            if(n == 0){
                sb.append(4);
            }
            else{
                sb.append(7);
            }
        }

        System.out.println(sb);
    }

    public static String getBinary(int num){
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            sb.append(num%2);
            num = num/2;
        }
        return sb.toString();
    }
}
