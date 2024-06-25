import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] array;
    static int[] box;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n];
        box = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        getMin(0);
        System.out.println(result);
    }

    public static void getMin(int depth){
        if(depth == n){
     int count = 0;
            int sum = 0;
            int i = 0;
            int total = 0;
            
            while(count != k){
                sum += box[i%n];
                i++;
                if(sum + box[i%n] > m){
                    count ++;
                    total += sum;
                    sum = 0;
                }
            }
            
            result = Math.min(result, total);
            return;
        }

        for(int i = 0; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;
                box[depth] = array[i];
                getMin(depth+1);
                visited[i] = false;
            }
        }
    }
}
