package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿼드 트리
 */
public class Baekjoon_1992 {
    public static int[][] array;
    public static StringBuilder sb = new StringBuilder();
    public static void quadTree(int row, int col, int size){

        if(isAllSame(row, col, size)) {
            sb.append(array[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        quadTree(row, col, newSize);
        quadTree(row, col + newSize, newSize);
        quadTree(row + newSize, col, newSize);
        quadTree(row + newSize, col + newSize, newSize);

        sb.append(')');
    }

    public static boolean isAllSame(int row, int col, int size){

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(array[row][col] != array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);
    }
}
