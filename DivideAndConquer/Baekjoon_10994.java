import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 별찍기 - 19
 */
public class Baekjoon_10994 {
    static char star[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int len = 1 + 4*(n-1);

        star = new char[len][len];
        for (char[] chars : star) {
            Arrays.fill(chars, ' ');
        }

        drawStar(0, len);

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void drawStar(int s, int len) {
        for(int i=s; i<len; i++) {
            star[s][i] = '*';
            star[len-1][i] = '*';
            star[i][s] = '*';
            star[i][len-1] = '*';
        }

        if(len == 1) return;

        drawStar(s+2, len-2);
    }
}
