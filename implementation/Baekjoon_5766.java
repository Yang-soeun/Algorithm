import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 할아버지는 유명해
 */

public class Baekjoon_5766 {
    static int N, M;
    static int twoScore = 0;
    static int twoIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(N!=0 && M!=0){

            int[] player = new int[10001];
            int[] array = new int[10001];

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<M; j++){
                    int pos = Integer.parseInt(st.nextToken());
                    player[pos]++;
                    array[pos]++;
                }
            }

            Integer[] array2 = Arrays.stream(array).boxed().toArray(Integer[] :: new);
            Arrays.sort(array2, Collections.reverseOrder());

            int one = array2[0];

            for (int i = 1; i <= 10000; i++) {
                if (array2[i] < one) {
                    twoIndex = i;
                    twoScore = array2[i];
                    break;
                }
            }

            for (int i = twoIndex; i <= 10000; i++) {
                if (player[i] == twoScore) {
                    sb.append(i + " ");
                }
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append("\n");
        }


        System.out.println(sb);
    }
}
