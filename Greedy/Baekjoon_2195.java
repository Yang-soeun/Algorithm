import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 복사
 */
public class Baekjoon_2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int count = 1;
        int startIndex = 0;

        for(int i = 0; i< str2.length(); i++){
            if(str1.contains(str2.substring(startIndex,i+1))) continue;
            startIndex = i;
            count++;
        }

        System.out.println(count);
    }
}
