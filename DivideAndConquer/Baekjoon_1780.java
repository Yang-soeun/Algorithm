package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 별찍기 - 10
 */
public class Baekjoon_1780 {
    static int[][] array;
    static int one;
    static int two;
    static int three;
    public static void partition(int row, int col, int size){
        if (isAllSame(row, col, size)) {
            if (array[row][col] == -1) {
                one++;
            } else if (array[row][col] == 0) {
                two++;
            } else {
                three++;
            }
            return;
        }

        int newSize = size/3;

        partition(row, col, newSize);//1
        partition(row, col+newSize, newSize);//2
        partition(row, col + (2*newSize), newSize);//3
        partition(row+newSize, col, newSize);//4
        partition(row+newSize, col+newSize, newSize);//5
        partition(row+newSize, col + (2*newSize), newSize);//6
        partition(row + (2*newSize), col, newSize );//7
        partition(row + (2*newSize), col + newSize, newSize);//8
        partition(row + (2*newSize), col + (2*newSize), newSize);//9
    }
    public static boolean isAllSame(int row, int col, int size){
        int num = array[row][col];

        for(int i = row; i<row+size; i++){
            for(int j = col; j<col+size; j++){
                if(num != array[i][j])
                    return false;
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

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        sb.append(one + "\n" + two + "\n" + three);
        System.out.println(sb);
    }
}
