import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 */

public class Baekjoon_2630 {
    static int[][] array;
    static int white;
    static int blue;

    public static void partition(int row, int col, int size){
        if (isAllSame(row, col, size)) {
            if (array[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size/2;

        partition(row, col+newSize, newSize);//1사분면
        partition(row,col, newSize);//2사분면
        partition(row+newSize, col, newSize);//3사분면
        partition(row+newSize, col+newSize, newSize);//4사분면
    }

    public static boolean isAllSame(int row, int col, int size) {
        int color = array[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (array[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        sb.append(white + "\n" + blue);
        System.out.println(sb);
    }
}
