import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            array[i] = array[i-1]+ Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            double diff = end-start+1;
            double sum = array[end] - array[start-1];
            double avg = sum/diff;
            avg = Math.round(avg * 100)/100.0 ;
            sb.append(String.format("%.2f", avg)).append("\n");
        }

        System.out.println(sb);
    }
}
