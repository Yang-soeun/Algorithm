import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 거스름돈
 * 1000원을 냈을때 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램
 */
public class Baekjoon_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());//지불할 돈
        int n = 1000 - m;//거슬러 줄 돈
        int count = 0; //잔돈의 개수
        int[] array = {500, 100, 50, 10, 5, 1};

        for(int i = 0; i<6; i++){
            while(n-array[i] >=0)
            {
                n = n-array[i];
                count ++;
            }
        }

        System.out.println(count);

    }
}
