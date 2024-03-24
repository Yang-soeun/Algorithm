package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 늑대와 양
 */
public class Baekjoon_16956 {
    static int R;
    static int C;
    static char[][] array;
    static int[] arrX = {-1, 1, 0, 0};
    static int[] arrY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[R][C];

        for(int i = 0; i<R; i++){
            String str = br.readLine();
            for(int j =0; j<C; j++){
                if(str.charAt(j) == '.'){    // .은 전부 울타리 설치
                    array[i][j] = 'D';
                }
                else{
                    array[i][j] = str.charAt(j);
                }
            }
        }

        sb.append("1").append("\n");
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(array[i][j] == 'W'){
                    if(move(i, j) == 0){
                        System.out.println("0");
                        return;
                    }
                }
            }
            sb.append(array[i]).append("\n");
        }

        System.out.println(sb);
    }

    static int move(int x, int y){
        for(int i = 0; i<4; i++){
            int newX = x + arrX[i];
            int newY = y + arrY[i];

            if(newX<0 || newY<0 || newX>=R || newY>=C) continue;
            if(array[newX][newY] == 'S')
                return 0;
        }
        return 1;
    }
}
