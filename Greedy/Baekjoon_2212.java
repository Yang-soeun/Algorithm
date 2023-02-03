import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 센서
 */
public class Baekjoon_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        int n = Integer.parseInt(br.readLine());//센서의 개수
        int k = Integer.parseInt(br.readLine());//집중국의 개수

        int[] distance = new int[n];//센서거리
        Integer[] diff = new Integer[n-1];//센서간의 거리 차이

        //집중국의 개수가 센서의 개수보다 크거나 같으면 0 출력
        if(k>=n){
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++)
            distance[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(distance);//오름차순 정렬

        for(int i=0; i<n-1; i++)
            diff[i] = distance[i+1] - distance[i];

        Arrays.sort(diff, Collections.reverseOrder());


        for(int i = k-1; i< n-1; i++)
            sum += diff[i];

        System.out.println(sum);

    }
}

