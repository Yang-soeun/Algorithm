import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 초콜릿 식사
 */
public class Baekjoon_2885 {

    static int size = 1;
    public static void size(int K){

        while(size < K){
            size *=2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count =0;

        int K = Integer.parseInt(br.readLine());
        size(K);
        sb.append(size).append(" ");

        while(K > 0){
            if(K>=size)
                K-=size;
            else{
                size/=2;
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
}
