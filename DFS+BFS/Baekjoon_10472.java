import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 십자 뒤집기
 */
public class Baekjoon_10472{
    static boolean[][] array, input;
    static int result;
    static int[] arrX = {0, 1, 0, -1};
    static int[] arrY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int T = 0;

        while(T<N){
            array = new boolean[3][3];
            input = new boolean[3][3];//모두 흰 배열
            result = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    if (str.charAt(j) == '*') {
                        input[i][j] = true;
                    }
                }
            }

            search(0, 0);
            sb.append(result + "\n");
            T++;
        }

        System.out.println(sb);
    }

    private static void search(int start, int cnt) {
        if (check()) {//모두 흰색이면
            result = Math.min(result, cnt);
            return;
        }

        if (cnt == 9) {
            return;
        }

        for (int i = start; i < 9; i++) {
            int r = i / 3;
            int c = i % 3;

            reverse(r, c);
            search(i + 1, cnt + 1);
            reverse(r, c);
        }
    }

    private static void reverse(int x, int y) {
        array[x][y] = !array[x][y];

        for (int j = 0; j < 4; j++) {//상하좌우 뒤집기
            int newX = arrX[j] + x;
            int newY = arrY[j] + y;

            if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
                array[newX][newY] = !array[newX][newY];
            }
        }
    }

    private static boolean check() {//모두 흰색인지 확인
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}